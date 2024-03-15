package com.example.stepcounterjetpack.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.stepcounterjetpack.R
import com.example.stepcounterjetpack.activities.ui.theme.BodyTextFont
import com.example.stepcounterjetpack.activities.ui.theme.DefaultTextColor
import com.example.stepcounterjetpack.activities.ui.theme.TitleTextFont
import com.example.stepcounterjetpack.composableUI.SimpleButton
import com.example.stepcounterjetpack.composableUI.SimpleTextComponent
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Preview
@Composable
fun SignUpScreen() {

    Scaffold(
        topBar = {
            AppTooBar(
                onClick = {

                }
            )
        }
    ) {
        Column(
            Modifier
                .padding(it)
                .padding(horizontal = 15.sdp)
        ) {

            SimpleTextComponent(
                text = "Join TrackFit Today",
                textSize = 24.ssp,
                fontFamily = TitleTextFont,
                textColor = Color.Black
            )
            SimpleTextComponent(
                text = "Create your account and start tracking your steps.",
                textSize = 14.ssp,
                fontFamily = BodyTextFont,
                textAlign = TextAlign.Start,
                paddingTop = 15.sdp,
                paddingStart = 2.sdp
            )
            SimpleTextComponent(
                text = "Name",
                textSize = 14.ssp,
                fontFamily = TitleTextFont,
                textColor = Color.Black,
                textAlign = TextAlign.Start,
                paddingTop = 10.sdp,
                paddingStart = 2.sdp
            )

            Box(modifier = Modifier.padding(top = 10.sdp)){

                var email by remember { mutableStateOf("") }
                SimpleEditText(hint = "Enter Email", paddingTop = 10.sdp, keyboardType = KeyboardType.Email,onTextChange = { it ->
                    email = it
                })


            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleEditText(
    paddingStart: Dp = 0.sdp,
    paddingTop: Dp = 0.sdp,
    paddingEnd: Dp = 0.sdp,
    paddingBottom: Dp = 0.sdp,
    paddingHorizontal: Dp = 0.sdp,
    paddingVertical: Dp = 0.sdp,
    padding: Dp = 0.sdp,
    hint: String = "",
    onTextChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text
) {

    var isPasswordVisible by remember { mutableStateOf(false) }
    val textState = remember { mutableStateOf("") }

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = padding)
            .padding(
                start = paddingStart,
                top = paddingTop,
                end = paddingEnd,
                bottom = paddingBottom
            )
            .padding(horizontal = paddingHorizontal, vertical = paddingVertical),
        shape = RoundedCornerShape(12.sdp),
        colors = TextFieldDefaults.textFieldColors(
            disabledTextColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),

        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
        value = textState.value,
        onValueChange = {
            textState.value = it
            onTextChange(it)
        },

        singleLine = true,

        placeholder = {
            SimpleTextComponent(text = hint, textColor = DefaultTextColor)
        },
        visualTransformation = if (keyboardType == KeyboardType.Password && !isPasswordVisible) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        trailingIcon = {
            if (keyboardType == KeyboardType.Password) {
                val icon = if (isPasswordVisible) {
                    painterResource(id = R.drawable.ic_hide)
                } else {
                    painterResource(id = R.drawable.ic_visible)
                }
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(
                        icon,
                        contentDescription = "Toggle Password Visibility",
                        Modifier.size(width = 20.sdp, height = 20.sdp)
                    )
                }
            }
        }
    )


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTooBar(
    toolbarTitle: String = "",
    size: Dp = 25.sdp,
    backgroundColor: Color = Color.White,
    onClick: () -> Unit,
) {

    TopAppBar(
        title = {
            SimpleTextComponent(text = toolbarTitle)
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Arrow Back",
                modifier = Modifier
                    .padding(start = 5.sdp, top = 5.sdp)
                    .padding(vertical = 5.sdp)
                    .size(size)
                    .clickable(enabled = true, onClick = onClick),
            )
        },
        modifier = Modifier.height(50.sdp),
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = backgroundColor),
        actions = {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                SimpleTextComponent(text = toolbarTitle)
            }
        }
    )
}
