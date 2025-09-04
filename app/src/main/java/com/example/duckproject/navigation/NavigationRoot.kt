package com.example.duckproject.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.navigation3.ui.rememberSceneSetupNavEntryDecorator
import com.example.duckproject.ui.DuckPhotoViewModel
import com.example.duckproject.ui.views.HomeScreen
import com.example.duckproject.ui.views.ListOfDucksScreen
import com.example.duckproject.ui.views.RandomPhoto
import kotlinx.serialization.Serializable

@Serializable
sealed interface DuckNavScreens{
    @Serializable
    data object HomeScreen: NavKey

    @Serializable
    data object RandomDuckScreen: NavKey

    @Serializable
    data object DuckListScreen: NavKey
}

@Composable
fun NavigationRoot(
    modifier: Modifier = Modifier,
    viewModel: DuckPhotoViewModel = viewModel(factory = DuckPhotoViewModel.Factory)
){
    val backStack = rememberNavBackStack(DuckNavScreens.HomeScreen)

    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        entryDecorators = listOf(
            rememberSavedStateNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator(),
            rememberSceneSetupNavEntryDecorator()
        ),
        entryProvider = { Key ->
            when(Key){
                is DuckNavScreens.HomeScreen -> {
                    NavEntry(
                        key = Key
                    ){
                        HomeScreen(
                            onClickRandom = {backStack.add(DuckNavScreens.RandomDuckScreen)},
                            onClickList = {backStack.add(DuckNavScreens.DuckListScreen)}
                        )
                    }
                }

                is DuckNavScreens.RandomDuckScreen -> {
                    NavEntry(
                        key = Key
                    ){
                        RandomPhoto(
                            duckPhotosUiState = viewModel.duckUiState
                        )
                    }
                }

                is DuckNavScreens.DuckListScreen -> {
                    NavEntry(
                        key = Key
                    ){
                        ListOfDucksScreen(
                            duckPhotosUiState = viewModel.duckListState
                        )
                    }
                }
                else -> throw RuntimeException("Wrong screen")
            }
        }
    )

}