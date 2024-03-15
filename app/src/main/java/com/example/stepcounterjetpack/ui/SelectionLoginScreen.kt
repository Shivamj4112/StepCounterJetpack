package com.example.stepcounterjetpack.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import com.example.stepcounterjetpack.R
import com.example.stepcounterjetpack.activities.ui.theme.AppColor
import com.example.stepcounterjetpack.activities.ui.theme.BodyTextFont
import com.example.stepcounterjetpack.activities.ui.theme.DefaultTextColor
import com.example.stepcounterjetpack.activities.ui.theme.LightestAppColor
import com.example.stepcounterjetpack.activities.ui.theme.StepCounterJetpackTheme
import com.example.stepcounterjetpack.activities.ui.theme.TitleTextFont
import com.example.stepcounterjetpack.composableUI.SimpleButton
import com.example.stepcounterjetpack.composableUI.SimpleTextComponent
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Composable
fun SelectionLoginScreen() {

    Column ( modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally){

        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        )

        {

            Image(
                painter = painterResource(id = R.drawable.ic_footsteps),
                contentDescription = null,
                modifier = Modifier.size(50.sdp),
            )

            SimpleTextComponent(
                text = "Let's Get Started!",
                textColor = Color.Black,
                textSize = 25.ssp,
                fontFamily = TitleTextFont,
                paddingTop = 30.sdp
            )

            SimpleTextComponent(
                text = "Let's dive in into yoru account",
                paddingTop = 15.sdp,
                fontFamily = BodyTextFont,
                textSize = 12.ssp
            )


            SignCard(text = "Continue with Google", paddingTop = 40.sdp, src = R.drawable.ic_google)
            SignCard(text = "Continue with Apple", src = R.drawable.ic_apple)
            SignCard(text = "Continue with Facebook", src = R.drawable.ic_facebook)
            SignCard(text = "Continue with Twitter", src = R.drawable.ic_twitter)


            SimpleButton(
                text = "Sign Up",
                paddingTop = 30.sdp,
                paddingHorizontal = 15.sdp,
                textColor = Color.White,
                textSize = 13.ssp,
                fontFamily = TitleTextFont
            ) {}

            SimpleButton(
                text = "Login",
                paddingTop = 10.sdp,
                paddingHorizontal = 15.sdp,
                textColor = AppColor,
                textSize = 13.ssp,
                backGroundColor = LightestAppColor,
                fontFamily = TitleTextFont
            ) {}
        }

        Row (
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.sdp)
                .padding(bottom = 10.sdp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically){

            SimpleTextComponent(text = "Privacy Policy ", textSize = 10.ssp)
            SimpleTextComponent(text = "   |   ", textSize = 10.ssp)
            SimpleTextComponent(text = "Terms and Service", textSize = 10.ssp)
        }
    }

}

@Composable
fun SignCard(
    text: String,
    textSize: TextUnit = 13.ssp,
    padding: Dp = 0.sdp,
    paddingVertical: Dp = 0.sdp,
    paddingHorizontal: Dp = 15.sdp,
    paddingStart: Dp = 0.sdp,
    paddingTop: Dp = 10.sdp,
    paddingEnd: Dp = 0.sdp,
    paddingBottom: Dp = 0.sdp,
    fontFamily: FontFamily? = TitleTextFont,
    cardCornerShape: Dp = 20.sdp,
    textColor: Color = DefaultTextColor,
    src: Int,
    cardBackgroundColor: Color = Color.White
) {

    ElevatedCard(
        modifier = Modifier
            .padding(padding)
            .padding(paddingHorizontal, paddingVertical)
            .padding(paddingStart, paddingTop, paddingEnd, paddingBottom),
        shape = RoundedCornerShape(cardCornerShape),
        colors = CardDefaults.elevatedCardColors(
            containerColor = cardBackgroundColor,
        ),
        elevation = CardDefaults.cardElevation(1.sdp)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 13.sdp, vertical = 10.sdp)
                .fillMaxWidth()
                .height(20.sdp)
        ) {

            Box(modifier = Modifier.fillMaxSize()) {

                Image(
                    painter = painterResource(id = src),
                    contentDescription = null,
                    modifier = Modifier.size(20.sdp),
                )

                Box(
                    Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    SimpleTextComponent(text = text, textSize = textSize, fontFamily = fontFamily)
                }

            }


        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun SelectionLoginScreenPreview() {
    StepCounterJetpackTheme {
        SelectionLoginScreen()
    }
}
