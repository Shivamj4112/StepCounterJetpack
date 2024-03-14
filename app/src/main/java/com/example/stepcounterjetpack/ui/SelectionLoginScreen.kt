package com.example.stepcounterjetpack.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.stepcounterjetpack.R
import com.example.stepcounterjetpack.activities.ui.theme.BodyTextFont
import com.example.stepcounterjetpack.activities.ui.theme.StepCounterJetpackTheme
import com.example.stepcounterjetpack.activities.ui.theme.TileTextFont
import com.example.stepcounterjetpack.composableUI.SimpleTextComponent
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Composable
fun SelectionLoginScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    )

    {

        Image(
            painter = painterResource(id = R.drawable.ic_footsteps),
            contentDescription = null,
            modifier = Modifier.size(50.sdp),
        )

        SimpleTextComponent(
            text = "Let's Get Started!",
            textColor = Color.Black,
            textSize = 25.ssp,
            fontFamily = TileTextFont,
            paddingTop = 30.sdp
        )

        SimpleTextComponent(
            text = "Let's dive in into yoru account",
            paddingTop = 15.sdp,
            fontFamily = BodyTextFont,
            textSize = 12.ssp
        )

        ElevatedCard(
            modifier = Modifier
                .padding(top = 40.sdp)
                .padding(horizontal = 20.sdp),
            shape = RoundedCornerShape(12.sdp),
            colors = CardDefaults.elevatedCardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                disabledContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                disabledContentColor = MaterialTheme.colorScheme.onTertiaryContainer
            ),
            elevation = CardDefaults.cardElevation(1.sdp)
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 15.sdp, vertical = 12.sdp)
                    .fillMaxWidth()
                    .height(20.sdp)
            ) {

                Box (modifier = Modifier.fillMaxSize()){

                    Image(
                        painter = painterResource(id = R.drawable.ic_google),
                        contentDescription = null,
                        modifier = Modifier.size(20.sdp),
                    )

                    Box(Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center){
                        SimpleTextComponent(text = "Continue with Google")
                    }

                }


            }
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun SelectionLoginScreenPreview() {
    StepCounterJetpackTheme {
        SelectionLoginScreen()
    }
}
