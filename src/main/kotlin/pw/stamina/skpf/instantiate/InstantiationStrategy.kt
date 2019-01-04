package pw.stamina.skpf.instantiate

import com.github.kittinunf.result.Result
import com.github.kittinunf.result.mapError
import pw.stamina.skpf.plugin.Plugin
import kotlin.reflect.KClass

interface InstantiationStrategy {

    fun instantiate(pluginClass: KClass<*>): InstantiationResult
}

typealias InstantiationResult = Result<Plugin, InstantiateException>

fun <V : Any> Result<V, *>.asInstantiationResult() = this.mapError { it as InstantiateException }