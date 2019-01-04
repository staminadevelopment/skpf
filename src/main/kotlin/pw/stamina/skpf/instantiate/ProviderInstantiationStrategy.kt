package pw.stamina.skpf.instantiate

import com.github.kittinunf.result.Result
import com.github.kittinunf.result.map
import pw.stamina.skpf.plugin.PluginProvider
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.isSubclassOf

class ProviderInstantiationStrategy : InstantiationStrategy {

    override fun instantiate(pluginClass: KClass<*>) =
            Result.of(pluginClass)
                  .asInstantiationResult()
                  .map(this::getProviderClass)
                  .map(this::instantiateProvider)
                  .map(this::extractPluginFromProvider)

    private fun getProviderClass(pluginClass: KClass<*>) =
        if (pluginClass.isSubclassOf(PluginProvider::class)) {
            @Suppress("UNCHECKED_CAST")
            pluginClass as KClass<PluginProvider>
        } else {
            throw InstantiateException("the class is not a subclass of PluginProvider")
        }

    private fun instantiateProvider(providerClass: KClass<PluginProvider>) =
        try {
            providerClass.createInstance()
        } catch (e: Exception) {
            throw InstantiateException("could not instantiate the provider:", e)
        }

    private fun extractPluginFromProvider(provider: PluginProvider) =
        try {
            provider.providePlugin()
        } catch (e: Exception) {
            throw InstantiateException("an exception occurred while providing the plugin:", e)
        }
}