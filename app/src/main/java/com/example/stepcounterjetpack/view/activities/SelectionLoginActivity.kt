package com.example.stepcounterjetpack.view.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.stepcounterjetpack.view.Screen.StatusBarColorWhite
import com.example.stepcounterjetpack.view.Screen.SelectionLoginScreen
import com.example.stepcounterjetpack.viewModels.SelectionLoginModel

class SelectionLoginActivity : ComponentActivity() {

    private val selectionModel : SelectionLoginModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StatusBarColorWhite()
            SelectionLoginScreen(this,selectionModel)
        }
    }
}

