import nl.jorritvdven.Versions

plugins {
    id("nl.jorritvdven.kotlin-conventions")
    id("org.jetbrains.kotlin.plugin.allopen") version Versions.kotlin
}

dependencies {
    implementation("io.quarkus.platform:quarkus-bom:${Versions.quarkus}")
    implementation("io.quarkus:quarkus-micrometer")
    implementation("io.quarkus:quarkus-jackson")
    implementation("io.quarkus:quarkus-vertx")
    implementation("io.quarkus:quarkus-kotlin")
    implementation("io.quarkus:quarkus-arc")
    implementation("io.quarkus:quarkus-oidc")
    implementation("io.quarkus:quarkus-smallrye-openapi")

    implementation("com.fasterxml.jackson.core:jackson-databind:${Versions.jackson}")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:${Versions.jackson}")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:${Versions.jackson}")

    testImplementation("io.quarkus:quarkus-test-oidc-server")
    testImplementation("io.rest-assured:rest-assured:${Versions.restAssured}")
}

allOpen {
    annotation "javax.ws.rs.Path"
    annotation "javax.enterprise.context.ApplicationScoped"
    annotation "io.quarkus.test.junit.QuarkusTest"
}
