package com.example.duckproject.data

import com.example.duckproject.model.RandomDuck
import com.example.duckproject.network.DuckApi

interface DuckPhotosRepository {
    suspend fun getDuck(): RandomDuck

}

class DuckPhotosRepositoryImpl(private val duckApi: DuckApi): DuckPhotosRepository{
    override suspend fun getDuck(): RandomDuck = duckApi.getDuck()

}