package com.example.stepcounterjetpack.view.Screen

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.dp
import com.example.stepcounterjetpack.R
import com.example.stepcounterjetpack.view.activities.LoginActivity
import com.example.stepcounterjetpack.view.activities.ui.theme.AppBackground
import com.example.stepcounterjetpack.view.activities.ui.theme.AppColor
import com.example.stepcounterjetpack.view.activities.ui.theme.BodyTextFont
import com.example.stepcounterjetpack.view.activities.ui.theme.TitleTextFont
import com.example.stepcounterjetpack.viewModels.SelectionViewModel
import com.example.stepcounterjetpack.viewModels.SignupViewModel
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Composable
fun SignupScreen(context: Activity, signViewModel: SignupViewModel) {

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
                    modifier = Modifier,
                    text = "Create your account and start tracking your steps.",
                    textAlign = TextAlign.Start,
                    textSize = 14.ssp,
                    paddingTop = 10.sdp
                )

                LayoutEditText()

                Row(
                    Modifier.padding(top = 5.sdp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {

                    SimpleCheckBox()
                    SimpleTextComponent(
                        modifier = Modifier,
                        text = "Terms & Conditions.",
                        textColor = AppColor,
                        fontFamily = BodyTextFont,
                        paddingStart = 5.sdp,
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
                        text = "Sign in",
                        textColor = AppColor,
                        fontFamily = BodyTextFont,
                        textSize = 12.ssp,
                        onClick = {
                            signViewModel.navigateToLogin(context) {
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
                    SimpleTextComponent(modifier = Modifier.padding(horizontal = 10.sdp), text = "or", fontFamily = BodyTextFont)
                    Divider(Modifier.weight(1f))
                }

                SignCard(text = "Continue with Google", src = R.drawable.ic_google ,  textSize = 12.ssp)
                SignCard(text = "Continue with Apple", src = R.drawable.ic_apple,textSize = 12.ssp)
                SignCard(text = "Continue with Facebook", src = R.drawable.ic_facebook,textSize = 12.ssp)
                SignCard(text = "Continue with Twitter", src = R.drawable.ic_twitter,textSize = 12.ssp, paddingBottom = 15.sdp)
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.sdp)
            ) {

                SimpleButton(text = "Sign up", textColor = Color.White) {

                }
            }


        }
    }
}

@Composable
private fun LayoutEditText() {
    // TODO        TextField  Name
    SimpleTextComponent(
        modifier = Modifier,
        text = "Name",
        fontFamily = TitleTextFont.fontFamily,
        paddingTop = 20.sdp,
        textSize = 15.ssp
    )
    var name by remember { mutableStateOf("") }
    SimpleEditText(hint = "Enter Name", paddingTop = 5.sdp, onTextChange = { tfName ->
        name = tfName
    })


    //TODO       TextField Email
    SimpleTextComponent(
        modifier = Modifier,
        text = "Email",
        fontFamily = TitleTextFont.fontFamily,
        paddingTop = 10.sdp,
        textSize = 15.ssp
    )
    var email by remember { mutableStateOf("") }
    SimpleEditText(hint = "Enter Email", paddingTop = 5.sdp, onTextChange = { tfEmail ->
        email = tfEmail
    })


    //TODO       TextField Password
    SimpleTextComponent(
        modifier = Modifier,
        text = "Password",
        fontFamily = TitleTextFont.fontFamily,
        paddingTop = 10.sdp,
        textSize = 15.ssp
    )
    var password by remember { mutableStateOf("") }
    SimpleEditText(hint = "Enter Password", paddingTop = 5.sdp, onTextChange = { tfPassword ->
        password = tfPassword
    })
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
                modifier = Modifier.fillMaxWidth()
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
                    .clickable(enabled = true, onClick = onClick),
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = backgroundColor),
        actions = {

//            SimpleTextComponent(
//                modifier = Modifier.align(Alignment.CenterVertically).fillMaxWidth(),
//                text = "toolbarTitle",
//                fontFamily = TitleTextFont.fontFamily
//            )

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