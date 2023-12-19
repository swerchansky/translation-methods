plugins {
    kotlin("jvm") version "1.9.0"
    application
    antlr
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    antlr("org.antlr:antlr4:4.11.1")
    implementation("io.github.rchowell:dotlin:1.0.2")
    testImplementation(kotlin("test"))
}

tasks.compileKotlin {
    dependsOn(tasks.generateGrammarSource)
}

tasks.compileTestKotlin {
    dependsOn(tasks.generateGrammarSource)
}

tasks.generateGrammarSource {
    maxHeapSize = "64m"
    arguments = arguments + listOf("-visitor")
    doLast {
        copy {
            from("${buildDir}/generated-src/antlr/main")
            into("src/main/kotlin/antlrgenerated")
        }
    }
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}