package com.example.stepcounterjetpack.view.Screen

import android.app.Activity
import android.os.Build
import android.view.WindowInsetsController
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.stepcounterjetpack.view.activities.ui.theme.AppBackground
import com.example.stepcounterjetpack.view.activities.ui.theme.AppColor
import com.example.stepcounterjetpack.view.activities.ui.theme.BodyTextFont
import com.example.stepcounterjetpack.view.activities.ui.theme.DefaultTextColor
import com.example.stepcounterjetpack.view.activities.ui.theme.LightGrey
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp


@Composable
fun Activity.SetSystemBarsAppearance() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        this.window.decorView.windowInsetsController?.setSystemBarsAppearance(
            0, WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
        )
    }
}

@Composable
fun Activity.StatusBarColorWhite() {
    window.statusBarColor = AppBackground.toArgb()
}

@Composable
fun Activity.StatusBarColorGrey() {
    window.statusBarColor = LightGrey.toArgb()
}


// TODO  Simple Text View

@Composable
fun SimpleTextComponent(
    modifier: Modifier,
    text: String,
    textSize: TextUnit = 14.ssp,
    fontFamily: FontFamily? = null,
    textColor: Color = DefaultTextColor,
    textAlign: TextAlign = TextAlign.Center,
) {

    Text(
        modifier = modifier,
        text = text,
        fontSize = textSize,
        fontFamily = fontFamily,
        color = textColor,
        textAlign = textAlign
    )
}

// TODO  Clickable Text View
@Composable
fun ClickableTextComponent(
    modifier: Modifier,
    text: String,
    textSize: TextUnit = 14.ssp,
    fontFamily: FontFamily? = null,
    textColor: Color = DefaultTextColor,
    textAlign: TextAlign = TextAlign.Center,
    onClick: () -> Unit
) {

    Text(
        modifier = modifier,
        text = text,
        fontSize = textSize,
        fontFamily = fontFamily,
        color = textColor,
        textAlign = textAlign
    )
}

@Composable
fun SimpleCheckBox() {

    val checkedState = remember { mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start) {
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = {
                checkedState.value = it
            }
        )
        SimpleTextComponent(modifier = Modifier,text = "I agree to TrackFit", textColor = Color.Black , fontFamily = BodyTextFont, textSize = 12.ssp)
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleEditText(
    modifier: Modifier,
    hint: String = "",
    onTextChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text
) {

    val textState = remember { mutableStateOf("") }


    TextField(
        modifier = modifier,
        value = textState.value,
        onValueChange = {
            textState.value = it
            onTextChange(it)
        },
        singleLine = true,
        shape = RoundedCornerShape(8.sdp),
        colors = TextFieldDefaults.textFieldColors(
            disabledTextColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
        placeholder = {
            SimpleTextComponent(modifier = Modifier,text = hint, textSize = 10.ssp)
        }
    )
}


// TODO  Simple Button

@Composable
fun SimpleButton(
    text: String,
    fontFamily: FontFamily? = null,
    textColor: Color = DefaultTextColor,
    textSize: TextUnit = 14.ssp,
    padding: Dp = 0.sdp,
    paddingVertical: Dp = 0.sdp,
    paddingHorizontal: Dp = 0.sdp,
    paddingStart: Dp = 0.sdp,
    paddingTop: Dp = 0.sdp,
    paddingEnd: Dp = 0.sdp,
    paddingBottom: Dp = 0.sdp,
    height: Dp = 35.sdp,
    backGroundColor: Color = AppColor,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = padding)
            .padding(horizontal = paddingHorizontal, vertical = paddingVertical)
            .padding(
                start = paddingStart,
                top = paddingTop,
                end = paddingEnd,
                bottom = paddingBottom
            )
            .height(height = height),
        colors = ButtonDefaults.buttonColors(containerColor = backGroundColor),
        onClick = onClick


    )
    {

        SimpleTextComponent(
            modifier = Modifier,
            text = text,
            textColor = textColor,
            fontFamily = fontFamily,
            textSize = textSize,
            textAlign = TextAlign.Center
        )

    }
}


// TODO  LottieAnimations
@Composable
fun LottieAnimations(
    rawResId: Int
) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(rawResId))

    LottieAnimation(composition = composition, iterations = LottieConstants.IterateForever)
}