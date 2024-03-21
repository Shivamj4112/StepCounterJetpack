package com.example.stepcounterjetpack.view.activities

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.stepcounterjetpack.view.Screen.StatusBarColorWhite
import com.example.stepcounterjetpack.view.Screen.SelectionLoginScreen
import com.example.stepcounterjetpack.viewModels.SelectionViewModel

class SelectionLoginActivity : ComponentActivity() {

    private val selectionModel : SelectionViewModel by viewModels()
    private lateinit var sharPref : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StatusBarColorWhite()


            sharPref = getSharedPreferences("Signup", MODE_PRIVATE)

            if (sharPref.contains("isAccountCreated")){
                Toast.makeText(this, "Hello! ${sharPref.getString("userName","")}", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, UserDetailsActivity::class.java))
                finish()
            }else{
                SelectionLoginScreen(this,selectionModel)
            }


        }
    }
}