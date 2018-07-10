package pw.stamina.skpf

import pw.stamina.skpf.describe.PluginDescriptor

data class PluginContainer(
        val plugin: Any,
        val descriptor: PluginDescriptor
)