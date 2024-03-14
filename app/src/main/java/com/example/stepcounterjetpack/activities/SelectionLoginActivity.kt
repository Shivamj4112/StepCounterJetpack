package com.example.stepcounterjetpack.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.stepcounterjetpack.activities.ui.theme.StepCounterJetpackTheme
import com.example.stepcounterjetpack.composableUI.StatusBarColorWhite
import com.example.stepcounterjetpack.ui.SelectionLoginScreen

class SelectionLoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StatusBarColorWhite()
            StepCounterJetpackTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SelectionLoginScreen()
                }
            }
        }
    }
}

