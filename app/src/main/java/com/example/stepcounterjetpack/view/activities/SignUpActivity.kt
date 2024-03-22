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
import com.example.stepcounterjetpack.view.Screen.SignupScreen
import com.example.stepcounterjetpack.view.theme.ui.StepCounterJetpackTheme
import com.example.stepcounterjetpack.viewModels.SignupViewModel

class SignUpActivity : ComponentActivity() {

    private val signupViewModel: SignupViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            StepCounterJetpackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SignupScreen(this,signupViewModel)
                }

            }
        }
    }
}


