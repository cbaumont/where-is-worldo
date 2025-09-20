plugins {
    kotlin("jvm") version "2.2.0"
    application
}

group = "io.github.cbaumont"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

application {
    mainClass = "io.github.cbaumont.AppKt"
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}