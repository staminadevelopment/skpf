package pw.stamina.skpf.depend

import com.github.zafarkhaja.semver.Version
import com.github.zafarkhaja.semver.expr.Expression
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import pw.stamina.skpf.describe.ArtifactDescriptor

class DependencyTests {

    private val groupId = "com.example"
    private val artifactId = "example"

    private val version = Version.forIntegers(1,0,0)
    private val artifact = ArtifactDescriptor(groupId, artifactId, version)

    @Test
    fun matches_withVersionMatcher_shouldMatchArtifactIdentifiersAndMatchVersion() {
        val versionMatcher = mockk<Expression>()
        every { versionMatcher.interpret(version) } returns true

        val dependency = Dependency(groupId, artifactId, versionMatcher)

        assertTrue(dependency.matches(artifact))
        verify { versionMatcher.interpret(version) }
    }

    @Test
    fun matches_outwithVersionMatcher_shouldMatchArtifactIdentifiersOnly() {
        val dependency = Dependency(groupId, artifactId, null)

        assertTrue(dependency.matches(artifact))
    }

    @Test
    @DisplayName("toString() -> \"groupId:artifactId\"")
    fun toString_shouldPrintFormattedDependencyTargetInformation() {
        val dependency = Dependency(groupId, artifactId, null)

        assertEquals("$groupId:$artifactId", dependency.toString())
    }
}