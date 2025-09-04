package com.example.duckproject.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onClickRandom: () -> Unit,
    onClickList: () -> Unit
){
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = onClickRandom
        ) {
            Text(
                text = "Random Duck"
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = onClickList
        ) {
            Text(
                text = "List of Ducks"
            )
        }

    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    //HomeScreen()
}