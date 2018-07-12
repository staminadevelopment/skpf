package pw.stamina.skpf.plugin

import pw.stamina.skpf.describe.PluginDescriptor

interface PluginContainer {

    val plugin: Plugin
    val descriptor: PluginDescriptor

    val loaded: Boolean

    fun load()
    fun unload()

    fun reload() {
        unload()
        load()
    }
}