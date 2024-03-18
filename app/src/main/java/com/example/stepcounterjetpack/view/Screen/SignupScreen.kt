package com.example.stepcounterjetpack.view.Screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.stepcounterjetpack.view.activities.ui.theme.TitleTextFont
import ir.kaaveh.sdpcompose.sdp

@Composable
fun SignupScreen() {

    Scaffold(
        topBar = {
            AppToolBar(
                size = 22.sdp, onClick = {

                })
        }
    ){
        Column(modifier = Modifier.padding(it)) {

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppToolBar(
    toolbarTitle: String = "",
    size: Dp = 25.sdp,
    backgroundColor : Color = Color.White,
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
                    .padding(start = 5.sdp)
                    .size(size)
                    .clickable(enabled = true, onClick = onClick),
            )
        },
        modifier = Modifier,
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = backgroundColor),
        actions = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 6.sdp),
                contentAlignment = Alignment.Center
            ) {
                SimpleTextComponent(text = toolbarTitle, fontFamily = TitleTextFont)
            }
        }
    )
}



@Preview
@Composable
fun SignupScreenPreview(){

    SignupScreen()
}