package com.example.stepcounterjetpack.viewModels

import android.os.Handler
import androidx.lifecycle.ViewModel

class SplashViewModel : ViewModel() {

    fun navigateToIntroScreen(navigationCallback: () -> Unit) {
        Handler().postDelayed({
            navigationCallback.invoke()
        }, 3000)
    }
}
