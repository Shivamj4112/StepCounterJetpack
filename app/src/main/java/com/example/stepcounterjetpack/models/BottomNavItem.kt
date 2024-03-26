package com.example.stepcounterjetpack.models

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import com.example.stepcounterjetpack.R

sealed class NavigationItem(
    val title: String,
    val route: String,
    val icon: ImageVector, // Change from Int to ImageVector
    val selectedColor: Color,
){
    object ScreenA : NavigationItem(
        title = "Home",
        route = "screenA",
        icon = Icons.Outlined.Home, // Example of setting an ImageVector from Material Icons
        selectedColor = Color(0xFFE74C3C)
    )
    object ScreenB : NavigationItem(
        title = "Location",
        route = "screenB",
        icon = Icons.Outlined.LocationOn,
        selectedColor = Color(0xFF7B3CEA)
    )
    object ScreenC : NavigationItem(
        title = "Report",
        route = "screenC",
        icon = Icons.Outlined.Info, // Example of loading from drawable resource
        selectedColor = Color(0xFFf4a261)
    )
    object ScreenD : NavigationItem(
        title = "History",
        route = "screenD",
        icon = Icons.Outlined.Menu, // Example of loading from drawable resource
        selectedColor = Color(0xFFe76f51)
    )

    object ScreenE : NavigationItem(
        title = "Account",
        route = "screenD",
        icon = Icons.Outlined.AccountCircle, // Example of loading from drawable resource
        selectedColor = Color(0xFFe76f51)
    )
}
