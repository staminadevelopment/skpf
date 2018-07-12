import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.2.51"
}

group = "pw.stamina.skpf"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

val java_semver_version = "0.9.0"
val result_version = "1.4.0"

val junit_jupiter_version = "5.2.0"
val mockK_version = "1.8.5"

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

    implementation("com.github.zafarkhaja:java-semver:$java_semver_version")
    implementation("com.github.kittinunf.result:result:$result_version")

    implementation("javax.inject:javax.inject:1")

    // Testing dependencies

    testImplementation("org.junit.jupiter:junit-jupiter-api:$junit_jupiter_version")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:$junit_jupiter_version")

    testImplementation("io.mockk:mockk:$mockK_version")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}