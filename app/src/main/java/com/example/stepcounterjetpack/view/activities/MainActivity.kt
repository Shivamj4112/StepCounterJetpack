package com.example.stepcounterjetpack.view.activities


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.stepcounterjetpack.view.Screen.MainScreen
import com.example.stepcounterjetpack.view.theme.ui.StepCounterJetpackTheme
import com.example.stepcounterjetpack.viewModels.MainViewModel

class MainActivity : ComponentActivity() {

    private val mainViewModel : MainViewModel by viewModels()
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            StepCounterJetpackTheme {

                MainScreen(this,mainViewModel)
            }
        }
    }
}

