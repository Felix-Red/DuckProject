package com.example.duckproject.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.duckproject.DuckApplication
import com.example.duckproject.data.DuckPhotosRepository
import com.example.duckproject.model.ListDucks
import com.example.duckproject.model.RandomDuck
import kotlinx.coroutines.launch
import okio.IOException

sealed interface DuckPhotosUiState{
    data class Success(val photo: RandomDuck): DuckPhotosUiState
    data class ListDuckSuccess(val photo: List<String>): DuckPhotosUiState
    object Error: DuckPhotosUiState
    object Loading: DuckPhotosUiState
}

class DuckPhotoViewModel(
    private val duckPhotosRepository: DuckPhotosRepository
): ViewModel() {
    var duckUiState: DuckPhotosUiState by mutableStateOf(DuckPhotosUiState.Loading)
    var duckListState: DuckPhotosUiState by mutableStateOf(DuckPhotosUiState.Loading)

    init {
        getDuckRandomPhoto()
        getListOfDucks()
    }

    fun getDuckRandomPhoto() = viewModelScope.launch{
        duckUiState = DuckPhotosUiState.Loading
        duckUiState = try {
            DuckPhotosUiState.Success(duckPhotosRepository.getDuck())
        }catch (e: IOException){
            DuckPhotosUiState.Error
        }
    }

    fun getListOfDucks() = viewModelScope.launch {
        duckListState = DuckPhotosUiState.Loading
        var urls = mutableListOf<String>()

       duckListState = try {
           while (urls.size <= 50){
               val duck = duckPhotosRepository.getDuck()
               urls.add(duck.url)
           }
           DuckPhotosUiState.ListDuckSuccess(urls)
       }catch (e: IOException){
           DuckPhotosUiState.Error
       }
    }


    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as DuckApplication)
                val duckPhotosRepository = application.container.duckPhotosRepository
                DuckPhotoViewModel(duckPhotosRepository = duckPhotosRepository)
            }
        }
    }
}