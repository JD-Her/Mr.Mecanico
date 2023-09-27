package com.example.mrmecanico.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mrmecanico.main.interaction.ExpedienteState
import com.example.mrmecanico.ui.theme.MrMecanicoTheme
import com.example.mrmecanico.uis.HomeScreen
import com.example.mrmecanico.uis.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MrMecanicoTheme {
                val mainViewModel: MainViewModel = hiltViewModel()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen(
                        expedienteState = mainViewModel.state.value,
                        mainViewModel = mainViewModel,
                        onEvent = {event ->
                            mainViewModel.onEvent(expedienteEvent = event)
                        }
                    )
                    //Lista()
                }
            }
        }
    }
}
