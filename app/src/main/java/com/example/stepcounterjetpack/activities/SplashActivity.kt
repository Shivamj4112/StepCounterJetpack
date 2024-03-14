package com.example.stepcounterjetpack.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.stepcounterjetpack.R
import com.example.stepcounterjetpack.activities.ui.theme.AppColor
import com.example.stepcounterjetpack.activities.ui.theme.StepCounterJetpackTheme
import com.example.stepcounterjetpack.activities.ui.theme.TileTextFont
import com.example.stepcounterjetpack.composableUI.LottieAnimations
import com.example.stepcounterjetpack.composableUI.SetSystemBarsAppearance
import com.example.stepcounterjetpack.composableUI.SimpleTextComponent
import com.example.stepcounterjetpack.ui.SplashUI
import com.example.stepcounterjetpack.viewModels.SplashViewModel
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

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

