package com.example.stepcounterjetpack.view.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.example.stepcounterjetpack.view.theme.ui.StepCounterJetpackTheme
import com.example.stepcounterjetpack.view.Screen.SetSystemBarsAppearance
import com.example.stepcounterjetpack.view.Screen.SplashUI
import com.example.stepcounterjetpack.viewModels.SplashViewModel

class SplashActivity : ComponentActivity() {

    private lateinit var viewModel: SplashViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            SetSystemBarsAppearance()

            StepCounterJetpackTheme {
                SplashUI()
            }

            viewModel = ViewModelProvider(this)[SplashViewModel::class.java]
            // Call ViewModel method to handle navigation logic
            viewModel.navigateToIntroScreen {
                startActivity(Intent(this@SplashActivity, SelectionLoginActivity::class.java))
                finish()
            }


        }
    }
}

