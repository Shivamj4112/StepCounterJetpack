package com.example.stepcounterjetpack.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.stepcounterjetpack.R

sealed class NavigationItem(
    val title: String,
    val route: String,
    val icon: ImageVector,
    val selectedColor: Color,
){
    object ScreenA : NavigationItem(
        title = "Home",
        route = "screenA",
        icon = Icons.Default.Home,
        selectedColor = Color(0xFF2a9d8f)
    )
    object ScreenB : NavigationItem(
        title = "Search",
        route = "screenB",
        icon = Icons.Default.Search,
        selectedColor = Color(0xFFe9c46a)
    )
    object ScreenC : NavigationItem(
        title = "Shop",
        route = "screenC",
        icon = Icons.Default.ShoppingCart,
        selectedColor = Color(0xFFf4a261)
    )
    object ScreenD : NavigationItem(
        title = "Settings",
        route = "screenD",
        icon = Icons.Default.Settings,
        selectedColor = Color(0xFFe76f51)
    )
}