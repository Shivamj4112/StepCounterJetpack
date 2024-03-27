package com.example.stepcounterjetpack.view.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.stepcounterjetpack.view.activities.theme.ui.AppBackground
import com.example.stepcounterjetpack.view.activities.theme.ui.AppColor
import com.example.stepcounterjetpack.view.activities.theme.ui.LightGrey
import com.example.stepcounterjetpack.view.activities.theme.ui.LightestAppColor
import com.example.stepcounterjetpack.view.activities.theme.ui.Red
import com.example.stepcounterjetpack.view.activities.theme.ui.TitleTextFont
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp


@Composable
fun PlansScreen() {

    Scaffold(
        topBar = {

            PlansScreenToolBar(toolbarTitle = "Upgrade Plan") {

            }
        }
    ) {

        var button by remember{ mutableStateOf(true) }

        Column(modifier = Modifier
            .padding(it)
            .padding(horizontal = 10.sdp)
            .fillMaxSize()
            .background(LightGrey)) {

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.sdp)) {

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