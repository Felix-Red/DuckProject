package com.example.duckproject.ui.views

import androidx.compose.runtime.Composable
import com.example.duckproject.ui.components.ErrorScreen
import com.example.duckproject.ui.components.LoadingScreen
import com.example.duckproject.ui.components.RandomDuckSuccess
import com.example.duckproject.ui.DuckPhotosUiState
import okio.IOException

@Composable
fun RandomPhoto(
    duckPhotosUiState: DuckPhotosUiState
){
    when(duckPhotosUiState){
        is DuckPhotosUiState.Loading -> {
            LoadingScreen()
        }
        is DuckPhotosUiState.Error -> {
            ErrorScreen()
        }
        is DuckPhotosUiState.Success -> {
            RandomDuckSuccess(duckPhotosUiState.photo)
        }
        else -> throw IOException("Might be the internet causing this...")
    }
}

