package com.mehedi.bottomnavcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.mehedi.bottomnavcompose.presentation.bottomnav.MainScreen
import com.mehedi.bottomnavcompose.presentation.grid.ScrollableMultipleGrids
import com.mehedi.bottomnavcompose.ui.theme.BottomNavComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BottomNavComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Box(modifier = Modifier.padding(innerPadding)) {

                        //   ScrollableMultipleGrids()

                        MainScreen()
                    }

                }
            }
        }
    }
}
