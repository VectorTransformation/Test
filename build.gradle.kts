plugins {
    `java-library`
    kotlin("jvm") version "2.0.0"
    // https://plugins.gradle.org/plugin/io.papermc.paperweight.userdev
    id("io.papermc.paperweight.userdev") version "1.7.1"
}

group = "test"
version = "1.0.0"
val javaVersion = 21
val filePath = ""

dependencies {
    paperweight.paperDevBundle("1.20.6-R0.1-SNAPSHOT")
}

tasks {
    compileJava {
        options.release = javaVersion
    }
    javadoc {
        options.encoding = Charsets.UTF_8.name()
    }
    processResources {
        filteringCharset = Charsets.UTF_8.name()
        expand(
            "name" to project.name,
            "version" to version,
            "description" to "",
            "author" to "",
            "apiVersion" to "1.20.6"
        )
    }
    jar {
        archiveFileName = "${project.name}${if (version == "") version else "-${version}"}.jar"
        if (filePath != "") {
            destinationDirectory.set(File(filePath))
        }
    }
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(javaVersion)
}

kotlin {
    jvmToolchain(javaVersion)
}