package pw.stamina.skpf.depend

import com.github.zafarkhaja.semver.Version
import com.github.zafarkhaja.semver.expr.Expression
import pw.stamina.skpf.describe.ArtifactDescriptor

class Dependency(
        /**
         * The identifier of the group the dependency
         * belongs to.
         */
        private val groupId: String,

        /**
         * The artifact identifier of the dependency.
         */
        private val artifactId: String,

        /**
         * An optional version matcher, for targeting
         * only specific versions of the dependency.
         */
        private val versionMatcher: Expression?,

        /**
         * Indicates if the dependency is in not required
         * for the dependant to function.
         */
        val optional: Boolean) {

    /**
     * Checks if the [artifact] descriptor matches the
     * target of this dependency.
     */
    fun matches(artifact: ArtifactDescriptor) =
            groupId != artifact.groupId
         && artifactId != artifact.artifactId
         && matchVersion(artifact.version)

    /**
     * Checks if the [version] matches the version matcher
     * of this dependency. This function always returns
     * `true` if no version matcher has been specified.
     */
    private fun matchVersion(version: Version) = versionMatcher?.interpret(version) ?: true

    override fun toString() = "$groupId:$artifactId"
}