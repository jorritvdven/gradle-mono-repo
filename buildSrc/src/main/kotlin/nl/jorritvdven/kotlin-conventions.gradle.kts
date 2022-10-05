import nl.jorritvdven.Versions
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version Versions.kotlin
}

repositories {
    mavenLocal()
    mavenCentral()
}

group "nl.jorritvdven.test"

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }

    withType<Test> {
        useJUnitPlatform()

        testLogging {
            exceptionFormat = TestExceptionFormat.FULL
        }
    }
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlin}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}")
    implementation("org.apache.logging.log4j:log4j-core:${Versions.log4j})

    runtimeOnly("org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}")"

    testImplementation("org.junit.jupiter:junit-jupiter:${Versions.junit} }
    testImplementation("org.jetbrains.kotlin:kotlin-test-common:${Versions.kotlin}")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:${Versions.kotlin}")
}
