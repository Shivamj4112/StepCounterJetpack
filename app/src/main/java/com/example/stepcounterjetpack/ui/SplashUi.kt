package com.example.stepcounterjetpack.ui

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
import com.example.stepcounterjetpack.R
import com.example.stepcounterjetpack.activities.ui.theme.AppColor
import com.example.stepcounterjetpack.activities.ui.theme.StepCounterJetpackTheme
import com.example.stepcounterjetpack.activities.ui.theme.TileTextFont
import com.example.stepcounterjetpack.composableUI.LottieAnimations
import com.example.stepcounterjetpack.composableUI.SimpleTextComponent
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Composable
fun SplashUI() {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(AppColor),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Image(
                    modifier = Modifier
                        .size(200.sdp),
                    painter = painterResource(id = R.drawable.ic_footsteps),
                    contentDescription = "Splash Image"
                )
                SimpleTextComponent(
                    text = "TrackFit",
                    fontFamily = TileTextFont,
                    textSize = 25.ssp,
                    textColor = Color.White,
                    paddingTop = 20.sdp
                )
            }

            Box(modifier = Modifier.size(80.sdp)) {
                LottieAnimations(rawResId = R.raw.ic_white_loader)
            }
        }

    }



}

@Preview
@Composable
fun GreetingPreview() {
    StepCounterJetpackTheme {
        SplashUI()
    }
}