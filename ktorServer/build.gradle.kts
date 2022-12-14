plugins {
    application
    kotlin("jvm")
}

group = "com.hiremate.server"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("com.hiremate.server.ApplicationKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(Kotlin.coroutinesCore)
    implementation(Kotlin.serialization)

    with(KtorServer) {
        implementation(core)
        implementation(contentNegotiation)
        implementation(netty)
        implementation(cors)
        implementation(doubleReceive)
        implementation(serialization)
        implementation(webSockets)
        implementation(auth)
        implementation(jwt)
        implementation("io.ktor:ktor-server-config-yaml:${Versions.ktor}")

    }
    implementation(Koin.core)
    implementation(Koin.ktor)

    implementation("ch.qos.logback:logback-classic:${Versions.logback}")

    with(Exposed) {
        implementation(core)
        implementation(dao)
        implementation(jdbc)
    }

    implementation("org.xerial:sqlite-jdbc:3.40.0.0")

    implementation(project(":shared"))
}

tasks {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "16"
        }
    }
}