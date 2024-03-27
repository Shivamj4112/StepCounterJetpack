package com.example.stepcounterjetpack.view.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
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
import com.example.stepcounterjetpack.view.theme.ui.Yellow
import com.example.stepcounterjetpack.view.util.CircularSlider
import com.example.stepcounterjetpack.view.util.navigation.BubbleNavigationBar
import com.example.stepcounterjetpack.view.util.navigation.BubbleNavigationBarItem
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp


@Composable
fun MainScreen() {

    var toolbarTitle by remember { mutableStateOf("Home") }

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
                toolbarTitle = toolbarTitle, onClick = {

                })
        },
        bottomBar = {

            BubbleNavigationBar(
                modifier = Modifier
                    .padding(horizontal = 10.sdp)
                    .padding(bottom = 10.sdp)
                    .clip(RoundedCornerShape(8.sdp)),
            ) {
                navigationItems.forEach { navigationItem ->
                    BubbleNavigationBarItem(
                        selected = currentRoute == navigationItem.route,
                        onClick = {
                            if (currentRoute != navigationItem.route) {
                                navController.popBackStack()
                                navController.navigate(navigationItem.route) {
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

            NavHost(
                navController = navController,
                startDestination = NavigationItem.ScreenA.route
            ) {
                composable(NavigationItem.ScreenA.route) {
                    toolbarTitle = "Home"
                    HomeScreen()
                }
                composable(NavigationItem.ScreenB.route) {
                    toolbarTitle = "Location"
                    HomeScreen()
                }
                composable(NavigationItem.ScreenC.route) {
                    toolbarTitle = "Report"
                    HomeScreen()
                }
                composable(NavigationItem.ScreenD.route) {
                    toolbarTitle = "History"
                    HomeScreen()
                }
                composable(NavigationItem.ScreenE.route) {
                    toolbarTitle = "Account"
                    AccountScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {

    Column(Modifier.fillMaxSize()) {
        CircularSlider(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            backgroundIndicatorStrokeWidth = 80f,
            foregroundIndicatorStrokeWidth = 80f,
            indicatorValue = 50
        )

        ElevatedCard(
            modifier = Modifier
                .padding(horizontal = 15.sdp)
                .padding(top = 20.sdp),
            elevation = CardDefaults.elevatedCardElevation(1.sdp)
        ) {

            Row(
                Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(vertical = 9.sdp), horizontalArrangement = Arrangement.Center
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {

                    Image(
                        modifier = Modifier.size(20.sdp),
                        painter = painterResource(id = R.drawable.ic_clock),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Orange)
                    )

                    SimpleTextComponent(
                        modifier = Modifier
                            .padding(top = 8.sdp, bottom = 3.sdp),
                        text = "0",
                        textSize = 16.ssp,
                        fontFamily = TitleTextFont.fontFamily,
                        textColor = Color.Black
                    )

                    SimpleTextComponent(
                        modifier = Modifier,
                        text = "time",
                        fontFamily = BodyTextFont
                    )

                }

                VerticalDivider(
                    modifier = Modifier
                        .height(60.sdp)
                        .padding(vertical = 2.sdp)
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {

                    Image(
                        modifier = Modifier.size(20.sdp),
                        painter = painterResource(id = R.drawable.ic_calories),
                        contentDescription = null,
                    )

                    SimpleTextComponent(
                        modifier = Modifier
                            .padding(top = 8.sdp, bottom = 3.sdp),
                        text = "0",
                        textSize = 16.ssp,
                        fontFamily = TitleTextFont.fontFamily,
                        textColor = Color.Black
                    )

                    SimpleTextComponent(
                        modifier = Modifier,
                        text = "kcal",
                        fontFamily = BodyTextFont
                    )

                }

                VerticalDivider(
                    modifier = Modifier
                        .height(60.sdp)
                        .padding(vertical = 2.sdp)
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {

                    Image(
                        modifier = Modifier.size(20.sdp),
                        painter = painterResource(id = R.drawable.ic_location_outline),
                        contentDescription = null,
                    )

                    SimpleTextComponent(
                        modifier = Modifier
                            .padding(top = 8.sdp, bottom = 3.sdp),
                        text = "0",
                        textSize = 16.ssp,
                        fontFamily = TitleTextFont.fontFamily,
                        textColor = Color.Black
                    )

                    SimpleTextComponent(modifier = Modifier, text = "km", fontFamily = BodyTextFont)

                }

            }

        }
    }
}

@Composable
fun AccountScreen() {


    Column (modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 10.sdp)
        .verticalScroll(rememberScrollState())){

        ElevatedCard(
            modifier = Modifier.padding(top = 10.sdp),
            elevation = CardDefaults.elevatedCardElevation(1.sdp)) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(8.sdp))
                    .background(color = AppColor),
            )
            {
                Box(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(10.sdp),
                    contentAlignment = Alignment.Center
                ) {

                    Image(
                        modifier = Modifier.size(40.sdp),
                        painter = painterResource(id = R.drawable.ic_crown_bg),
                        contentDescription = null
                    )

                    Image(
                        modifier = Modifier.size(24.sdp),
                        painter = painterResource(id = R.drawable.ic_crown),
                        contentDescription = null
                    )

                }
                Column(modifier = Modifier.align(Alignment.CenterVertically)) {

                    SimpleTextComponent(
                        modifier = Modifier,
                        text = "Upgrade Plan Now!",
                        textColor = Color.White,
                        fontFamily = TitleTextFont.fontFamily,
                        textSize = 16.ssp
                    )

                    SimpleTextComponent(
                        modifier = Modifier,
                        text = "Enjoy all the benefits and explore more possibilities",
                        textColor = Color.White,
                        fontFamily = BodyTextFont,
                        textSize = 8.ssp
                    )
                }
            }

        }


        ElevatedCard(
            modifier = Modifier
                .padding(top = 10.sdp),
            elevation = CardDefaults.elevatedCardElevation(1.sdp)) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(8.sdp))
                    .background(color = Color.White),
                verticalAlignment = Alignment.CenterVertically
            )
            {

                Image(
                    modifier = Modifier
                        .padding(11.sdp)
                        .size(35.sdp),
                    painter = painterResource(id = R.drawable.ic_gl_10),
                    contentDescription = null
                )


                Column(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .align(Alignment.CenterVertically)) {

                    SimpleTextComponent(
                        modifier = Modifier,
                        text = "Level 9",
                        textColor = Color.Black,
                        fontFamily = TitleTextFont.fontFamily,
                        textSize = 14.ssp
                    )

                    SimpleTextComponent(
                        modifier = Modifier,
                        text = "You are a rising star keep going",
                        fontFamily = BodyTextFont,
                        textSize = 8.ssp
                    )
                }

                Image(
                    modifier = Modifier
                        .padding(10.sdp)
                        .size(16.sdp),
                    painter = painterResource(id = R.drawable.ic_arrow_forward),
                    contentDescription = null
                )
            }
        }

        ElevatedCard(
            modifier = Modifier
                .padding(top = 10.sdp),
            elevation = CardDefaults.elevatedCardElevation(1.sdp)) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(8.sdp))
                    .background(color = Color.White),
                verticalAlignment = Alignment.CenterVertically
            )
            {

                Image(
                    modifier = Modifier
                        .padding(8.sdp)
                        .size(20.sdp),
                    painter = painterResource(id = R.drawable.ic_water_drop),
                    contentDescription = null
                )


                Column(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .align(Alignment.CenterVertically)) {

                    SimpleTextComponent(
                        modifier = Modifier,
                        text = "Water Tracker",
                        textColor = Color.Black,
                        fontFamily = TitleTextFont.fontFamily,
                        textSize = 12.ssp
                    )

                }

                Image(
                    modifier = Modifier
                        .padding(10.sdp)
                        .size(15.sdp),
                    painter = painterResource(id = R.drawable.ic_arrow_forward),
                    contentDescription = null
                )
            }
        }

        ElevatedCard(
            modifier = Modifier
                .padding(top = 2.sdp),
            elevation = CardDefaults.elevatedCardElevation(1.sdp)) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(8.sdp))
                    .background(color = Color.White),
                verticalAlignment = Alignment.CenterVertically
            )
            {

                Image(
                    modifier = Modifier
                        .padding(8.sdp)
                        .size(20.sdp),
                    painter = painterResource(id = R.drawable.ic_weight),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Yellow)
                )


                Column(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .align(Alignment.CenterVertically)) {

                    SimpleTextComponent(
                        modifier = Modifier,
                        text = "Water Tracker",
                        textColor = Color.Black,
                        fontFamily = TitleTextFont.fontFamily,
                        textSize = 12.ssp
                    )

                }

                Image(
                    modifier = Modifier
                        .padding(10.sdp)
                        .size(15.sdp),
                    painter = painterResource(id = R.drawable.ic_arrow_forward),
                    contentDescription = null
                )
            }
        }


        ElevatedCard(
            modifier = Modifier
                .padding(top = 10.sdp),
            elevation = CardDefaults.elevatedCardElevation(1.sdp)) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(8.sdp))
                    .background(color = Color.White),
                verticalAlignment = Alignment.CenterVertically
            )
            {

                Image(
                    modifier = Modifier
                        .padding(10.sdp)
                        .size(18.sdp),
                    painter = painterResource(id = R.drawable.ic_settings),
                    contentDescription = null,
                )


                Column(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .align(Alignment.CenterVertically)) {

                    SimpleTextComponent(
                        modifier = Modifier,
                        text = "Preferences",
                        textColor = Color.Black,
                        fontFamily = TitleTextFont.fontFamily,
                        textSize = 12.ssp
                    )

                }

                Image(
                    modifier = Modifier
                        .padding(10.sdp)
                        .size(15.sdp),
                    painter = painterResource(id = R.drawable.ic_arrow_forward),
                    contentDescription = null
                )
            }
        }


        ElevatedCard(
            modifier = Modifier
                .padding(top = 2.sdp),
            elevation = CardDefaults.elevatedCardElevation(1.sdp)) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(8.sdp))
                    .background(color = Color.White),
                verticalAlignment = Alignment.CenterVertically
            )
            {

                Image(
                    modifier = Modifier
                        .padding(10.sdp)
                        .size(18.sdp),
                    painter = painterResource(id = R.drawable.ic_user),
                    contentDescription = null,
                )


                Column(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .align(Alignment.CenterVertically)) {

                    SimpleTextComponent(
                        modifier = Modifier,
                        text = "Personal Info",
                        textColor = Color.Black,
                        fontFamily = TitleTextFont.fontFamily,
                        textSize = 12.ssp
                    )

                }

                Image(
                    modifier = Modifier
                        .padding(10.sdp)
                        .size(15.sdp),
                    painter = painterResource(id = R.drawable.ic_arrow_forward),
                    contentDescription = null
                )
            }
        }


        ElevatedCard(
            modifier = Modifier
                .padding(top = 2.sdp),
            elevation = CardDefaults.elevatedCardElevation(1.sdp)) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(8.sdp))
                    .background(color = Color.White),
                verticalAlignment = Alignment.CenterVertically
            )
            {

                Image(
                    modifier = Modifier
                        .padding(10.sdp)
                        .size(18.sdp),
                    painter = painterResource(id = R.drawable.ic_card),
                    contentDescription = null,
                )


                Column(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .align(Alignment.CenterVertically)) {

                    SimpleTextComponent(
                        modifier = Modifier,
                        text = "Payment Methods",
                        textColor = Color.Black,
                        fontFamily = TitleTextFont.fontFamily,
                        textSize = 12.ssp
                    )

                }

                Image(
                    modifier = Modifier
                        .padding(10.sdp)
                        .size(15.sdp),
                    painter = painterResource(id = R.drawable.ic_arrow_forward),
                    contentDescription = null
                )
            }
        }

        ElevatedCard(
            modifier = Modifier
                .padding(top = 2.sdp),
            elevation = CardDefaults.elevatedCardElevation(1.sdp)) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(8.sdp))
                    .background(color = Color.White),
                verticalAlignment = Alignment.CenterVertically
            )
            {

                Image(
                    modifier = Modifier
                        .padding(10.sdp)
                        .size(18.sdp),
                    painter = painterResource(id = R.drawable.ic_star),
                    contentDescription = null,
                )


                Column(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .align(Alignment.CenterVertically)) {

                    SimpleTextComponent(
                        modifier = Modifier,
                        text = "Billing & Subscriptions",
                        textColor = Color.Black,
                        fontFamily = TitleTextFont.fontFamily,
                        textSize = 12.ssp
                    )

                }

                Image(
                    modifier = Modifier
                        .padding(10.sdp)
                        .size(15.sdp),
                    painter = painterResource(id = R.drawable.ic_arrow_forward),
                    contentDescription = null
                )
            }
        }


        ElevatedCard(
            modifier = Modifier
                .padding(top = 2.sdp),
            elevation = CardDefaults.elevatedCardElevation(1.sdp)) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(8.sdp))
                    .background(color = Color.White),
                verticalAlignment = Alignment.CenterVertically
            )
            {

                Image(
                    modifier = Modifier
                        .padding(10.sdp)
                        .size(18.sdp),
                    painter = painterResource(id = R.drawable.ic_security),
                    contentDescription = null,
                )


                Column(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .align(Alignment.CenterVertically)) {

                    SimpleTextComponent(
                        modifier = Modifier,
                        text = "Account & Security",
                        textColor = Color.Black,
                        fontFamily = TitleTextFont.fontFamily,
                        textSize = 12.ssp
                    )

                }

                Image(
                    modifier = Modifier
                        .padding(10.sdp)
                        .size(15.sdp),
                    painter = painterResource(id = R.drawable.ic_arrow_forward),
                    contentDescription = null
                )
            }
        }

        ElevatedCard(
            modifier = Modifier
                .padding(top = 2.sdp),
            elevation = CardDefaults.elevatedCardElevation(1.sdp)) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(8.sdp))
                    .background(color = Color.White),
                verticalAlignment = Alignment.CenterVertically
            )
            {

                Image(
                    modifier = Modifier
                        .padding(10.sdp)
                        .size(18.sdp),
                    painter = painterResource(id = R.drawable.ic_linked),
                    contentDescription = null,
                )


                Column(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .align(Alignment.CenterVertically)) {

                    SimpleTextComponent(
                        modifier = Modifier,
                        text = "Linked Accounts",
                        textColor = Color.Black,
                        fontFamily = TitleTextFont.fontFamily,
                        textSize = 12.ssp
                    )

                }

                Image(
                    modifier = Modifier
                        .padding(10.sdp)
                        .size(15.sdp),
                    painter = painterResource(id = R.drawable.ic_arrow_forward),
                    contentDescription = null
                )
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
    AccountScreen()
}