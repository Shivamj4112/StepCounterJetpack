package com.example.stepcounterjetpack.viewModels

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.annotation.RequiresApi
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import com.example.stepcounterjetpack.view.activities.PlansActivity
import com.example.stepcounterjetpack.view.theme.ui.TitleTextFont
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import ir.kaaveh.sdpcompose.ssp


class MainViewModel : ViewModel() {



}

fun navigateToPlans(context : Context){

    val intent = Intent(context, PlansActivity::class.java)
    context.startActivity(intent)

}

