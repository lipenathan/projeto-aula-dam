plugins {
    alias(libs.plugins.android.application) //declara que este projeto é uma aplicação Android
    alias(libs.plugins.jetbrains.kotlin.android) //adiciona configurações extras para utilizar android + kotlin
}

android {
    namespace = "com.github.lipenathan.aula3"
    compileSdk = 34 //sdk utilizada para realiazr a compilação do nosso projeto

    defaultConfig {
        applicationId = "com.github.lipenathan.aula3" //id da nossa aplicação(mesmo que identifica projeto na play store
        minSdk = 24 //android mínimo aceitado pela nossa aplicação
        targetSdk = 34 //sdk alvo, precisa sempre estar atualizado para as últimas versões android
        versionCode = 1 //versão do app incrementada(cada vez que uma versão sobe para a loja esse número precisa ser único)
        versionName = "1.0" //nome da versão (versão que aparecerá para o usuário)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8 //versão Java utilizada no projeto
        targetCompatibility = JavaVersion.VERSION_1_8
        viewBinding {
            enable = true   //habilita configuração de viewbinding para o projeto
        }
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    //dependências projeto
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0") //biblioteca para chamadas REST
    implementation ("com.google.code.gson:gson:2.11.0") //conversor de json para objetos kotlin/java
    implementation("com.squareup.okhttp3:okhttp:4.12.0") //criador de cliente para envio de requisições http

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}




