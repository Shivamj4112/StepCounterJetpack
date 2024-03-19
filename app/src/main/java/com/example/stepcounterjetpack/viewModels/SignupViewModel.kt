package com.example.stepcounterjetpack.viewModels

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import com.example.stepcounterjetpack.view.activities.LoginActivity
import com.example.stepcounterjetpack.view.activities.SignUpActivity

class SignupViewModel : ViewModel(){

    fun navigateToLogin(context : Activity, navigationCallback: () -> Unit) {

        val intent = Intent(context, LoginActivity::class.java)
        context.startActivity(intent)
        context.finish()

        navigationCallback.invoke()
    }

}