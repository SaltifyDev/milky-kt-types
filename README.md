# Milky Types for Kotlin

[![Maven Central](https://img.shields.io/maven-central/v/org.ntqqrev/milky-kt-types?label=Maven%20Central&logo=maven)](https://central.sonatype.com/artifact/org.ntqqrev/milky-kt-types)
![kotlinx-serialization](https://img.shields.io/badge/kotlinx--serialization-1.10.0--RC-blue?logo=kotlin&logoColor=white)

这是 [Milky](https://milky.ntqqrev.org/) 协议的 Kotlin 类型定义包，由[网站](https://milky.ntqqrev.org/raw/kotlin/kotlinx-serialization.txt)自动生成，使用 `kotlinx-serialization` 框架，并由 CI 发布至 Maven Central。

对于 JVM 项目，在 `build.gradle.kts` 中添加以下依赖：

```kotlin
dependencies {
    implementation("org.ntqqrev:milky-kt-types:$version")
}
```

对于 Kotlin Multiplatform 项目，在 `build.gradle.kts` 中添加以下依赖：

```kotlin
kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation("org.ntqqrev:milky-kt-types:$version")
        }
    }
}
```

如有疑问，请在 [Milky 仓库的 Issues](https://github.com/SaltifyDev/milky/issues) 下反馈。
