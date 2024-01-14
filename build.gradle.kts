import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.10"
    id("com.diffplug.spotless") version "6.22.0"
    id("info.solidsoft.pitest") version "1.15.0"
    application
}

group = "com.isamadrid90.demo"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:6.22.0")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
}
application {
    mainClass.set("com.isamadrid90.demo.GildedRoseKt")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

spotless {
    kotlin {
        ktlint()
            .userData(
                mapOf(
                    "insert_final_newline" to "true",
                ),
            )
    }
    kotlinGradle {
        ktlint()
    }
}

tasks.check {
    dependsOn(tasks.spotlessCheck)
}

pitest {
    setProperty("junit5PluginVersion", "1.2.1")
    setProperty("testPlugin", "junit5")
    setProperty("targetClasses", listOf("com.isamadrid90.demo.*"))
    setProperty("outputFormats", listOf("HTML"))
    setProperty("threads", 2)
    setProperty("withHistory", true)
}
