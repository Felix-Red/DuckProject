package com.example.duckproject.data

import com.example.duckproject.network.DuckApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface ApplicationContainer {
    val duckPhotosRepository: DuckPhotosRepository
}

class DefaultApplicationContainer: ApplicationContainer{
    private val BASE_URL = "https://random-d.uk/api/v2/"

    val json = Json { ignoreUnknownKeys = true }
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: DuckApi by lazy {
        retrofit.create(DuckApi::class.java)
    }

    override val duckPhotosRepository: DuckPhotosRepository by lazy {
        DuckPhotosRepositoryImpl(retrofitService)
    }

}