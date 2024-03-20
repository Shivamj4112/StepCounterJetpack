package com.example.stepcounterjetpack.viewModels

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import com.example.stepcounterjetpack.view.activities.LoginActivity
import com.example.stepcounterjetpack.view.activities.SignUpActivity

class LoginViewModel : ViewModel(){

    fun navigateToSignup(context : Activity, navigationCallback: () -> Unit) {

        val intent = Intent(context, SignUpActivity::class.java)
        context.startActivity(intent)
        context.finish()

        navigationCallback.invoke()
    }

}