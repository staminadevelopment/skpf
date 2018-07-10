package pw.stamina.skpf.describe

/**
 * Provides the information necessary for instantiation of
 * the plugin.
 */
class InstantiationDescriptor(
        /**
         * The fully qualified name of the class to be used
         * when instantiating the plugin.
         */
        val mainClass: String,

        /**
         * Specifies what strategy to use when attempting
         * to instantiate the plugin. If none is specified
         * a default strategy should be used.
         */
        val strategy: String?
)