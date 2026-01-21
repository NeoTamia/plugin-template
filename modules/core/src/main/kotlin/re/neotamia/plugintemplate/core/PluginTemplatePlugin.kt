package re.neotamia.plugintemplate.core

import org.bukkit.plugin.java.JavaPlugin

class PluginTemplatePlugin : JavaPlugin() {
    override fun onEnable() {
        logger.info("PluginTemplatePlugin has been enabled!")
    }

    override fun onDisable() {
        logger.info("PluginTemplatePlugin has been disabled!")
    }
}
