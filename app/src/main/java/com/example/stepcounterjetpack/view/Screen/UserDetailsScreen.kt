package com.example.stepcounterjetpack.view.Screen

import android.app.Activity
import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.stepcounterjetpack.R
import com.example.stepcounterjetpack.models.UserModel
import com.example.stepcounterjetpack.view.activities.theme.ui.AppBackground
import com.example.stepcounterjetpack.view.activities.theme.ui.AppColor
import com.example.stepcounterjetpack.view.activities.theme.ui.BodyTextFont
import com.example.stepcounterjetpack.view.activities.theme.ui.DefaultTextColor
import com.example.stepcounterjetpack.view.activities.theme.ui.LightGrey
import com.example.stepcounterjetpack.view.activities.theme.ui.LightestAppColor
import com.example.stepcounterjetpack.view.activities.theme.ui.TitleTextFont
import com.example.stepcounterjetpack.view.util.DigitPicker
import com.example.stepcounterjetpack.view.util.toast
import com.example.stepcounterjetpack.viewModels.UserDetailsViewModel
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp


var model = UserModel()

@OptIn(ExperimentalFoundationApi::class)
@Composable
//fun UserDetailsScreen(context: Activity, userDetailsViewModel: UserDetailsViewModel) {
fun UserDetailsScreen() {

    var currentScreen by remember { mutableStateOf(0) }
    var progressCount: Int by remember { mutableStateOf(3) }

    Column(Modifier.fillMaxSize()) {

        Column(
            Modifier
                .fillMaxSize()
                .weight(1f)
        ) {

            Scaffold(
                topBar = {
                    IntroToolBar(
                        size = 20.sdp,
                        currentScreen = currentScreen,
                        progressCount = progressCount,
                        onClick = {

                        })
                }
            ) {
                Column(modifier = Modifier.padding(it)) {

                    when (currentScreen) {

                        0 -> IntroScreen1()
                        1 -> IntroScreen2()
                        2 -> IntroScreen3()
                        3 -> IntroScreen4()
                        4 -> IntroScreen5()
                        5 -> IntroScreen6()

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
                    text = "Previous",
                    textColor = AppColor,
                    fontFamily = TitleTextFont.fontFamily,
                    height = 45.sdp,
                    backGroundColor = LightestAppColor
                ) {
                    if (currentScreen > 0) {
                        currentScreen--
                        progressCount--
                    }
                }
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
                ) {
//                    if (currentScreen < 5) currentScreen++
                    when (currentScreen) {
                        0 -> if (model.gender.isNotEmpty()) {
                            currentScreen++
                            progressCount++
                        }
//                        else context.toast("Gender")

                        1 -> if (model.sedentary.isNotEmpty()) {
                            currentScreen++
                            progressCount++
                        }
//                        else context.toast("Sedentary")

                        2 -> if (model.age > 0) {
                            currentScreen++
                            progressCount++
                        }
//                        else context.toast("Age")

                        3 -> if (model.height > 0) {
                            currentScreen++
                            progressCount++
                        }
//                        else context.toast("Height")

                        4 -> if (model.weight > 0) {
                            currentScreen++
                            progressCount++
                        }
//                        else context.toast("Weight")

//                        5 -> if (model.step > 0) {
//                            userDetailsViewModel.updateDataInDatabase(
//                                context,
//                                model.gender,
//                                model.sedentary,
//                                model.age,
//                                model.heightType,
//                                model.weightType,
//                                model.step
//                            )
//                        }

                    }
                }
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

            var sedenState by remember { mutableStateOf(model.sedentary) }

            Button(
                modifier = Modifier
                    .size(55.sdp)
                    .clip(RoundedCornerShape(10.sdp)),
                colors = if (sedenState == "No") ButtonDefaults.buttonColors(containerColor = AppColor) else ButtonDefaults.buttonColors(
                    containerColor = LightestAppColor
                ),
                onClick = {
                    sedenState = "No"
                    model.sedentary = sedenState
                }) {

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
                onClick = {
                    sedenState = "Yes"
                    model.sedentary = sedenState
                }) {

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

        var ageValue by remember { mutableIntStateOf(model.age) }
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


        Box(
            modifier = Modifier
                .fillMaxHeight()
                .wrapContentWidth()
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 120.sdp),
            contentAlignment = Alignment.Center
        ) {


            DigitPicker(
                modifier = Modifier.width(100.sdp),
                value = ageValue,
                range = 10..100,
                onValueChange = {
                    ageValue = it
                    model.age = ageValue

                },
            )
            SimpleTextComponent(
                modifier = Modifier.align(Alignment.CenterEnd),
                text = "Years",
                fontFamily = TitleTextFont.fontFamily,
                textSize = 12.ssp
            )

        }


    }
}

@Composable
fun IntroScreen4() {

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

        Row {
            SimpleTextComponent(
                modifier = Modifier.padding(top = 10.sdp),
                text = "What's Your ",
                textSize = 24.ssp,
                fontFamily = TitleTextFont.fontFamily,
                textColor = Color.Black
            )

            SimpleTextComponent(
                modifier = Modifier.padding(top = 10.sdp),
                text = "Height",
                textSize = 24.ssp,
                fontFamily = TitleTextFont.fontFamily,
                textColor = AppColor
            )

            SimpleTextComponent(
                modifier = Modifier.padding(top = 10.sdp),
                text = "?",
                textSize = 24.ssp,
                fontFamily = TitleTextFont.fontFamily,
                textColor = Color.Black
            )

        }

        SimpleTextComponent(
            modifier = Modifier.padding(top = 10.sdp),
            text = "How tall are you?",
            textSize = 12.ssp,
            fontFamily = BodyTextFont
        )

        HeightPicker()

    }
}

@Composable
fun IntroScreen5() {

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

        Row {
            SimpleTextComponent(
                modifier = Modifier.padding(top = 10.sdp),
                text = "What's Your ",
                textSize = 24.ssp,
                fontFamily = TitleTextFont.fontFamily,
                textColor = Color.Black
            )

            SimpleTextComponent(
                modifier = Modifier.padding(top = 10.sdp),
                text = "Weight",
                textSize = 24.ssp,
                fontFamily = TitleTextFont.fontFamily,
                textColor = AppColor
            )

            SimpleTextComponent(
                modifier = Modifier.padding(top = 10.sdp),
                text = "?",
                textSize = 24.ssp,
                fontFamily = TitleTextFont.fontFamily,
                textColor = Color.Black
            )
        }

        SimpleTextComponent(
            modifier = Modifier.padding(top = 10.sdp),
            text = "Share your weight with us.",
            textSize = 12.ssp,
            fontFamily = BodyTextFont
        )

        WeightPicker()


    }
}

@Composable
fun IntroScreen6() {

    var pickerValue by remember { mutableIntStateOf(model.step) }

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

        Row {
            SimpleTextComponent(
                modifier = Modifier.padding(top = 10.sdp),
                text = "Set Your",
                textSize = 24.ssp,
                fontFamily = TitleTextFont.fontFamily,
                textColor = Color.Black
            )

            SimpleTextComponent(
                modifier = Modifier.padding(top = 10.sdp),
                text = " Step Goal",
                textSize = 24.ssp,
                fontFamily = TitleTextFont.fontFamily,
                textColor = AppColor
            )
        }

        SimpleTextComponent(
            modifier = Modifier.padding(top = 10.sdp),
            text = "Choose your daily step goal to stay motivated!",
            textSize = 12.ssp,
            fontFamily = BodyTextFont
        )

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .wrapContentWidth()
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 120.sdp),
            contentAlignment = Alignment.Center
        ) {


            DigitPicker(
                modifier = Modifier.width(150.sdp),
                value = pickerValue,
                range = 1000..10000 step 500,
                onValueChange = {
                    pickerValue = it
                    model.step = pickerValue
                },
            )
            SimpleTextComponent(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 10.sdp),
                text = "Steps",
                fontFamily = TitleTextFont.fontFamily,
                textSize = 12.ssp
            )

        }
    }
}

@Composable
fun HeightPicker() {
    var heightType by remember { mutableStateOf(true) }
    val range = if (heightType) 50..300 else 2..12
    val text = if (heightType) "cm" else "ft"
    var cmPickerValue by remember { mutableStateOf(model.cmHeight) }
    var ftPickerValue by remember { mutableStateOf(model.ftHeight) }


    Column {
        Row(modifier = Modifier.padding(top = 20.sdp)) {
            // Button for "cm"
            Button(
                modifier = Modifier,
                colors = if (heightType) ButtonDefaults.buttonColors(containerColor = AppColor) else ButtonDefaults.buttonColors(
                    containerColor = LightestAppColor
                ),
                onClick = { heightType = true }
            ) {
                SimpleTextComponent(
                    modifier = Modifier,
                    text = "cm",
                    textColor = if (heightType) Color.White else AppColor,
                    textSize = 12.ssp,
                    fontFamily = TitleTextFont.fontFamily
                )
            }

            Spacer(modifier = Modifier.width(20.sdp))

            // Button for "ft"
            Button(
                modifier = Modifier,
                colors = if (!heightType) ButtonDefaults.buttonColors(containerColor = AppColor) else ButtonDefaults.buttonColors(
                    containerColor = LightestAppColor
                ),
                onClick = {
                    heightType = false

                }
            ) {
                SimpleTextComponent(
                    modifier = Modifier,
                    text = "ft",
                    textColor = if (!heightType) Color.White else AppColor,
                    textSize = 12.ssp,
                    fontFamily = TitleTextFont.fontFamily
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .wrapContentWidth()
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 120.sdp),
            contentAlignment = Alignment.Center
        ) {

            if (heightType) {

                model.height = cmPickerValue
                model.cmHeight = cmPickerValue
                model.heightType = cmPickerValue.toString() + " cm"

                DigitPicker(
                    modifier = Modifier.width(100.sdp),
                    value = cmPickerValue,
                    range = range,
                    onValueChange = {
                        cmPickerValue = it
                        model.height = cmPickerValue
                        model.cmHeight = cmPickerValue
                        model.heightType = cmPickerValue.toString() + " cm"
                    },
                )
            } else {

                model.height = ftPickerValue
                model.ftHeight = ftPickerValue
                model.heightType = ftPickerValue.toString() + " ft"

                DigitPicker(
                    modifier = Modifier.width(100.sdp),
                    value = ftPickerValue,
                    range = range,
                    onValueChange = {
                        ftPickerValue = it
                        model.height = ftPickerValue
                        model.ftHeight = ftPickerValue
                        model.heightType = ftPickerValue.toString() + " ft"
                    },
                )
            }

            SimpleTextComponent(
                modifier = Modifier.align(Alignment.CenterEnd),
                text = text,
                fontFamily = TitleTextFont.fontFamily,
                textSize = 12.ssp
            )
        }
    }
}

@Composable
fun WeightPicker() {
    var weightType by remember { mutableStateOf(true) }
    val range = if (weightType) 10..300 else 1..1500
    var text by remember { mutableStateOf("kg") }
    var kgPickerValue by remember { mutableStateOf(model.kgweight) }
    var lbsPickerValue by remember { mutableStateOf(model.lbsweight) }


    Column {
        Row(modifier = Modifier.padding(top = 20.sdp)) {
            // Button for "kg"
            Button(
                modifier = Modifier,
                colors = if (weightType) ButtonDefaults.buttonColors(containerColor = AppColor) else ButtonDefaults.buttonColors(
                    containerColor = LightestAppColor
                ),
                onClick = { weightType = true }
            ) {
                SimpleTextComponent(
                    modifier = Modifier,
                    text = "kg",
                    textColor = if (weightType) Color.White else AppColor,
                    textSize = 12.ssp,
                    fontFamily = TitleTextFont.fontFamily
                )
            }
            Spacer(modifier = Modifier.width(20.sdp))

            // Button for "lbs"
            Button(
                modifier = Modifier,
                colors = if (!weightType) ButtonDefaults.buttonColors(containerColor = AppColor) else ButtonDefaults.buttonColors(
                    containerColor = LightestAppColor
                ),
                onClick = { weightType = false }
            ) {
                SimpleTextComponent(
                    modifier = Modifier,
                    text = "lbs",
                    textColor = if (!weightType) Color.White else AppColor,
                    textSize = 12.ssp,
                    fontFamily = TitleTextFont.fontFamily
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .wrapContentWidth()
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 120.sdp),
            contentAlignment = Alignment.Center
        ) {

            if (weightType) {

                model.weight = kgPickerValue
                model.kgweight = kgPickerValue
                model.weightType = kgPickerValue.toString() + " kg"

                DigitPicker(
                    modifier = Modifier.width(100.sdp),
                    value = kgPickerValue,
                    range = range,
                    onValueChange = {
                        kgPickerValue = it
                        model.weight = kgPickerValue
                        model.kgweight = kgPickerValue
                        model.weightType = kgPickerValue.toString() + " kg"
                    },
                )
            } else {
                model.weight = lbsPickerValue
                model.lbsweight = lbsPickerValue
                model.weightType = lbsPickerValue.toString() + " lbs"

                DigitPicker(
                    modifier = Modifier.width(100.sdp),
                    value = lbsPickerValue,
                    range = range,
                    onValueChange = {
                        lbsPickerValue = it
                        model.weight = lbsPickerValue
                        model.lbsweight = lbsPickerValue
                        model.weightType = lbsPickerValue.toString() + " lbs"
                    },
                )
            }
            SimpleTextComponent(
                modifier = Modifier.align(Alignment.CenterEnd),
                text = text,
                fontFamily = TitleTextFont.fontFamily,
                textSize = 12.ssp
            )
        }

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
        var selectedGender by remember { mutableStateOf(model.gender) }

        Card(
            colors = CardDefaults.cardColors(containerColor = AppBackground),

            modifier = Modifier
                .padding(top = 10.sdp)
                .border(
                    width = if (selectedGender == "male") 2.sdp else 0.sdp,
                    color = if (selectedGender == "male") AppColor else AppBackground,
                    shape = RoundedCornerShape(10.sdp)
                )
                .clip(RoundedCornerShape(10.sdp))
                .clickable {
                    model.gender = "male"
                    selectedGender = "male"
                },
        ) {

            Column(modifier = Modifier.padding(vertical = 10.sdp, horizontal = 5.sdp)) {
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
                    color = if (selectedGender == "female") AppColor else AppBackground,
                    shape = RoundedCornerShape(10.sdp)
                )
                .clip(RoundedCornerShape(10.sdp))
                .clickable {
                    model.gender = "female"
                    selectedGender = "female"
                },
        ) {

            Column(modifier = Modifier.padding(vertical = 10.sdp, horizontal = 5.sdp)) {
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
    currentScreen: Int,
    progressCount: Int,
    backgroundColor: Color = AppBackground,
    onClick: () -> Unit,

    ) {

    TopAppBar(
        modifier = Modifier.wrapContentHeight(),
        title = {

            CustomProgressBar(progressCount)

//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(bottom = 12.sdp),
//                contentAlignment = Alignment.Center
//            ) {
//
//                SimpleTextComponent(
//                    modifier = Modifier,
//                    text = "toolbarTitle",
//                    fontFamily = TitleTextFont.fontFamily
//                )
//            }
        },
        navigationIcon = {



            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Arrow Back",
                modifier = Modifier
                    .alpha(0f)
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
                text = "${currentScreen + 1} / 6",
                fontFamily = TitleTextFont.fontFamily,
                textColor = Color.Black
            )

        }
    )
}



    @Composable
    fun CustomProgressBar(progressCount: Int) {


        var progress by remember { mutableStateOf(0f) }

        when (progressCount) {
            0 -> progress = 0.2f
            1 -> progress = 0.4f
            2 -> progress = 0.6f
            3 -> progress = 0.8f
            4 -> progress = 1.0f
        }

        val size by animateFloatAsState(
            targetValue = progress,
            tween(
                durationMillis = 1000,
                delayMillis = 200,
                easing = LinearOutSlowInEasing
            )
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 100.dp, start = 30.dp, end = 30.dp)
        ) {

            // Progress Bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(13.sdp)
            ) {
                // for the background of the ProgressBar
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(15.sdp))
                        .background(LightestAppColor)
                )
                // for the progress of the ProgressBar
                Box(
                    modifier = Modifier
                        .fillMaxWidth(size)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(15.sdp))
                        .background(AppColor)
                        .animateContentSize()
                )
            }



        }

//        LaunchedEffect(key1 = true) {
//            progressCount = 7
//        }


}

@Composable
fun CustomProgressBar2() {


    var progress by remember { mutableStateOf(0f) }
    var progressCount by remember { mutableStateOf(3) }

    when (progressCount) {
        0 -> progress = 0.2f
        1 -> progress = 0.4f
        2 -> progress = 0.6f
        3 -> progress = 0.8f
        4 -> progress = 1f
    }

    val size by animateFloatAsState(
        targetValue = progress,
        tween(
            durationMillis = 1000,
            delayMillis = 200,
            easing = LinearOutSlowInEasing
        )
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp, start = 30.dp, end = 30.dp)
    ) {

        // Progress Bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(13.sdp)
        ) {
            // for the background of the ProgressBar
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(15.sdp))
                    .background(LightestAppColor)
            )
            // for the progress of the ProgressBar
            Box(
                modifier = Modifier
                    .fillMaxWidth(size)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(15.sdp))
                    .background(AppColor)
                    .animateContentSize()
            )
        }



    }

//        LaunchedEffect(key1 = true) {
//            progressCount = 7
//        }


}

@Preview(showSystemUi = true)
@Composable
fun IntroPreview() {

    UserDetailsScreen()
//    CustomProgressBar2()
}