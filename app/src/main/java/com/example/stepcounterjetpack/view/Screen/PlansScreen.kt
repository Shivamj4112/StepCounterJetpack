package com.example.stepcounterjetpack.view.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.stepcounterjetpack.view.activities.theme.ui.AppColor
import com.example.stepcounterjetpack.view.activities.theme.ui.BodyTextFont
import com.example.stepcounterjetpack.view.activities.theme.ui.LightGrey
import com.example.stepcounterjetpack.view.activities.theme.ui.LightestAppColor
import com.example.stepcounterjetpack.view.activities.theme.ui.TitleTextFont
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp


@Composable
fun PlansScreen() {

    Scaffold(
        topBar = {

            PlansScreenToolBar(toolbarTitle = "Upgrade Plan", onClick = {})
        },
        bottomBar = {

            SimpleButton(
                modifier = Modifier.padding(horizontal = 10.sdp).padding(bottom = 10.sdp).height( 35.sdp).fillMaxWidth(),
                text = "Continue - ",
                textColor = Color.White,
                textSize = 12.ssp) {
                
            }
        }
        
    ) {

        var button by remember { mutableStateOf(true) }

        Column(
            modifier = Modifier
                .padding(it)
                .wrapContentSize()
                .background(LightGrey)
                .padding(horizontal = 10.sdp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.sdp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.sdp)
                        .weight(1f)
                        .clip(shape = RoundedCornerShape(5.sdp))
                        .background(color = if (button) AppColor else LightestAppColor)
                        .clickable(onClick = {
                            button = true

                        }),
                    contentAlignment = Alignment.Center,
                ) {

                    SimpleTextComponent(
                        modifier = Modifier,
                        text = "Monthly",
                        textColor = if (button) Color.White else Color.Black,
                        fontFamily = TitleTextFont.fontFamily,
                        textSize = 12.ssp
                    )
                }

                Spacer(modifier = Modifier.width(10.sdp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.sdp)
                        .weight(1f)
                        .clip(shape = RoundedCornerShape(5.sdp))
                        .background(color = if (button) LightestAppColor else AppColor)
                        .clickable(onClick = {
                            button = false
                        }),
                    contentAlignment = Alignment.Center
                ) {

                    SimpleTextComponent(
                        modifier = Modifier,
                        text = "Yearly",
                        textColor = if (button) Color.Black else Color.White,
                        fontFamily = TitleTextFont.fontFamily,
                        textSize = 12.ssp
                    )
                }

            }

            if (button) {
                MonthlyPlan()
            } else {
                YearlyPlan()
            }
        }
    }

}

@Composable
fun MonthlyPlan() {

    ElevatedCard(
        modifier = Modifier
            .padding(top = 20.sdp)
            .wrapContentHeight(),
        elevation = CardDefaults.elevatedCardElevation(5.sdp)
    ) {

        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(horizontal = 20.sdp, vertical = 15.sdp)
        ) {

            SimpleTextComponent(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                text = "TrackFit Premium",
                fontFamily = TitleTextFont.fontFamily,
                textColor = Color.Black
            )


            Row(
                modifier = Modifier
                    .padding(top = 5.sdp)
                    .fillMaxWidth(), horizontalArrangement = Arrangement.Center
            ) {

                SimpleTextComponent(
                    modifier = Modifier
                        .padding(top = 5.sdp),
                    text = "$4.99",
                    fontFamily = TitleTextFont.fontFamily,
                    textColor = Color.Black, textSize = 35.ssp
                )

                SimpleTextComponent(
                    modifier = Modifier
                        .padding(bottom = 5.sdp)
                        .align(Alignment.Bottom),
                    text = "/ month",
                    fontFamily = BodyTextFont,
                    textColor = Color.Black
                )
            }


            Row(modifier = Modifier.padding(top = 15.sdp)) {

                Icon(
                    modifier = Modifier.size(15.sdp),
                    imageVector = Icons.Filled.Check,
                    contentDescription = null
                )

                Spacer(modifier = Modifier.width(10.sdp))

                SimpleTextComponent(
                    modifier = Modifier,
                    text = "All Free Version benefits +",
                    fontFamily = BodyTextFont,
                    textColor = Color.Black,
                    textSize = 10.ssp
                )
            }
            Row(modifier = Modifier.padding(top = 8.sdp)) {

                Icon(
                    modifier = Modifier.size(15.sdp),
                    imageVector = Icons.Filled.Check,
                    contentDescription = null
                )

                Spacer(modifier = Modifier.width(10.sdp))

                SimpleTextComponent(
                    modifier = Modifier,
                    text = "Set personalized goals and track progress.",
                    fontFamily = BodyTextFont,
                    textColor = Color.Black,
                    textAlign = TextAlign.Start,
                    textSize = 10.ssp
                )
            }
            Row(modifier = Modifier.padding(top = 8.sdp)) {

                Icon(
                    modifier = Modifier.size(15.sdp),
                    imageVector = Icons.Filled.Check,
                    contentDescription = null
                )

                Spacer(modifier = Modifier.width(10.sdp))

                SimpleTextComponent(
                    modifier = Modifier,
                    text = "Access detailed workout routines and training plans.",
                    fontFamily = BodyTextFont,
                    textColor = Color.Black,
                    textAlign = TextAlign.Start,
                    textSize = 10.ssp
                )
            }
            Row(modifier = Modifier.padding(top = 8.sdp)) {

                Icon(
                    modifier = Modifier.size(15.sdp),
                    imageVector = Icons.Filled.Check,
                    contentDescription = null
                )

                Spacer(modifier = Modifier.width(10.sdp))

                SimpleTextComponent(
                    modifier = Modifier,
                    text = "Join community challenges and complete with friends.",
                    fontFamily = BodyTextFont,
                    textColor = Color.Black,
                    textAlign = TextAlign.Start,
                    textSize = 10.ssp
                )
            }
            Row(modifier = Modifier.padding(top = 8.sdp)) {

                Icon(
                    modifier = Modifier.size(15.sdp),
                    imageVector = Icons.Filled.Check,
                    contentDescription = null
                )

                Spacer(modifier = Modifier.width(10.sdp))

                SimpleTextComponent(
                    modifier = Modifier,
                    text = "Advanced data insights and reports.",
                    fontFamily = BodyTextFont,
                    textColor = Color.Black,
                    textAlign = TextAlign.Start,
                    textSize = 10.ssp
                )
            }
            Row(modifier = Modifier.padding(top = 8.sdp)) {

                Icon(
                    modifier = Modifier.size(15.sdp),
                    imageVector = Icons.Filled.Check,
                    contentDescription = null
                )

                Spacer(modifier = Modifier.width(10.sdp))

                SimpleTextComponent(
                    modifier = Modifier,
                    text = "Ad-free experience.",
                    fontFamily = BodyTextFont,
                    textColor = Color.Black,
                    textAlign = TextAlign.Start,
                    textSize = 10.ssp
                )
            }

        }

    }
}

@Composable
fun YearlyPlan() {

    ElevatedCard(
        modifier = Modifier
            .padding(top = 20.sdp)
            .wrapContentHeight(),
        elevation = CardDefaults.elevatedCardElevation(5.sdp)
    ) {

        Column (modifier = Modifier
            .wrapContentSize()
            .background(Color.White)){

            Box(modifier = Modifier
                .clip(RoundedCornerShape(bottomStart = 8.sdp))
                .background(AppColor)
                .padding(5.sdp)
                .align(Alignment.End)){

                SimpleTextComponent(modifier = Modifier, text = "Save 17%", textColor = Color.White, fontFamily = BodyTextFont, textSize = 12.ssp)
            }

            Column(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .padding(horizontal = 20.sdp)
                    .padding(bottom = 15.sdp)
            ) {

                SimpleTextComponent(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),
                    text = "TrackFit Premium",
                    fontFamily = TitleTextFont.fontFamily,
                    textColor = Color.Black
                )


                Row(modifier = Modifier
                    .padding(top = 5.sdp)
                    .fillMaxWidth(), horizontalArrangement = Arrangement.Center) {

                    SimpleTextComponent(
                        modifier = Modifier
                            .padding(top = 5.sdp),
                        text = "$49.99",
                        fontFamily = TitleTextFont.fontFamily,
                        textColor = Color.Black, textSize = 35.ssp
                    )

                    SimpleTextComponent(
                        modifier = Modifier
                            .padding(bottom = 5.sdp)
                            .align(Alignment.Bottom),
                        text = "/ month",
                        fontFamily = BodyTextFont,
                        textColor = Color.Black
                    )
                }


                Row(modifier = Modifier.padding(top = 15.sdp)) {

                    Icon(
                        modifier = Modifier.size(15.sdp),
                        imageVector = Icons.Filled.Check,
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.width(10.sdp))

                    SimpleTextComponent(
                        modifier = Modifier,
                        text = "All Monthly Subscription benefits +",
                        fontFamily = BodyTextFont,
                        textColor = Color.Black,
                        textSize = 10.ssp
                    )
                }
                Row(modifier = Modifier.padding(top = 8.sdp)) {

                    Icon(
                        modifier = Modifier.size(15.sdp),
                        imageVector = Icons.Filled.Check,
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.width(10.sdp))

                    SimpleTextComponent(
                        modifier = Modifier,
                        text = "Exclusive access to premium workout programs and challenges.",
                        fontFamily = BodyTextFont,
                        textColor = Color.Black,
                        textAlign = TextAlign.Start,
                        textSize = 10.ssp
                    )
                }
                Row(modifier = Modifier.padding(top = 8.sdp)) {

                    Icon(
                        modifier = Modifier.size(15.sdp),
                        imageVector = Icons.Filled.Check,
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.width(10.sdp))

                    SimpleTextComponent(
                        modifier = Modifier,
                        text = "In-app coaching and personalized feedback from fitness experts (limites sessions).",
                        fontFamily = BodyTextFont,
                        textColor = Color.Black,
                        textAlign = TextAlign.Start,
                        textSize = 10.ssp
                    )
                }
                Row(modifier = Modifier.padding(top = 8.sdp)) {

                    Icon(
                        modifier = Modifier.size(15.sdp),
                        imageVector = Icons.Filled.Check,
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.width(10.sdp))

                    SimpleTextComponent(
                        modifier = Modifier,
                        text = "Earn premium badges and rewards.",
                        fontFamily = BodyTextFont,
                        textColor = Color.Black,
                        textAlign = TextAlign.Start,
                        textSize = 10.ssp
                    )
                }
                Row(modifier = Modifier.padding(top = 8.sdp)) {

                    Icon(
                        modifier = Modifier.size(15.sdp),
                        imageVector = Icons.Filled.Check,
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.width(10.sdp))

                    SimpleTextComponent(
                        modifier = Modifier,
                        text = "Discounts on partner fitness products and service.",
                        fontFamily = BodyTextFont,
                        textColor = Color.Black,
                        textAlign = TextAlign.Start,
                        textSize = 10.ssp
                    )
                }


            }
        }


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlansScreenToolBar(
    toolbarTitle: String = "",
    size: Dp = 25.sdp,
    backgroundColor: Color = LightGrey,
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
                    text = toolbarTitle,
                    fontFamily = TitleTextFont.fontFamily,
                    textSize = 16.ssp,
                    textColor = Color.Black
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

            Icon(
                imageVector = Icons.Filled.MoreVert,
                contentDescription = "Arrow Back",
                modifier = Modifier
                    .padding(end = 5.sdp, bottom = 12.sdp)
                    .size(size)
                    .alpha(0f)
            )

        }
    )
}


@Preview
@Composable
fun PlansScreenToolBarPreview() {

    PlansScreen()
}