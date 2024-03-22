package com.example.stepcounterjetpack.viewModels

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.stepcounterjetpack.models.UserModel
import com.example.stepcounterjetpack.view.activities.LoginActivity
import com.example.stepcounterjetpack.view.activities.UserDetailsActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


var model = UserModel()

class UserDetailsViewModel : ViewModel() {

    private var auth : FirebaseAuth = FirebaseAuth.getInstance()
    fun updateDataInDatabase(
        context: Activity,
        gender: String,
        sedentary: String,
        age: Int,
        height: Int,
        weight: Int,
        steps: Int,
    ){
        val userRef = FirebaseDatabase.getInstance().getReference("Users")
        val user = auth.currentUser
        val userId = user?.uid


        val userData = hashMapOf<String, Any>(
            "age" to age,
            "gender" to gender,
            "height" to height.toString() + model.heightType,
            "steps" to steps,
            "sedentary" to sedentary,
            "weight" to weight.toString() + model.weightType,
        )

        userRef.child(userId!!).child("profile").updateChildren(userData).addOnCompleteListener { task ->

            if (task.isSuccessful){

                navigateToLogin(context)
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