import org.gradle.accessors.dm.LibrariesForLibs
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.kotlin)
}

repositories {
    mavenLocal()
    mavenCentral()
}

group "cnl.jorritvdven.test"

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
    implementation(libs.kotlin.stdlib)
    implementation(libs.log4j)

    runtimeOnly(libs.kotlin.reflect)

    testImplementation(libs.bundles.kotlin.test)
}
