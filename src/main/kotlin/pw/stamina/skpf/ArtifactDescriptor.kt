package pw.stamina.skpf

import com.github.zafarkhaja.semver.Version

data class ArtifactDescriptor(
        val groupId: String,
        val artifactId: String,
        val version: Version,
        val name: String?
)