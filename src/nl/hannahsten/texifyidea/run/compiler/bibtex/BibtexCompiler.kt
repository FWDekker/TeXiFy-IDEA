package nl.hannahsten.texifyidea.run.compiler.bibtex

import com.intellij.openapi.roots.ProjectRootManager
import nl.hannahsten.texifyidea.run.step.BibliographyCompileStep
import nl.hannahsten.texifyidea.settings.sdk.LatexSdkUtil

/**
 * @author Sten Wessel
 */
object BibtexCompiler : SupportedBibliographyCompiler("BibTeX", "bibtex") {

    override fun getCommand(step: BibliographyCompileStep): List<String>? {
        val command = mutableListOf<String>()

        val moduleRoots = ProjectRootManager.getInstance(step.configuration.project).contentSourceRoots

        command.apply {
            add(LatexSdkUtil.getExecutableName(executableName, step.configuration.project))

            step.state.compilerArguments?.let { addAll(it.split("""\s+""".toRegex())) }

            // Include files from auxiliary directory on MiKTeX
            if (step.configuration.latexDistribution.isMiktex()) {
                add("-include-directory=${step.configuration.mainFile?.parent?.path ?: ""}")
                addAll(moduleRoots.map { "-include-directory=${it.path}" })
            }

            add(step.configuration.mainFile?.nameWithoutExtension ?: return null)
        }

        return command.toList()
    }
}