package com.example.duckproject.ui.views

import androidx.compose.runtime.Composable
import com.example.duckproject.ui.components.ErrorScreen
import com.example.duckproject.ui.components.ListOfDucks
import com.example.duckproject.ui.components.LoadingScreen
import com.example.duckproject.ui.DuckPhotosUiState
import okio.IOException

@Composable
fun ListOfDucksScreen(
    duckPhotosUiState: DuckPhotosUiState
){
    when(duckPhotosUiState){
        is DuckPhotosUiState.Loading -> {
            LoadingScreen()
        }
        is DuckPhotosUiState.Error -> {
            ErrorScreen()
        }
        is DuckPhotosUiState.ListDuckSuccess -> {
            ListOfDucks(listDucks = duckPhotosUiState.photo)
        }
        else -> throw IOException("probably network issues")
    }
}