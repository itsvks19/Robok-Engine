plugins {
    alias(libs.plugins.agp.lib)
    alias(libs.plugins.kotlin)
    id("maven-publish")
}

android {
    namespace = "org.robok.engine.feature.modeling"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
         viewBinding = true
    }
   
    compileOptions {
        sourceCompatibility = JavaVersion.toVersion(libs.versions.android.jvm.get().toInt())
        targetCompatibility = JavaVersion.toVersion(libs.versions.android.jvm.get().toInt())
    }

    kotlinOptions {
        jvmTarget = libs.versions.android.jvm.get()
    }
}

dependencies {
    implementation(fileTree("libs") { include("*.jar") })
    
    implementation(libs.appcompat)
    implementation(libs.material)
    
    implementation(libs.libgdx)
    implementation(libs.libgdx.backend.android)
    implementation("com.badlogicgames.gdx:gdx-platform:1.9.14:natives-armeabi")
    implementation("com.badlogicgames.gdx:gdx-platform:1.9.14:natives-armeabi-v7a")
    implementation("com.badlogicgames.gdx:gdx-platform:1.9.14:natives-x86")
    implementation("com.badlogicgames.gdx:gdx-platform:1.9.14:natives-x86_64")

    implementation(libs.gson)
    
    implementation(project(":core:utils"))
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            groupId = "com.github.robok-engine"
            artifactId = "feature-modeling"
            version  = "0.0.1"
            
            from(components.findByName("release"))
        }
    }
}