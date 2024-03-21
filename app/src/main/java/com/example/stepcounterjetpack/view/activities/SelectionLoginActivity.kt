package com.example.stepcounterjetpack.view.activities

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.stepcounterjetpack.view.Screen.StatusBarColorWhite
import com.example.stepcounterjetpack.view.Screen.SelectionLoginScreen
import com.example.stepcounterjetpack.viewModels.SelectionViewModel

class SelectionLoginActivity : ComponentActivity() {

    private val selectionModel : SelectionViewModel by viewModels()
    private lateinit var sharPref : SharedPreferences
    private lateinit var editor : SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StatusBarColorWhite()


            sharPref = getSharedPreferences("Signup", MODE_PRIVATE)
            editor = sharPref.edit()

            if (sharPref.contains("isAccountCreated")){
                startActivity(Intent(this, UserDetailsActivity::class.java))
                finish()
            }else{
                SelectionLoginScreen(this,selectionModel)
            }


        }
    }
}