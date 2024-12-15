import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("jvm") version "2.0.21"
}

group = "com.balloman"
version = "1.0-SNAPSHOT"

java.setTargetCompatibility(22)

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_22
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}