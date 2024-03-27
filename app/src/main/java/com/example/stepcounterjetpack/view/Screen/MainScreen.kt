package com.example.stepcounterjetpack.view.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.stepcounterjetpack.R
import com.example.stepcounterjetpack.models.NavigationItem
import com.example.stepcounterjetpack.view.theme.ui.AppColor
import com.example.stepcounterjetpack.view.theme.ui.BodyTextFont
import com.example.stepcounterjetpack.view.theme.ui.LightGrey
import com.example.stepcounterjetpack.view.theme.ui.Orange
import com.example.stepcounterjetpack.view.theme.ui.TitleTextFont
import com.example.stepcounterjetpack.view.util.CircularSlider
import com.example.stepcounterjetpack.view.util.navigation.BubbleNavigationBar
import com.example.stepcounterjetpack.view.util.navigation.BubbleNavigationBarItem
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Composable
fun MainScreen() {

     val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                val navigationItems = NavigationItem::class.nestedClasses.map {
                    it.objectInstance as NavigationItem
                }

    Scaffold(
        containerColor = LightGrey,
        topBar = {
            MainScreenToolBar(
                size = 20.sdp,
                toolbarTitle = "Home", onClick = {

                })
        },
        bottomBar = {
            BubbleNavigationBar(modifier = Modifier
                .padding(horizontal = 10.sdp)
                .padding(bottom = 10.sdp)
                .clip(RoundedCornerShape(8.sdp))) {
                navigationItems.forEach { navigationItem ->
                    BubbleNavigationBarItem(
                        selected = currentRoute == navigationItem.route,
                        onClick = {
                            if(currentRoute != navigationItem.route){
                                navController.popBackStack()
                                navController.navigate(navigationItem.route){
                                    navController.graph.startDestinationRoute?.let { screen_route ->
                                        popUpTo(screen_route) {
                                            saveState = true
                                        }
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        },
                        icon = navigationItem.icon,
                        title = navigationItem.title,
                        selectedColor = navigationItem.selectedColor
                    )
                }
            }
        }

    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(it)
        ) {

            NavHost(navController = navController, startDestination = NavigationItem.ScreenA.route){
                composable(NavigationItem.ScreenA.route){
                    demo1()
                }
                composable(NavigationItem.ScreenB.route){
                    demo1()
                }
                composable(NavigationItem.ScreenC.route){
                    demo1()
                }
                composable(NavigationItem.ScreenD.route){
                    demo1()
                }
                composable(NavigationItem.ScreenE.route){
                    demo1()
                }
            }
        }
    }
}
@Composable
fun demo1 (){

    Column (Modifier.fillMaxSize()) {
        CircularSlider(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            backgroundIndicatorStrokeWidth = 80f,
            foregroundIndicatorStrokeWidth = 80f,
            indicatorValue = 50
        )

        ElevatedCard(modifier = Modifier
            .padding(horizontal = 15.sdp)
            .padding(top = 20.sdp),
            elevation = CardDefaults.elevatedCardElevation(10.sdp)) {

            Row(Modifier.fillMaxWidth().background(Color.White).padding(vertical = 9.sdp), horizontalArrangement = Arrangement.Center) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {

                    Image(
                        modifier = Modifier.size(18.sdp),
                        painter = painterResource(id = R.drawable.ic_clock),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Orange)
                    )

                    SimpleTextComponent(modifier = Modifier
                        .padding(top = 8.sdp, bottom = 3.sdp),
                        text = "0",
                        textSize = 16.ssp,
                        fontFamily = TitleTextFont.fontFamily ,
                        textColor = Color.Black)

                    SimpleTextComponent(modifier = Modifier, text = "time", fontFamily = BodyTextFont)

                }

                VerticalDivider(modifier = Modifier.height(60.sdp).padding(vertical = 2.sdp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {

                    Image(
                        modifier = Modifier.size(18.sdp),
                        painter = painterResource(id = R.drawable.ic_calories),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Orange)
                    )

                    SimpleTextComponent(modifier = Modifier
                        .padding(top = 8.sdp, bottom = 3.sdp),
                        text = "0",
                        textSize = 16.ssp,
                        fontFamily = TitleTextFont.fontFamily ,
                        textColor = Color.Black)

                    SimpleTextComponent(modifier = Modifier, text = "kcal", fontFamily = BodyTextFont)

                }

                VerticalDivider(modifier = Modifier.height(60.sdp).padding(vertical = 2.sdp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {

                    Image(
                        modifier = Modifier.size(18.sdp),
                        painter = painterResource(id = R.drawable.ic_clock),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Orange)
                    )

                    SimpleTextComponent(modifier = Modifier
                        .padding(top = 8.sdp, bottom = 3.sdp),
                        text = "0",
                        textSize = 16.ssp,
                        fontFamily = TitleTextFont.fontFamily ,
                        textColor = Color.Black)

                    SimpleTextComponent(modifier = Modifier, text = "time", fontFamily = BodyTextFont)

                }

            }

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenToolBar(
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
                    textSize = 16.ssp
                )
            }

        },
        navigationIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_footsteps),
                contentDescription = "Arrow Back",
                tint = AppColor,
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
                    .clickable(enabled = true, onClick = onClick),
            )

        }
    )
}


@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview() {
    demo1()
}