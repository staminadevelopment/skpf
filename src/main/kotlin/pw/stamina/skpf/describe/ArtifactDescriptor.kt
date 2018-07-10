package pw.stamina.skpf.describe

import com.github.zafarkhaja.semver.Version

/**
 * Provides the identifiable information about the plugin.
 */
class ArtifactDescriptor(
        /**
         * The identifier of the group the plugin belongs to.
         */
        val groupId: String,

        /**
         * The plugin artifact identifier.
         */
        val artifactId: String,

        /**
         * The current version of the plugin.
         */
        val version: Version,

        /**
         * An optional friendly name for the plugin.
         */
        val name: String?
)