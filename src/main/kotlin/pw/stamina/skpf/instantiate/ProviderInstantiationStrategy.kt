package pw.stamina.skpf.instantiate

import pw.stamina.skpf.plugin.PluginProvider
import kotlin.reflect.KClass
import kotlin.reflect.full.isSubclassOf

class ProviderInstantiationStrategy : InstantiationStrategy {

    override fun instantiate(pluginClass: KClass<*>) {
        if (pluginClass.isSubclassOf(PluginProvider::class)) {
            val casted = pluginClass as PluginProvider
        }
    }
}