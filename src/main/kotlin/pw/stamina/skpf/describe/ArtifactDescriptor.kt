package pw.stamina.skpf.describe

import com.github.zafarkhaja.semver.Version

data class ArtifactDescriptor(
        val groupId: String,
        val artifactId: String,
        val version: Version,
        val name: String?
)