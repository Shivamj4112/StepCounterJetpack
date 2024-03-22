package com.example.stepcounterjetpack.view.Screen

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.stepcounterjetpack.R
import com.example.stepcounterjetpack.view.theme.ui.AppBackground
import com.example.stepcounterjetpack.view.theme.ui.AppColor
import com.example.stepcounterjetpack.view.theme.ui.BodyTextFont
import com.example.stepcounterjetpack.view.theme.ui.TitleTextFont
import com.example.stepcounterjetpack.viewModels.SignupViewModel
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Composable
fun SignupScreen(context: Activity, signViewModel: SignupViewModel) {

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    fun areFieldsValid() : Boolean {
        return name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()
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
                    text = "Join TrackFit Today",
                    fontFamily = TitleTextFont.fontFamily,
                    textColor = TitleTextFont.color,
                    textSize = 24.ssp
                )
                SimpleTextComponent(
                    modifier = Modifier.padding(top = 10.sdp),
                    text = "Create your account and start tracking your steps.",
                    textAlign = TextAlign.Start,
                    textSize = 14.ssp,
                )

                LayoutEditText(name, email, password, onNameChange = { name = it }, onEmailChange = { email = it }, onPasswordChange = { password = it })


                Row(
                    Modifier.padding(top = 5.sdp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {

                    SimpleCheckBox()
                    SimpleTextComponent(
                        modifier = Modifier.padding(start = 5.sdp),
                        text = "Terms & Conditions.",
                        textColor = AppColor,
                        fontFamily = BodyTextFont,
                        textSize = 12.ssp
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.sdp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                    SimpleTextComponent(
                        modifier = Modifier,
                        text = "Already have an account? ",
                        textSize = 12.ssp,
                        fontFamily = BodyTextFont
                    )
                    ClickableTextComponent(
                        modifier = Modifier,
                        text = "Login",
                        textColor = AppColor,
                        fontFamily = BodyTextFont,
                        textSize = 12.ssp,
                        onClick = {
                            signViewModel.navigateToLogin(context = context) {

                            }
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

                SimpleButton(text = "Sign up", textColor = Color.White,
                    onClick = {
                        if (areFieldsValid()){
                            signViewModel.createAccount(context,name,email,password)
                        }
                        else{
                            Toast.makeText(context, "Please fill all field", Toast.LENGTH_SHORT).show()
                        }
                })
            }
        }
    }
}

@Composable
private fun LayoutEditText(name: String,
                           email: String,
                           password: String,
                           onNameChange: (String) -> Unit,
                           onEmailChange: (String) -> Unit,
                           onPasswordChange: (String) -> Unit) {
    // TODO        TextField  Name
    SimpleTextComponent(
        modifier = Modifier.padding(top = 20.sdp),
        text = "Name",
        fontFamily = TitleTextFont.fontFamily,
        textSize = 15.ssp
    )

    SimpleEditText(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.sdp),
        hint = "Enter Name",
        onTextChange = onNameChange)


    //TODO       TextField Email
    SimpleTextComponent(
        modifier = Modifier.padding(top = 10.sdp),
        text = "Email",
        fontFamily = TitleTextFont.fontFamily,
        textSize = 15.ssp
    )



    SimpleEditText(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.sdp),
        hint = "Enter Email",
        onTextChange = onEmailChange)


    //TODO       TextField Password
    SimpleTextComponent(
        modifier = Modifier.padding(top = 10.sdp),
        text = "Password",
        fontFamily = TitleTextFont.fontFamily,
        textSize = 15.ssp
    )

    SimpleEditText(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 5.sdp),
        hint = "Enter Password",
        onTextChange = onPasswordChange )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppToolBar(
    toolbarTitle: String = "",
    size: Dp = 25.sdp,
    backgroundColor: Color = AppBackground,
    onClick: () -> Unit,

    ) {

    TopAppBar(
        modifier = Modifier.wrapContentHeight(),
        title = {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.sdp),
                contentAlignment = Alignment.Center
            ) {

                SimpleTextComponent(
                    modifier = Modifier,
                    text = "toolbarTitle",
                    fontFamily = TitleTextFont.fontFamily
                )
            }

        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Arrow Back",
                modifier = Modifier
                    .padding(start = 5.sdp, bottom = 12.sdp)
                    .size(size)
                    .alpha(0f)
                    .clickable(enabled = true, onClick = onClick),
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = backgroundColor),
        actions = {


            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Arrow Back",
                modifier = Modifier
                    .padding(end = 5.sdp, bottom = 12.sdp)
                    .size(size)
                    .alpha(0f)
                    .clickable(enabled = true, onClick = onClick),
            )

        }
    )
}


@Preview
@Composable
fun SignupScreenPreview() {
//    SignupScreen()
}