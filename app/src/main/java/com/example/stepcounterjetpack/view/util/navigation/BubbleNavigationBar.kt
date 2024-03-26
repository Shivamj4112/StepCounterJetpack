package com.example.stepcounterjetpack.view.util.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.stepcounterjetpack.view.theme.ui.AppBackground
import com.example.stepcounterjetpack.view.theme.ui.AppColor
import ir.kaaveh.sdpcompose.sdp

@Composable
fun BubbleNavigationBar(
    modifier: Modifier = Modifier,
    navigationHeight: Dp = 64.dp,
    containerColor: Color = Color.White,
    content: @Composable RowScope.() -> Unit
) {
    Surface(
        color = containerColor,
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 24.dp)
                .heightIn(max = 96.dp)
                .height(navigationHeight)
                .padding(horizontal = Dp(navigationHeight / (navigationHeight / 16)))
                .selectableGroup(),
            horizontalArrangement = Arrangement.SpaceBetween,
            content = content
        )
    }
}