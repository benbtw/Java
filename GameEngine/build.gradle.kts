plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

project.ext.lwjglVersion = "3.3.3"
project.ext.jomlVersion = "1.10.5"
project.ext.lwjglNatives = "natives-macos-arm64"

dependencies {
    implementation platform("org.lwjgl:lwjgl-bom:$lwjglVersion")

    implementation "org.lwjgl:lwjgl"
    implementation "org.lwjgl:lwjgl-assimp"
    implementation "org.lwjgl:lwjgl-glfw"
    implementation "org.lwjgl:lwjgl-nfd"
    implementation "org.lwjgl:lwjgl-openal"
    implementation "org.lwjgl:lwjgl-opengl"
    implementation "org.lwjgl:lwjgl-stb"
    runtimeOnly "org.lwjgl:lwjgl::$lwjglNatives"
    runtimeOnly "org.lwjgl:lwjgl-assimp::$lwjglNatives"
    runtimeOnly "org.lwjgl:lwjgl-glfw::$lwjglNatives"
    runtimeOnly "org.lwjgl:lwjgl-nfd::$lwjglNatives"
    runtimeOnly "org.lwjgl:lwjgl-openal::$lwjglNatives"
    runtimeOnly "org.lwjgl:lwjgl-opengl::$lwjglNatives"
    runtimeOnly "org.lwjgl:lwjgl-stb::$lwjglNatives"
    implementation "org.joml:joml:${jomlVersion}"
}