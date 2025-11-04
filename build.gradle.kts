@file:OptIn(ExperimentalWasmDsl::class)

import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    kotlin("multiplatform") version "2.2.21"
    kotlin("plugin.serialization") version "2.2.21"
    id("com.vanniktech.maven.publish") version "0.34.0"
}

group = "org.ntqqrev"
version = "1.0.0"

repositories {
    mavenCentral()
}

kotlin {
    androidNativeArm32()
    androidNativeArm64()
    androidNativeX64()
    androidNativeX86()
    iosArm64()
    iosSimulatorArm64()
    iosX64()
    js(IR) {
        browser()
        nodejs()
    }
    jvm()
    linuxArm64()
    linuxX64()
    macosArm64()
    macosX64()
    mingwX64()
    tvosArm64()
    tvosSimulatorArm64()
    tvosX64()
    wasmJs {
        browser()
        nodejs()
        d8()
    }
    wasmWasi {
        nodejs()
    }
    watchosArm32()
    watchosArm64()
    watchosDeviceArm64()
    watchosSimulatorArm64()
    watchosX64()

    sourceSets {
        commonMain.dependencies {
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.9.0")
        }
    }

    jvmToolchain(21)
}

mavenPublishing {
    publishToMavenCentral()
    signAllPublications()
    coordinates(
        groupId = project.group.toString(),
        artifactId = project.name,
        version = project.version.toString()
    )

    pom {
        name = project.name
        description = "Type definition for Milky protocol"
        url = "https://milky.ntqqrev.org/"
        inceptionYear = "2025"
        licenses {
            license {
                name = "MIT License"
                url = "https://opensource.org/licenses/MIT"
            }
        }
        developers {
            developer {
                id = "Wesley-Young"
                name = "Wesley F. Young"
                email = "wesley.f.young@outlook.com"
            }
        }
        scm {
            connection = "scm:git:git://github.com/SaltifyDev/milky-kt-types.git"
            developerConnection = "scm:git:ssh://github.com/SaltifyDev/milky-kt-types.git"
            url = "https://github.com/SaltifyDev/milky-kt-types"
        }
    }
}