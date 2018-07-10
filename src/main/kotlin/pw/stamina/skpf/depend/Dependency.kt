package pw.stamina.skpf.depend

import com.github.zafarkhaja.semver.expr.Expression

class Dependency(

    val groupId: String,

    val artifactId: String,

    val version: Expression,

    val optional: Boolean
)