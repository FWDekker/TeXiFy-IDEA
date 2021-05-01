package nl.hannahsten.texifyidea.action

import com.intellij.execution.RunManager
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.fileEditor.TextEditor
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import nl.hannahsten.texifyidea.TexifyIcons
import nl.hannahsten.texifyidea.run.latex.LatexRunConfiguration
import nl.hannahsten.texifyidea.run.latex.LatexRunConfigurationType
import nl.hannahsten.texifyidea.run.linuxpdfviewer.InternalPdfViewer
import nl.hannahsten.texifyidea.run.pdfviewer.ExternalPdfViewer
import nl.hannahsten.texifyidea.run.pdfviewer.PdfViewer
import nl.hannahsten.texifyidea.util.files.ReferencedFileSetCache
import nl.hannahsten.texifyidea.util.files.psiFile
import nl.hannahsten.texifyidea.util.selectedRunConfig

open class ForwardSearchAction(var viewer: PdfViewer? = null) : EditorAction(
    name = "_Forward Search",
    icon = TexifyIcons.RIGHT
) {

    override fun actionPerformed(file: VirtualFile, project: Project, textEditor: TextEditor) {
        if (viewer == null) return

        if (!viewer!!.isAvailable()) {
            return
        }

        val document = textEditor.editor.document
        val pdf = guessPdfFile(file, project)
        val line = document.getLineNumber(textEditor.editor.caretModel.offset) + 1

        when (viewer) {
            is ExternalPdfViewer -> (viewer as ExternalPdfViewer).forwardSearch(pdf, file.path, line, project, focusAllowed = true)
            is InternalPdfViewer -> (viewer as InternalPdfViewer).conversation!!.forwardSearch(pdf, file.path, line, project, focusAllowed = true)
            else -> return
        }
    }

    override fun update(e: AnActionEvent) {
        e.presentation.isEnabledAndVisible = e.project?.selectedRunConfig()?.pdfViewer == viewer
    }

    /**
     * Guess the path of the pdf to perform forward search to.
     *
     * Looks up the file set for [file] and gets all run configurations that compile a file from this file set.
     * Then guess which of these run configurations actually compile [file], and return the pdf path of this
     * configuration.
     */
    private fun guessPdfFile(file: VirtualFile, project: Project): String? {
        val psiFile = file.psiFile(project) ?: return null
        val fileSet = ReferencedFileSetCache().fileSetFor(psiFile)

        val mainFileCandidates = RunManager.getInstance(project)
            .getConfigurationsList(LatexRunConfigurationType.instance)
            .asSequence()
            .mapNotNull { it as LatexRunConfiguration }
            .filter { it.mainFile?.psiFile(project) in fileSet }

        return mainFileCandidates.firstOrNull()?.outputFilePath
    }
}