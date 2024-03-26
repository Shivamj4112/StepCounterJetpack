package com.example.stepcounterjetpack.view.activities

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.stepcounterjetpack.view.Screen.SelectionLoginScreen
import com.example.stepcounterjetpack.view.Screen.StatusBarColorWhite
import com.example.stepcounterjetpack.viewModels.SelectionViewModel

class SelectionLoginActivity : ComponentActivity() {

    private val selectionModel : SelectionViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StatusBarColorWhite()

            val sharedPreferencesLogin: SharedPreferences = getSharedPreferences("Login", MODE_PRIVATE)
            val sharedPreferencesSignUp: SharedPreferences = getSharedPreferences("Signup", MODE_PRIVATE)
            val sharedPreferencesDetail: SharedPreferences = getSharedPreferences("UserDetail", MODE_PRIVATE)


            if (sharedPreferencesLogin.contains("uid")) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
            else if (sharedPreferencesDetail.contains("isDetailFilled")){
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
            else if (sharedPreferencesSignUp.contains("isAccountCreated")) {
                startActivity(Intent(this, UserDetailsActivity::class.java))
                finish()

            }
            else{
                SelectionLoginScreen(this,selectionModel)
            }
        }
    }
}