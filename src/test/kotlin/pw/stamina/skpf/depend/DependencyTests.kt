package pw.stamina.skpf.depend

import com.github.zafarkhaja.semver.Version
import com.github.zafarkhaja.semver.expr.Expression
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import pw.stamina.skpf.describe.ArtifactDescriptor

class DependencyTests {

    private val groupId = "com.example"
    private val artifactId = "example"

    private val version = Version.forIntegers(1,0,0)
    private val artifact = ArtifactDescriptor(groupId, artifactId, version)

    @Test
    fun matches_withVersionMatcherAndMatchingIdentifiers_shouldReturnTrueAndCheckArtifactVersion() {
        val versionMatcher = mockk<Expression>()
        every { versionMatcher.interpret(version) } returns true

        val dependency = Dependency(groupId, artifactId, versionMatcher)

        assertTrue(dependency.matches(artifact))
        verify { versionMatcher.interpret(version) }
    }

    @Test
    fun matches_outwithVersionMatcherAndMatchingIdentifiers_shouldReturnTrue() {
        val dependency = Dependency(groupId, artifactId, null)

        assertTrue(dependency.matches(artifact))
    }

    @Test
    fun matches_withMismatchingGroupId_shouldReturnFalse() {
        val dependency = Dependency("_", artifactId, null)

        assertFalse(dependency.matches(artifact))
    }

    @Test
    fun matches_withMismatchingArtifactId_shouldReturnFalse() {
        val dependency = Dependency(groupId, "_", null)

        assertFalse(dependency.matches(artifact))
    }

    @Test
    @DisplayName("toString() -> \"groupId:artifactId\"")
    fun toString_shouldReturnFormattedDependencyTargetInformation() {
        val dependency = Dependency(groupId, artifactId, null)

        assertEquals("$groupId:$artifactId", dependency.toString())
    }
}