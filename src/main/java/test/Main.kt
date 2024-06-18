package test

import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    override fun onLoad() {

    }

    override fun onEnable() {
        logger.info("Hello, world!")
    }

    override fun onDisable() {

    }
}
