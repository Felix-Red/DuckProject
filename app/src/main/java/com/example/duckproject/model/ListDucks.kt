package com.example.duckproject.model

import kotlinx.serialization.Serializable

@Serializable
data class ListDucks(
    val images: List<String>
)