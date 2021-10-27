package nl.hannahsten.texifyidea.ui.symbols

import nl.hannahsten.texifyidea.lang.commands.LatexCommand
import nl.hannahsten.texifyidea.util.formatAsFileName
import java.util.*

/**
 * Quickly creates a SymbolUiEntry from a command with the following consequences:
 *
 * - By default it generates only the command with slash, this can be changed by setting `generatedLatex`.
 * - The file path is "/nl/hannahsten/texifyidea/symbols/".
 * - The file name is either "math_ENUM-CONSTANT-LOWERCASE.png" for math commands, is
 *      "text_<ENUM-CONSTANT-LOWERCASE>.png" for regular commands, and
 *      "misc_<PACKAGE><FILENAME-SAFE-COMMAND>.png" for other commands. This can be changed by setting `customFileName`.
 * - The description is the command with a slash, can be changed by setting `customDescription`.
 * - Uses the command (in math mode if applicable) to generate the image, can be changed by setting
 *      `customImageLatex`.
 *
 * @author Hannah Schellekens
 */
open class CommandUiEntry(
        command: LatexCommand,
        generatedLatex: String? = null,
        customFileName: String? = null,
        customDescription: String? = null,
        customImageLatex: String? = null
) : SymbolUiEntry {

    override val command: LatexCommand? = command

    override val generatedLatex: String = generatedLatex ?: command.commandWithSlash

    override val fileName = customFileName ?: if (command.isMathMode) {
        "math_${command.identifyer.formatAsFileName()}.png"
    }
    else "text_${command.identifyer.formatAsFileName()}.png"

    override val imagePath = "/nl/hannahsten/texifyidea/symbols/$fileName"

    override val imageLatex = customImageLatex ?: command.commandWithSlash

    override val description = customDescription ?: command.identifyer
        .toLowerCase()
        .replace("_", " ") + if (command.isMathMode) " (math)" else ""

    override val isMathSymbol = command.isMathMode
}