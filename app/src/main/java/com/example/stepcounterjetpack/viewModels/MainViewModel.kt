package com.example.stepcounterjetpack.viewModels

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.ViewModel
import com.example.stepcounterjetpack.view.activities.PlansActivity


class MainViewModel : ViewModel() {

    fun navigateToPlans(context : Activity){

        val intent = Intent(context, PlansActivity::class.java)
        context.startActivity(intent)

    }

}



