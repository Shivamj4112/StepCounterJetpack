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
    private lateinit var sharPref : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StatusBarColorWhite()

//
//            sharPref = getSharedPreferences("Signup", MODE_PRIVATE)
//
//            if (sharPref.contains("isAccountCreated")){
//                Toast.makeText(this, "Hello! ${sharPref.getString("userName","")}", Toast.LENGTH_SHORT).show()
//                startActivity(Intent(this, UserDetailsActivity::class.java))
//                finish()
//            }else{
//
//            }

            val sharedPreferencesLogin: SharedPreferences = getSharedPreferences("Login", MODE_PRIVATE)
            val sharedPreferencesSignUp: SharedPreferences = getSharedPreferences("Signup", MODE_PRIVATE)
            val sharedPreferencesDetail: SharedPreferences = getSharedPreferences("UserDetail", MODE_PRIVATE)


            if (sharedPreferencesLogin.contains("uid")) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
            else if (sharedPreferencesDetail.contains("idDetailFilled")){
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