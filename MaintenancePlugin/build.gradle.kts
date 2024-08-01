plugins {
    id("java")
}

group = "de.autismclan"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    compileOnly("io.papermc.paper:paper-api:1.21-R0.1-SNAPSHOT")
    implementation(files("../libs/CommandFrameworkBase-1.0.jar"))
    implementation(files("../libs/CommandFrameworkSpigot-1.0.jar"))
    implementation(files("../AutismCore/build/libs/AutismCore-1.0-SNAPSHOT.jar"))

    compileOnly("org.projectlombok:lombok:1.18.34")
    annotationProcessor("org.projectlombok:lombok:1.18.34")
}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}
