plugins {
    kotlin("jvm")
}

group = "com.example.detektrules"
version = "1.0.0"

dependencies {
    implementation("io.gitlab.arturbosch.detekt:detekt-api:1.23.8")
    implementation(kotlin("stdlib"))
}

java {
    withSourcesJar()
}

// Позволяет собирать jar-файл с правилами
