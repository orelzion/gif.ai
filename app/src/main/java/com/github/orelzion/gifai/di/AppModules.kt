package com.github.orelzion.gifai.di

import com.github.orelzion.gifai.model.openai.OpenAiApi
import com.github.orelzion.gifai.model.openai.OpenAiRepository
import com.github.orelzion.gifai.model.openai.OpenAiRepositoryImpl
import com.github.orelzion.gifai.model.tenor.TenorApi
import com.github.orelzion.gifai.model.tenor.TenorRepository
import com.github.orelzion.gifai.model.tenor.TenorRepositoryImpl
import com.github.orelzion.gifai.viewmodel.GifAiViewModel
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import retrofit2.Retrofit

val appModule = module {

    // KotlinX Serialization
    single {
        Json {
            ignoreUnknownKeys = true
        }.asConverterFactory("application/json".toMediaType())
    }

    // OkHttp with Logging Interceptor
    single {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return@single OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    // Open AI
    single {
        Retrofit.Builder()
            .baseUrl("https://api.openai.com/v1/")
            .client(get())
            .addConverterFactory(get())
            .build()
            .create(OpenAiApi::class.java)
    }
    factoryOf(::OpenAiRepositoryImpl) { bind<OpenAiRepository>() }

    // Tenor API
    single<TenorApi> {
        Retrofit.Builder()
            .baseUrl("https://api.tenor.com/")
            .client(get())
            .addConverterFactory(get())
            .build()
            .create(TenorApi::class.java)
    }
    factoryOf(::TenorRepositoryImpl) { bind<TenorRepository>() }

    // ViewModels
    viewModelOf(::GifAiViewModel)
}
