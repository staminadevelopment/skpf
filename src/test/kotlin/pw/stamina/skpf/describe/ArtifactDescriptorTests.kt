package pw.stamina.skpf.describe

import com.github.zafarkhaja.semver.Version
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ArtifactDescriptorTests {

    private val groupId = "com.example"
    private val artifactId = "example"
    private val version = "1.0.0"

    private val descriptor = ArtifactDescriptor(groupId, artifactId, Version.valueOf(version))

    @Test
    @DisplayName("toString() -> \"groupId:artifactId:version\"")
    fun toString_shouldReturnFormattedArtifactInformation() {
        assertEquals("$groupId:$artifactId:$version", descriptor.toString())
    }
}