import java.util.Properties
import java.io.FileInputStream

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
}

val keystorePropertiesFile = rootProject.file("keys.properties") // trỏ đến file ở thư mục gốc
val keystoreProperties = Properties()

if (keystorePropertiesFile.exists() && keystorePropertiesFile.isFile) {
    try {
        FileInputStream(keystorePropertiesFile).use { fis ->
            keystoreProperties.load(fis)
        }
    } catch (e: Exception) {
        // Xử lý lỗi nếu không đọc được file, ví dụ: throw GradleException
        logger.warn("Could not load keystore properties file: ${keystorePropertiesFile.absolutePath}", e)
    }
} else {
    logger.warn("Keystore properties file not found: ${keystorePropertiesFile.absolutePath}")
}

android {
    namespace = "com.example.travelapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.travelapp"
        minSdk = 24
        //noinspection OldTargetApi
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    flavorDimensions += "environment"
    productFlavors {
        create("dev") {
            dimension = "environment" // Chỉ định dimension (nếu có)
            applicationIdSuffix = ".dev" // Ví dụ: com.example.travelapp.dev
            versionNameSuffix = "-dev"   // Ví dụ: 1.0-dev

            // Giá trị tài nguyên riêng cho DEV (ví dụ: tên ứng dụng)
            resValue("string", "app_name", "[Dev] TravelApp")
        }

        create("uat") {
            dimension = "environment"
            applicationIdSuffix = ".uat" // Ví dụ: com.example.travelapp.uat
            versionNameSuffix = "-uat"   // Ví dụ: 1.0-uat

            // Giá trị tài nguyên riêng cho UAT
            resValue("string", "app_name", "[Uat] TravelApp")
        }

        create("prod") {
            dimension = "environment"

            // Giá trị tài nguyên riêng cho PROD (có thể là tên ứng dụng gốc)
            resValue("string", "app_name", "Travel App") // Hoặc giữ nguyên tên gốc từ strings.xml
        }
    }

    signingConfigs {
        getByName("debug") {
            storeFile = rootProject.file(keystoreProperties.getProperty("releaseStoreFile"))
            storePassword = keystoreProperties.getProperty("releaseStorePassword")
            keyAlias = keystoreProperties.getProperty("releaseKeyAlias")
            keyPassword = keystoreProperties.getProperty("releaseKeyPassword")
        }
        create("release") {
            storeFile = rootProject.file(keystoreProperties.getProperty("debugStoreFile"))
            storePassword = keystoreProperties.getProperty("debugStorePassword")
            keyAlias = keystoreProperties.getProperty("debugKeyAlias")
            keyPassword = keystoreProperties.getProperty("debugKeyPassword")
        }
    }

    buildTypes {
        debug {
            signingConfig = signingConfigs.getByName("debug")
        }

        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
}