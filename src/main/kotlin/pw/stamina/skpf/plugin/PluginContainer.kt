package pw.stamina.skpf.plugin

import pw.stamina.skpf.describe.PluginDescriptor

interface PluginContainer {

    val plugin: Plugin
    val descriptor: PluginDescriptor

    fun isLoaded(): Boolean

    fun load()
    fun unload()

    fun reload() {
        unload()
        load()
    }
}