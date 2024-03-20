package com.example.stepcounterjetpack.viewModels

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import com.example.stepcounterjetpack.view.activities.LoginActivity
import com.example.stepcounterjetpack.view.activities.SignUpActivity

class SelectionViewModel : ViewModel() {


    fun selectionSignup(context : Activity, navigateToSignup : () -> Unit){

        val intent = Intent(context, SignUpActivity::class.java)
        context.startActivity(intent)
        navigateToSignup.invoke()
    }

    fun selectionLogin(context : Activity, navigateToSignup : () -> Unit){

        val intent = Intent(context, LoginActivity::class.java)
        context.startActivity(intent)
        navigateToSignup.invoke()
    }

}