package pw.stamina.skpf

import pw.stamina.skpf.describe.PluginDescriptor

interface PluginContainer {

    val plugin: Any
    val descriptor: PluginDescriptor

    val loaded: Boolean

    fun load()
    fun unload()

    fun reload() {
        unload()
        load()
    }
}