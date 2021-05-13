plugins {
    java
    application
}

application {
    mainClass.set("Main")
}

repositories {
    mavenCentral()
}

group = "sd.lab"
version = "1.0.0"

dependencies {
    implementation ("io.javalin", "javalin", "3.13.3")
    implementation ("org.slf4j", "slf4j-simple", "1.7.30")
    implementation ("org.json", "json", "20201115")
    implementation ("com.fasterxml.jackson.core", "jackson-databind", "2.10.3")
    testImplementation ("junit", "junit", "4.13")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

tasks.test {
    useJUnit()
}
