package com.example.stepcounterjetpack.viewModels

import android.Manifest
import android.annotation.SuppressLint
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
import com.example.stepcounterjetpack.view.theme.ui.TitleTextFont
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import ir.kaaveh.sdpcompose.ssp


class MainViewModel : ViewModel() {

}

@SuppressLint("PermissionLaunchedDuringComposition")
@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MultiplePermissionDemo() {
    val multiplePermission = rememberMultiplePermissionsState(
        permissions = listOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACTIVITY_RECOGNITION
        )
    )
    val context = LocalContext.current

    val showRationalDialog = remember { mutableStateOf(false) }
    if (showRationalDialog.value) {
        AlertDialog(
            onDismissRequest = {
                showRationalDialog.value = false
            },
            title = {
                Text(
                    text = "Permission",
                    fontFamily = TitleTextFont.fontFamily,
                    fontSize = 16.ssp
                )
            },
            text = {
                Text(
                    if (multiplePermission.revokedPermissions.size == 2) {
                        "We need Activity Physical and Location permission to this App"
                    } else if (multiplePermission.revokedPermissions.first().permission == Manifest.permission.CAMERA) {
                        "We need Activity Physical permission. Please grant the permission."
                    } else {
                        "We need Location permission. Please grant the permission."
                    },
                    fontSize = 16.ssp
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showRationalDialog.value = false
                        val intent = Intent(
                            Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                            Uri.fromParts("package", context.packageName, null)
                        )
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(context, intent, null)

                    }) {
                    Text("OK", style = TextStyle(color = Color.Black))
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showRationalDialog.value = false
                    }) {
                    Text("Cancel", style = TextStyle(color = Color.Black))
                }
            },
        )
    }
    if (!multiplePermission.allPermissionsGranted) {
        if (multiplePermission.shouldShowRationale) {
            // Show a rationale if needed (optional)
            showRationalDialog.value = true
        } else {
            // Request the permission
            multiplePermission.launchMultiplePermissionRequest()

        }
    }

}
