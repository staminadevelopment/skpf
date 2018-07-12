package pw.stamina.skpf.plugin

import pw.stamina.skpf.describe.ArtifactDescriptor
import pw.stamina.skpf.describe.DependenciesDescriptor

interface PluginContainer {

    val plugin: Plugin

    val descriptor: ArtifactDescriptor
    val dependencies: DependenciesDescriptor

    fun isLoaded(): Boolean

    fun load()
    fun unload()

    fun reload() {
        unload()
        load()
    }
}