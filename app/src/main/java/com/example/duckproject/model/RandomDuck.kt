package com.example.duckproject.model

import kotlinx.serialization.Serializable

@Serializable
data class RandomDuck(
    val message: String,
    val url: String
)