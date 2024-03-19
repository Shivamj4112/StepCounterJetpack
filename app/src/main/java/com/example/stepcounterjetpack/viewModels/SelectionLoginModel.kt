package com.example.stepcounterjetpack.viewModels

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import com.example.stepcounterjetpack.view.activities.SignUpActivity

class SelectionLoginModel : ViewModel() {



    fun selectionSignup(context : Context, navigateToSignup : () -> Unit){


        val intent = Intent(context, SignUpActivity::class.java)
        context.startActivity(intent)


        navigateToSignup.invoke()
    }

}