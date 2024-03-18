package com.example.stepcounterjetpack.view.Screen

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.stepcounterjetpack.view.activities.ui.theme.AppColor
import com.example.stepcounterjetpack.view.activities.ui.theme.LightestAppColor
import com.example.stepcounterjetpack.view.activities.ui.theme.TitleTextFont
import com.example.stepcounterjetpack.view.fragments.IntroFragment1
import com.example.stepcounterjetpack.view.fragments.IntroFragment2
import com.example.stepcounterjetpack.view.fragments.IntroFragment3
import ir.kaaveh.sdpcompose.sdp

@Composable
fun IntroUi() {
    Column(Modifier.fillMaxSize()) {

        Column(Modifier
                .fillMaxSize()
                .weight(1f))
        {
//            IntroPager()
        }

        Row(Modifier.fillMaxWidth()
                .padding(horizontal = 10.sdp)
                .padding(bottom = 10.sdp))
        {

            Box(Modifier
                    .fillMaxWidth()
                    .weight(1f))
            {
                SimpleButton(text = "Skip",
                    textColor = AppColor,
                    fontFamily = TitleTextFont,
                    height = 45.sdp,
                    backGroundColor = LightestAppColor
                ) {}
            }
            Box(Modifier
                    .fillMaxWidth()
                    .weight(1f))
            {
                SimpleButton(
                    text = "Continue",
                    textColor = Color.White,
                    fontFamily = TitleTextFont,
                    height = 45.sdp,
                ) {}
            }


        }


    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun IntroPager() {

    val pagerState = rememberPagerState(pageCount = { 3 })
    val context = LocalContext.current

    HorizontalPager(state = pagerState, modifier = Modifier.fillMaxSize()) { page: Int ->

        Box (modifier = Modifier.fillMaxSize() , contentAlignment = Alignment.Center){

            when (page) {
                0 -> {
                    Toast.makeText(context, "Intro 1", Toast.LENGTH_SHORT).show()
                    IntroFragment1()
                }
                1 -> {
                    Toast.makeText(context, "Intro 2", Toast.LENGTH_SHORT).show()
                    IntroFragment2()
                }

                2 -> {
                    Toast.makeText(context, "Intro 3", Toast.LENGTH_SHORT).show()
                    IntroFragment3()
                }

                else -> error("Invalid page: $page")
            }
        }


    }


}

@Preview(showSystemUi = true)
@Composable
fun IntroPreview() {

    IntroUi()
}