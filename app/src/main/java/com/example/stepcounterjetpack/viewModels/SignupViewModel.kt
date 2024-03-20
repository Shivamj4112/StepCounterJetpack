package com.example.stepcounterjetpack.viewModels

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import com.example.stepcounterjetpack.view.Screen.UserDetailsScreen
import com.example.stepcounterjetpack.view.activities.LoginActivity
import com.example.stepcounterjetpack.view.activities.SignUpActivity
import com.example.stepcounterjetpack.view.activities.UserDetailsActivity

class SignupViewModel : ViewModel(){

    fun navigateToLogin(context : Activity, navigationCallback: () -> Unit) {

        val intent = Intent(context, LoginActivity::class.java)
        context.startActivity(intent)
        context.finish()

        navigationCallback.invoke()
    }
    fun navigateToUserDetails(context : Activity, navigationCallback: () -> Unit) {

        val intent = Intent(context, UserDetailsActivity::class.java)
        context.startActivity(intent)

        navigationCallback.invoke()
    }

}