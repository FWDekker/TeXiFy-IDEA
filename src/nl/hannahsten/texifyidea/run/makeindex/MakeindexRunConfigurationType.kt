package nl.hannahsten.texifyidea.run.makeindex

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationType
import nl.hannahsten.texifyidea.TexifyIcons
import nl.hannahsten.texifyidea.run.latex.LatexConfigurationFactory
import javax.swing.Icon

/**
 * todo
 */
class MakeindexRunConfigurationType : ConfigurationType {

    override fun getIcon(): Icon = TexifyIcons.BUILD

    override fun getConfigurationTypeDescription() = "Run makeindex"

    override fun getId() = "MAKEINDEX_RUN_CONFIGURATION"

    override fun getDisplayName() = "Makeindex"

    override fun getConfigurationFactories(): Array<ConfigurationFactory> = arrayOf(LatexConfigurationFactory(this))
}
