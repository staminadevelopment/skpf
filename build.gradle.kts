import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.2.51"
}

group = "pw.stamina.skpf"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val java_semver_version = "0.9.0"
val junit_jupiter_version = "5.2.0"

dependencies {
    compile(kotlin("stdlib-jdk8"))

    implementation("com.github.zafarkhaja:java-semver:$java_semver_version")

    testCompile("org.junit.jupiter:junit-jupiter-api:$junit_jupiter_version")
    testCompile("org.junit.jupiter:junit-jupiter-engine:$junit_jupiter_version")

    implementation("javax.inject:javax.inject:1")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}