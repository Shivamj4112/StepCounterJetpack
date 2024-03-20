package com.example.stepcounterjetpack.view.Screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.stepcounterjetpack.R
import com.example.stepcounterjetpack.view.activities.ui.theme.AppBackground
import com.example.stepcounterjetpack.view.activities.ui.theme.AppColor
import com.example.stepcounterjetpack.view.activities.ui.theme.BodyTextFont
import com.example.stepcounterjetpack.view.activities.ui.theme.LightestAppColor
import com.example.stepcounterjetpack.view.activities.ui.theme.TitleTextFont
import com.example.stepcounterjetpack.view.util.DigitPicker
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun IntroScreen() {
    Column(Modifier.fillMaxSize()) {

        Column(
            Modifier
                .fillMaxSize()
                .weight(1f)
        ) {

            Scaffold(
                topBar = {
                    IntroToolBar(
                        size = 20.sdp, onClick = {

                        })
                }
            ) {
                Column(modifier = Modifier.padding(it)) {

                    val pagersState = rememberPagerState(pageCount = { 3 })

                    HorizontalPager(
                        state = pagersState,
                        modifier = Modifier.fillMaxSize()
                    ) { page: Int ->

//                        when (page) {

//                            0 -> IntroScreen1()
//                            1 -> IntroScreen2()
//                            2 -> IntroScreen3()

//                        }

                        IntroScreen3()

                    }
                }
            }
        }

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.sdp)
                .padding(bottom = 10.sdp)
        )
        {

            Box(
                Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
            {
                SimpleButton(
                    text = "Skip",
                    textColor = AppColor,
                    fontFamily = TitleTextFont.fontFamily,
                    height = 45.sdp,
                    backGroundColor = LightestAppColor
                ) {}
            }
            Box(
                Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
            {
                SimpleButton(
                    text = "Continue",
                    textColor = Color.White,
                    fontFamily = TitleTextFont.fontFamily,
                    height = 45.sdp,
                ) {}
            }
        }
    }
}

@Composable
fun IntroScreen1() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 15.sdp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier
        ) {

            SimpleTextComponent(
                modifier = Modifier,
                text = "Select Your",
                textSize = 24.ssp,
                fontFamily = TitleTextFont.fontFamily,
                textColor = Color.Black,
            )

            SimpleTextComponent(
                modifier = Modifier.padding(start = 8.sdp),
                text = "Gender",
                textSize = 24.ssp,
                fontFamily = TitleTextFont.fontFamily,
                textColor = AppColor
            )
        }

        SimpleTextComponent(
            modifier = Modifier
                .padding(top = 8.sdp),
            text = "Let's start by understanding you.",
            textSize = 12.ssp
        )


        FilledCardView()


    }
}

@Composable
fun IntroScreen2() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 15.sdp), horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {

            SimpleTextComponent(
                modifier = Modifier,
                text = "Do you live a ",
                textSize = 24.ssp,
                fontFamily = TitleTextFont.fontFamily,
                textColor = Color.Black
            )

            SimpleTextComponent(
                modifier = Modifier,
                text = "Sedentary",
                textSize = 24.ssp,
                fontFamily = TitleTextFont.fontFamily,
                textColor = AppColor
            )

        }
        SimpleTextComponent(
            modifier = Modifier.padding(top = 5.sdp),
            text = "LifeStyle?",
            textSize = 24.ssp,
            fontFamily = TitleTextFont.fontFamily,
            textColor = Color.Black,
        )


        SimpleTextComponent(
            modifier = Modifier.padding(top = 8.sdp),
            text = "Tell us about your daily routine.",
            textSize = 12.ssp,
            fontFamily = BodyTextFont
        )


        Image(
            modifier = Modifier
                .padding(top = 30.sdp)
                .size(230.sdp),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.img_seden),
            contentDescription = null
        )


        Row(modifier = Modifier.padding(top = 10.sdp)) {

            var sedenState by remember { mutableStateOf("No") }

            Button(
                modifier = Modifier
                    .size(55.sdp)
                    .clip(RoundedCornerShape(10.sdp)),
                colors = if (sedenState == "No") ButtonDefaults.buttonColors(containerColor = AppColor) else ButtonDefaults.buttonColors(
                    containerColor = LightestAppColor
                ),
                onClick = { sedenState = "No" }) {

                SimpleTextComponent(
                    modifier = Modifier,
                    text = "No",
                    textColor = if (sedenState == "No") Color.White else AppColor,
                    textSize = 12.ssp,
                    fontFamily = BodyTextFont
                )
            }

            Spacer(modifier = Modifier.width(20.sdp))

            Button(
                modifier = Modifier
                    .size(55.sdp)
                    .clip(RoundedCornerShape(10.sdp)),
                colors = if (sedenState == "Yes") ButtonDefaults.buttonColors(containerColor = AppColor) else ButtonDefaults.buttonColors(
                    containerColor = LightestAppColor
                ),
                onClick = { sedenState = "Yes" }) {

                SimpleTextComponent(
                    modifier = Modifier,
                    text = "Yes",
                    textColor = if (sedenState == "Yes") Color.White else AppColor,
                    textSize = 12.ssp,
                    fontFamily = BodyTextFont
                )
            }
        }

    }
}

@Composable
fun IntroScreen3() {

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

        Row {
            SimpleTextComponent(
                modifier = Modifier.padding(top = 10.sdp),
                text = "How",
                textSize = 24.ssp,
                fontFamily = TitleTextFont.fontFamily,
                textColor = Color.Black
            )

            SimpleTextComponent(
                modifier = Modifier.padding(top = 10.sdp),
                text = " Old ",
                textSize = 24.ssp,
                fontFamily = TitleTextFont.fontFamily,
                textColor = AppColor
            )

            SimpleTextComponent(
                modifier = Modifier.padding(top = 10.sdp),
                text = "Are You?",
                textSize = 24.ssp,
                fontFamily = TitleTextFont.fontFamily,
                textColor = Color.Black
            )

        }

        SimpleTextComponent(
            modifier = Modifier.padding(top = 10.sdp),
            text = "Share your age with us.",
            textSize = 12.ssp,
            fontFamily = BodyTextFont
        )


        var pickerValue by remember { mutableIntStateOf(18) }

        DigitPicker(
            modifier = Modifier,
            value = pickerValue,
            range = 10..100,
            onValueChange = {
                pickerValue = it
            },
        )


    }
}

@Composable
fun FilledCardView() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.sdp), horizontalArrangement = Arrangement.SpaceBetween
    )
    {
        var selectedGender by remember { mutableStateOf("") }

        Card(
            colors = CardDefaults.cardColors(containerColor = AppBackground),

            modifier = Modifier
                .padding(top = 10.sdp)
                .border(
                    width = if (selectedGender == "male") 2.sdp else 0.sdp,
                    color = if (selectedGender == "male") Color.Black else AppBackground
                )
                .clip(RoundedCornerShape(10.sdp))
                .clickable { selectedGender = "male" },
        ) {

            Column(modifier = Modifier.padding(all = 2.sdp)) {
                Image(
                    modifier = Modifier.height(300.sdp),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.img_male),
                    contentDescription = "Image Male "
                )

                SimpleTextComponent(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 10.sdp),
                    text = "Male",
                    textSize = 14.ssp,
                    fontFamily = TitleTextFont.fontFamily,
                    textColor = Color.Black
                )
            }

        }

        Spacer(
            modifier = Modifier
                .fillMaxHeight()
                .width(10.sdp)
        )

        Card(
            colors = CardDefaults.cardColors(containerColor = AppBackground),
            modifier = Modifier
                .padding(top = 10.sdp)
                .border(
                    width = if (selectedGender == "female") 2.sdp else 0.sdp,
                    color = if (selectedGender == "female") Color.Black else AppBackground
                )
                .clip(RoundedCornerShape(10.sdp))
                .clickable { selectedGender = "female" }) {

            Column(modifier = Modifier.padding(all = 2.sdp)) {
                Image(
                    modifier = Modifier.height(300.sdp),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.img_female),
                    contentDescription = "Image Female "
                )

                SimpleTextComponent(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 10.sdp),
                    text = "Female",
                    textSize = 14.ssp,
                    fontFamily = TitleTextFont.fontFamily,
                    textColor = Color.Black
                )
            }
        }


    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IntroToolBar(
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
                    .clickable(enabled = true, onClick = onClick),
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = backgroundColor),
        actions = {

            SimpleTextComponent(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(end = 5.sdp, bottom = 12.sdp),
                text = "1 / 6",
                fontFamily = TitleTextFont.fontFamily,
                textColor = Color.Black
            )

        }
    )
}


@Preview(showSystemUi = true)
@Composable
fun IntroPreview() {

    IntroScreen()
}