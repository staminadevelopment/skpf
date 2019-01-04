package pw.stamina.skpf.instantiate

class InstantiateException(
        message: String,
        cause: Throwable?
) : Exception(message, cause) {

    constructor(message: String) : this(message, null)
}