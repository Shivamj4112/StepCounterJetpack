package com.example.stepcounterjetpack.view.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.stepcounterjetpack.view.Screen.UserDetailsScreen
import com.example.stepcounterjetpack.view.theme.ui.StepCounterJetpackTheme
import com.example.stepcounterjetpack.viewModels.UserDetailsViewModel

class UserDetailsActivity : ComponentActivity() {

    private val userDetailsViewModel : UserDetailsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            StepCounterJetpackTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

//                    UserDetailsScreen(this,userDetailsViewModel)
                    }
                }

            }
        }
    }

