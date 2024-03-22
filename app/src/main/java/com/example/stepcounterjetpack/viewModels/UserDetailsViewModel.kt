package com.example.stepcounterjetpack.viewModels

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.stepcounterjetpack.models.UserModel
import com.example.stepcounterjetpack.view.activities.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class UserDetailsViewModel : ViewModel() {

    var model = UserModel()
    private var auth : FirebaseAuth = FirebaseAuth.getInstance()
    private lateinit var sharedPref : SharedPreferences
    private lateinit var editor : SharedPreferences.Editor
    fun updateDataInDatabase(
        context: Activity,
        gender: String,
        sedentary: String,
        age: Int,
        height: String,
        weight: String,
        steps: Int,
    ){
        context.apply {
            sharedPref = getSharedPreferences("UserDetail", Context.MODE_PRIVATE)
            editor = sharedPref.edit()
        }

        val userRef = FirebaseDatabase.getInstance().getReference("Users")
        val user = auth.currentUser
        val userId = user?.uid


        val userData = hashMapOf<String, Any>(
            "age" to age,
            "gender" to gender,
            "height" to height,
            "steps" to steps,
            "sedentary" to sedentary,
            "weight" to weight.toString() + model.weightType,
        )

        userRef.child(userId!!).child("profile").updateChildren(userData).addOnCompleteListener { task ->

            if (task.isSuccessful){

                navigateToLogin(context)
                editor.putBoolean("isDetailFilled",true)
                editor.apply()
            }
            else{
                Toast.makeText(context, task.exception?.message ?: "Failed to add user data.", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun navigateToLogin(context : Activity) {


        val intent = Intent(context, LoginActivity::class.java)
        context.startActivity(intent)
        context.finishAffinity()
    }
}