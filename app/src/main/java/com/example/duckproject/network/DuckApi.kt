package com.example.duckproject.network

import com.example.duckproject.model.ListDucks
import com.example.duckproject.model.RandomDuck
import retrofit2.http.GET

interface DuckApi {
    @GET("random")
    suspend fun getDuck(): RandomDuck
}