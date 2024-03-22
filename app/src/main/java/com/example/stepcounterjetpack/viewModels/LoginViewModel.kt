package com.example.stepcounterjetpack.viewModels

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.stepcounterjetpack.view.activities.LoginActivity
import com.example.stepcounterjetpack.view.activities.MainActivity
import com.example.stepcounterjetpack.view.activities.SignUpActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class LoginViewModel : ViewModel(){

    private var auth : FirebaseAuth = FirebaseAuth.getInstance()
    private lateinit var sharedPref : SharedPreferences
    private lateinit var editor : SharedPreferences.Editor

    fun loginAccount(context : Activity, email: String, password: String) {

        context.apply {
            sharedPref = getSharedPreferences("Login", Context.MODE_PRIVATE)
            editor = sharedPref.edit()
        }

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->

                if (task.isSuccessful){

                    val user = auth.currentUser
                    val uid = user?.uid


                    editor.putString("uid",uid)
                    editor.apply()

                    navigateToMain(context)

                } else{
                    Toast.makeText(context, task.exception?.message ?: "Authentication failed.", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun navigateToMain(context : Activity) {

        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
        context.finish()

    }
    fun navigateToSignup(context : Activity, navigationCallback: () -> Unit) {

        val intent = Intent(context, SignUpActivity::class.java)
        context.startActivity(intent)
        context.finish()

        navigationCallback.invoke()
    }

}