package pw.stamina.skpf.depend

import com.github.zafarkhaja.semver.expr.Expression

class Dependency(

    val groupId: String,

    val artifactId: String,

    val versionMatcher: Expression?,

    val optional: Boolean
)