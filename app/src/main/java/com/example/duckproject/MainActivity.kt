package com.example.duckproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.duckproject.navigation.NavigationRoot
import com.example.duckproject.ui.theme.DuckProjectTheme


/**
 * Random ducks project
 *
 * Your landing screen should have two buttons:
 *
 * 1. Random duck: Fetches a random duck and displays on the UI
 * 2. Second button takes you to a new screen, where you must display a list of 10 ducks, it should fire off multiple calls (asynchronously), and fetch the list of images of ducks
 *
 * Bonus points:
 *
 * - Responsive to portrait and landscape mode,
 * - Swap between light and dark mode.
 * - Caters for difference devices screen sizes
 * - Could look at some websites to get inspired by designs
 *
 * Consider using version control. Remember to update your github telling people about your project. It is a good addition to add to your portfolio!
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DuckProjectTheme {
                Surface{
                    NavigationRoot()
                }
            }
        }
    }
}



