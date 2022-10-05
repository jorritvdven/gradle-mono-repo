plugins {
    id("nl.jorritvdven.kotlin-conventions")
    alias(libs.plugins.kotlin)
    alias(libs.plugins.kotlin.allopen)
}

dependencies {
    implementation(enforcedPlatform(libs.quarkus.bom))
    implementation(libs.bundles.quarkus)
    implementation(libs.bundles.jackson)
    implementation(libs.typesafe.config)
    implementation(libs.kotlin.coroutines)

    testImplementation(libs.quarkus.junit5)
    testImplmentation(libs.quarkus.test.oidc.server)
    testImplementation(libs.restassured)
}

allOpen {
    annotation "javax.ws.rs.Path"
    annotation "javax.enterprise.context.ApplicationScoped"
    annotation "io.quarkus.test.junit.QuarkusTest"
}
