package com.example.stepcounterjetpack.view.util

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import com.example.stepcounterjetpack.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import com.example.stepcounterjetpack.view.theme.ui.AppColor
import com.example.stepcounterjetpack.view.theme.ui.TitleTextFont
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp


@Composable
fun CircularSlider(
    modifier: Modifier,
    canvasSize: Dp = 300.dp,
    indicatorValue: Int = 0,
    maxIndicatorValue: Int = 100,
    backgroundIndicatorColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f),
    backgroundIndicatorStrokeWidth: Float = 80f,
    foregroundIndicatorColor: Color = AppColor,
    foregroundIndicatorStrokeWidth: Float = 80f,
    bigTextFontSize: TextUnit = MaterialTheme.typography.titleMedium.fontSize,
    bigTextColor: Color = MaterialTheme.colorScheme.onSurface,
    bigTextSuffix: String = "GB",
    smallText: String = "Remaining",
    smallTextFontSize: TextUnit = MaterialTheme.typography.titleMedium.fontSize,
    smallTextColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
    tickCount: Int = 16, // Number of ticks
    tickLength: Float = 16f, // Length of ticks
    tickWidth: Float = 4f, // Width of ticks
    tickColor: Color = Color.Gray // Color of ticks
) {


    var allowedIndicatorValue by remember {
        mutableStateOf(maxIndicatorValue)
    }
    allowedIndicatorValue = if (indicatorValue <= maxIndicatorValue) {
        indicatorValue
    } else {
        maxIndicatorValue
    }

    var animatedIndicatorValue by remember { mutableStateOf(0f) }
    LaunchedEffect(key1 = allowedIndicatorValue) {
        animatedIndicatorValue = allowedIndicatorValue.toFloat()
    }

    val percentage =
        (animatedIndicatorValue / maxIndicatorValue) * 100

    val sweepAngle by animateFloatAsState(
        targetValue = (2.4 * percentage).toFloat(),
        animationSpec = tween(1000)
    )

    val receivedValue by animateIntAsState(
        targetValue = allowedIndicatorValue,
        animationSpec = tween(1000)
    )

    val animatedBigTextColor by animateColorAsState(
        targetValue = if (allowedIndicatorValue == 0)
            MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f)
        else
            bigTextColor,
        animationSpec = tween(1000)
    )

    Column(
        modifier = modifier
            .size(canvasSize)
            .drawBehind {
                val componentSize = size / 1.25f
                backgroundIndicator(
                    componentSize = componentSize,
                    indicatorColor = backgroundIndicatorColor,
                    indicatorStrokeWidth = backgroundIndicatorStrokeWidth,
                    tickCount = tickCount,
                    tickLength = tickLength,
                    tickWidth = tickWidth,
                    tickColor = tickColor
                )
                foregroundIndicator(
                    sweepAngle = sweepAngle,
                    componentSize = componentSize,
                    indicatorColor = foregroundIndicatorColor,
                    indicatorStrokeWidth = foregroundIndicatorStrokeWidth,
                    indicatorValue = indicatorValue,
                    maxIndicatorValue = maxIndicatorValue
                )
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EmbeddedElements(
            bigText = receivedValue,
            bigTextFontSize = bigTextFontSize,
            bigTextColor = animatedBigTextColor,
            bigTextSuffix = bigTextSuffix,
            smallText = smallText,
            smallTextColor = smallTextColor,
            smallTextFontSize = smallTextFontSize
        )
    }
}

fun DrawScope.backgroundIndicator(
    componentSize: Size,
    indicatorColor: Color,
    indicatorStrokeWidth: Float,
    tickCount: Int,
    tickLength: Float,
    tickWidth: Float,
    tickColor: Color
) {
    drawArc(
        size = componentSize,
        color = indicatorColor,
//        startAngle = 150f,
//        sweepAngle = 240f,
        startAngle = 123f,
        sweepAngle = 290f,
        useCenter = false,
        style = Stroke(
            width = indicatorStrokeWidth,
            cap = StrokeCap.Round
        ),
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2f,
            y = (size.height - componentSize.height) / 2f
        )
    )

    val tickSpacing = 280f / (tickCount - 1)
    val radius = componentSize.width / 2.7
    val center = Offset(size.width / 2, size.height / 2)

    for (i in 0 until tickCount) {
        val angle = 130f + i * tickSpacing
        val startX = center.x + (radius - tickLength / 2.0) * kotlin.math.cos(Math.toRadians(angle.toDouble()))
        val startY = center.y + (radius - tickLength / 2.0) * kotlin.math.sin(Math.toRadians(angle.toDouble()))
        val endX = center.x + (radius + tickLength / 2.0) * kotlin.math.cos(Math.toRadians(angle.toDouble()))
        val endY = center.y + (radius + tickLength / 2.0) * kotlin.math.sin(Math.toRadians(angle.toDouble()))

        // idea :- check tick length and value length compare ands ser color according to it
        drawLine(
            color = tickColor,
            start = Offset(startX.toFloat(), startY.toFloat()),
            end = Offset(endX.toFloat(), endY.toFloat()),
            strokeWidth = tickWidth
        )
    }
}

fun DrawScope.foregroundIndicator(
    sweepAngle: Float,
    componentSize: Size,
    indicatorColor: Color,
    indicatorStrokeWidth: Float,
    maxIndicatorValue: Int,
    indicatorValue: Int
) {
    val percentage = indicatorValue.toFloat() / maxIndicatorValue
    val sweepAngleAdjusted = (290 * percentage).toFloat() // Adjusted sweep angle based on percentage

    drawArc(
        size = componentSize,
        color = indicatorColor,
        startAngle = 123f,
        sweepAngle = sweepAngleAdjusted,
        useCenter = false,
        style = Stroke(
            width = indicatorStrokeWidth,
            cap = StrokeCap.Round
        ),
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2f,
            y = (size.height - componentSize.height) / 2f
        )
    )
}


//fun DrawScope.foregroundIndicator(
//    sweepAngle: Float,
//    componentSize: Size,// Color for low values
//    indicatorColor: Color, // Color for high values
//    indicatorStrokeWidth: Float,
//    maxIndicatorValue: Int,
//    indicatorValue: Int
//) {
//    val percentage = indicatorValue.toFloat() / maxIndicatorValue
//    val sweepAngleAdjusted = (290 * percentage).toFloat() // Adjusted sweep angle based on percentage
//    val indicatorColor = lerpColor(indicatorColor, percentage)
//
//    drawArc(
//        size = componentSize,
//        color = indicatorColor,
//        startAngle = 123f,
//        sweepAngle = sweepAngleAdjusted,
//        useCenter = false,
//        style = Stroke(
//            width = indicatorStrokeWidth,
//            cap = StrokeCap.Round
//        ),
//        topLeft = Offset(
//            x = (size.width - componentSize.width) / 2f,
//            y = (size.height - componentSize.height) / 2f
//        )
//    )
//}
//fun lerpColor(color: Color, fraction: Float): Color {
//    return Color(color.red, color.green, color.blue, alpha = fraction * color.alpha)
//}


@Composable
fun EmbeddedElements(
    bigText: Int,
    bigTextFontSize: TextUnit,
    bigTextColor: Color,
    bigTextSuffix: String,
    smallText: String,
    smallTextColor: Color,
    smallTextFontSize: TextUnit
) {
    Text(
        modifier = Modifier.padding(top = 60.sdp),
        text = "Steps",
        color = Color.Black,
        fontSize = 16.ssp,
        textAlign = TextAlign.Center
    )
    Text(
        modifier = Modifier.padding(top = 10.sdp,bottom = 10.sdp),
        text = "731",
        color = Color.Black,
        fontSize = 40.ssp,
        textAlign = TextAlign.Center,
        fontFamily = TitleTextFont.fontFamily
    )
    Text(
        text = "/6000",
        fontSize = 14.ssp,
        textAlign = TextAlign.Center,
    )

    Image(
        modifier = Modifier.padding(top = 5.sdp).size(50.sdp),
        painter = painterResource(id = R.drawable.ic_play),
        contentDescription = "Play")
}

@Composable
@Preview(showBackground = true)
fun CustomComponentPreview() {
    CircularSlider(modifier = Modifier)
}
