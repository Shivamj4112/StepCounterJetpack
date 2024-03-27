package com.example.stepcounterjetpack.view.Screen

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.example.stepcounterjetpack.view.activities.theme.ui.AppColor
import com.example.stepcounterjetpack.view.activities.theme.ui.BodyTextFont
import com.example.stepcounterjetpack.view.activities.theme.ui.TitleTextFont
import com.example.stepcounterjetpack.viewModels.LoginViewModel
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Composable
fun LoginScreen(context: Activity, loginViewModel: LoginViewModel) {


    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    fun areFieldsValid() : Boolean {
        return email.isNotEmpty() && password.isNotEmpty()
    }

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

                LayoutEditText(onEmailChange = { email = it }, onPasswordChange = { password = it })


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

                SimpleButton(modifier = Modifier.height(25.sdp), text = "Login", textColor = Color.White,

                    onClick = {
                        if (areFieldsValid()){
                            loginViewModel.loginAccount(context, email, password)
                        }
                        else{
                            Toast.makeText(context, "Please fill all field", Toast.LENGTH_SHORT).show()
                        }
                    }
                )
            }


        }
    }
}

@Composable
private fun LayoutEditText(
    onEmailChange: (String) -> Unit,
                           onPasswordChange: (String) -> Unit) {

    //TODO       TextField Email
    SimpleTextComponent(
        modifier = Modifier.padding(top = 20.sdp),
        text = "Email",
        fontFamily = TitleTextFont.fontFamily,
        textSize = 15.ssp
    )


    SimpleEditText(
        modifier = Modifier.fillMaxWidth().padding(top = 5.sdp),
        hint = "Enter Email",
        onTextChange = onEmailChange)


    //TODO       TextField Password
    SimpleTextComponent(
        modifier = Modifier.padding(top = 10.sdp),
        text = "Password",
        fontFamily = TitleTextFont.fontFamily,
        textSize = 15.ssp
    )
    SimpleEditText(modifier = Modifier.fillMaxWidth().padding(top = 5.sdp),
        hint = "Enter Password",
        onTextChange = onPasswordChange)
}
@Preview
@Composable
fun LoginScreenPreview() {
//    LoginScreen()
}