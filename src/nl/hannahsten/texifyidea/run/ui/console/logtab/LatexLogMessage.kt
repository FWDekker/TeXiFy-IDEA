package nl.hannahsten.texifyidea.run.ui.console.logtab

import com.intellij.openapi.vfs.VirtualFile
import com.intellij.util.ui.MessageCategory
import nl.hannahsten.texifyidea.util.capitalizeFirst
import java.util.*

data class LatexLogMessage(val message: String, val fileName: String? = null, val line: Int = -1, val type: LatexLogMessageType = LatexLogMessageType.ERROR, val file: VirtualFile? = null) {

    fun toTreeViewString(): String {
        val typeString = type.toString().lowercase(Locale.getDefault()).capitalizeFirst()
        val lineString = if (line >= 0) "line ($line)" else ""
        return "$typeString:$lineString $message"
    }
}

enum class LatexLogMessageType(val category: Int) {

    ERROR(MessageCategory.ERROR),
    WARNING(MessageCategory.WARNING),
}