package com.example.stepcounterjetpack.view.Screen

import android.app.Activity
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.stepcounterjetpack.view.activities.ui.theme.AppColor
import com.example.stepcounterjetpack.view.activities.ui.theme.BodyTextFont
import com.example.stepcounterjetpack.view.activities.ui.theme.DefaultTextColor
import com.example.stepcounterjetpack.view.activities.ui.theme.LightestAppColor
import com.example.stepcounterjetpack.view.activities.ui.theme.StepCounterJetpackTheme
import com.example.stepcounterjetpack.view.activities.ui.theme.TitleTextFont
import com.example.stepcounterjetpack.viewModels.SelectionViewModel
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Composable
fun SelectionLoginScreen(context: Activity, selectionViewModel: SelectionViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 15.sdp)
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
                modifier = Modifier,
                text = "Let's Get Started!",
                textColor = Color.Black,
                textSize = 25.ssp,
                fontFamily = TitleTextFont.fontFamily,
                paddingTop = 20.sdp
            )

            SimpleTextComponent(
                modifier = Modifier,
                text = "Let's dive in into yoru account",
                paddingTop = 15.sdp,
                fontFamily = BodyTextFont,
                textSize = 12.ssp
            )


            SignCardsList()

            SimpleButton(
                text = "Sign Up",
                paddingTop = 20.sdp,
                textColor = Color.White,
                textSize = 13.ssp,
                fontFamily = TitleTextFont.fontFamily,
                onClick = {
                    selectionViewModel.selectionSignup(context = context) {

                    }
                }
            )

            SimpleButton(
                text = "Login",
                paddingTop = 10.sdp,
                textColor = AppColor,
                textSize = 13.ssp,
                backGroundColor = LightestAppColor,
                fontFamily = TitleTextFont.fontFamily
            ) {}
        }

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.sdp)
                .padding(bottom = 10.sdp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            SimpleTextComponent(modifier = Modifier, text = "Privacy Policy ", textSize = 10.ssp)
            SimpleTextComponent(modifier = Modifier, text = "   |   ", textSize = 10.ssp)
            SimpleTextComponent(modifier = Modifier, text = "Terms and Service", textSize = 10.ssp)
        }
    }
}

@Composable
fun SignCardsList() {
    LazyColumn() {
        item {
            SignCard(
                text = "Continue with Google",
                paddingTop = 30.sdp,
                src = R.drawable.ic_google,
                textSize = 12.ssp
            )
        }
        item {
            SignCard(text = "Continue with Apple", src = R.drawable.ic_apple, textSize = 12.ssp)
        }
        item {
            SignCard(
                text = "Continue with Facebook",
                src = R.drawable.ic_facebook,
                textSize = 12.ssp
            )
        }
        item {
            SignCard(
                text = "Continue with Twitter",
                src = R.drawable.ic_twitter,
                textSize = 12.ssp,
                paddingBottom = 10.sdp
            )
        }
    }
}


@Composable
fun SignCard(
    text: String,
    textSize: TextUnit = 13.ssp,
    padding: Dp = 0.sdp,
    paddingVertical: Dp = 0.sdp,
    paddingHorizontal: Dp = 0.sdp,
    paddingStart: Dp = 0.sdp,
    paddingTop: Dp = 10.sdp,
    paddingEnd: Dp = 0.sdp,
    paddingBottom: Dp = 0.sdp,
    fontFamily: FontFamily? = TitleTextFont.fontFamily,
    cardCornerShape: Dp = 20.sdp,
    textColor: Color = DefaultTextColor,
    src: Int,
    cardBackgroundColor: Color = Color.White
) {

    ElevatedCard(
        modifier = Modifier
            .wrapContentHeight()
            .padding(padding)
            .padding(paddingHorizontal, paddingVertical)
            .padding(paddingStart, paddingTop, paddingEnd, paddingBottom),
        shape = RoundedCornerShape(cardCornerShape),
        colors = CardDefaults.elevatedCardColors(
            containerColor = cardBackgroundColor,
        ),
        elevation = CardDefaults.cardElevation(4.sdp)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 13.sdp, vertical = 10.sdp)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {

            Box(modifier = Modifier.fillMaxWidth()) {

                Image(
                    painter = painterResource(id = src),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.sdp)
                        .align(Alignment.CenterStart),
                )
                SimpleTextComponent(
                    modifier = Modifier.align(Alignment.Center),
                    text = text,
                    textSize = textSize,
                    fontFamily = fontFamily,
                    paddingVertical = 10.sdp
                )

            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun SelectionLoginScreenPreview() {
    StepCounterJetpackTheme {
//        SelectionLoginScreen()
    }
}
