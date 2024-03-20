package com.example.stepcounterjetpack.view.Screen

import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.stepcounterjetpack.R
import com.example.stepcounterjetpack.view.activities.ui.theme.AppColor
import com.example.stepcounterjetpack.view.activities.ui.theme.BodyTextFont
import com.example.stepcounterjetpack.view.activities.ui.theme.TitleTextFont
import com.example.stepcounterjetpack.viewModels.LoginViewModel
import com.example.stepcounterjetpack.viewModels.SignupViewModel
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Composable
fun LoginScreen(context: Activity, loginViewModel: LoginViewModel) {

    Scaffold(
        topBar = {
            AppToolBar(
                size = 20.sdp, onClick = {

                })
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 15.sdp)
        ) {
            val scrollsState = rememberScrollState()
            Column(
                modifier = Modifier
                    .verticalScroll(scrollsState)
                    .fillMaxHeight()
                    .weight(1f)
            )
            {

                SimpleTextComponent(
                    modifier = Modifier,
                    text = "Welcome Back",
                    fontFamily = TitleTextFont.fontFamily,
                    textColor = TitleTextFont.color,
                    textSize = 24.ssp
                )
                SimpleTextComponent(
                    modifier = Modifier.padding(top = 10.sdp),
                    text = "Login your account and start tracking your steps.",
                    textAlign = TextAlign.Start,
                    textSize = 14.ssp,
                )

                LayoutEditText()


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.sdp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                    SimpleTextComponent(
                        modifier = Modifier,
                        text = "Create your account? ",
                        textSize = 12.ssp,
                        fontFamily = BodyTextFont
                    )
                    ClickableTextComponent(
                        modifier = Modifier,
                        text = "Sign up",
                        textColor = AppColor,
                        fontFamily = BodyTextFont,
                        textSize = 12.ssp,
                        onClick = {
                            loginViewModel.navigateToSignup(context = context) {}
                        }
                    )
                }

                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 30.sdp, bottom = 20.sdp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Divider(Modifier.weight(1f))
                    SimpleTextComponent(
                        modifier = Modifier.padding(horizontal = 10.sdp),
                        text = "or",
                        fontFamily = BodyTextFont
                    )
                    Divider(Modifier.weight(1f))
                }

                SignCard(
                    modifier = Modifier.padding(bottom = 10.sdp),
                    text = "Continue with Google",
                    src = R.drawable.ic_google,
                    textSize = 12.ssp
                )
                SignCard(modifier = Modifier.padding(bottom = 10.sdp),text = "Continue with Apple", src = R.drawable.ic_apple, textSize = 12.ssp)
                SignCard(
                    modifier = Modifier.padding(bottom = 10.sdp),
                    text = "Continue with Facebook",
                    src = R.drawable.ic_facebook,
                    textSize = 12.ssp
                )
                SignCard(
                    modifier = Modifier.padding(bottom =  15.sdp),
                    text = "Continue with Twitter",
                    src = R.drawable.ic_twitter,
                    textSize = 12.ssp,
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.sdp)
            ) {

                SimpleButton(text = "Login", textColor = Color.White) {

                }
            }


        }
    }
}

@Composable
private fun LayoutEditText() {

    //TODO       TextField Email
    SimpleTextComponent(
        modifier = Modifier.padding(top = 20.sdp),
        text = "Email",
        fontFamily = TitleTextFont.fontFamily,
        textSize = 15.ssp
    )

    var email by remember { mutableStateOf("") }

    SimpleEditText(
        modifier = Modifier.fillMaxWidth().padding(top = 5.sdp),
        hint = "Enter Email",
        onTextChange = { tfEmail ->
            email = tfEmail
        })


    //TODO       TextField Password
    SimpleTextComponent(
        modifier = Modifier.padding(top = 10.sdp),
        text = "Password",
        fontFamily = TitleTextFont.fontFamily,
        textSize = 15.ssp
    )
    var password by remember { mutableStateOf("") }
    SimpleEditText(modifier = Modifier.fillMaxWidth().padding(top = 5.sdp),hint = "Enter Password", onTextChange = { tfPassword ->
        password = tfPassword
    })
}
@Preview
@Composable
fun LoginScreenPreview() {
//    LoginScreen()
}