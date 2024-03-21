package com.example.stepcounterjetpack.viewModels

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.stepcounterjetpack.view.activities.UserDetailsActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class UserDetailsViewModel : ViewModel() {

    private var auth : FirebaseAuth = FirebaseAuth.getInstance()
    fun addDataToDatabase(
        context: Activity,
        gender: String,
        sedentary: String,
        age: String,
        height: String,
        weight: String,
        steps: Int,
    ){
        val userRef = FirebaseDatabase.getInstance().getReference("Users")
        val user = auth.currentUser

        val userId = user?.uid

        val userData = hashMapOf(
            "age" to age,
            "gender" to gender,
            "height" to height,
            "steps" to steps,
            "sedentary" to sedentary,
            "weight" to weight,
        )

        userRef.child(userId!!).child("profile").setValue(userData).addOnCompleteListener { task ->

            if (task.isSuccessful){

                Toast.makeText(context, "Successful to add user data.", Toast.LENGTH_SHORT).show()
                navigateToLogin(context)
            }
            else{
                Toast.makeText(context, task.exception?.message ?: "Failed to add user data.", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun navigateToLogin(context : Activity) {

        val intent = Intent(context, UserDetailsActivity::class.java)
        context.startActivity(intent)
        context.finish()
    }
}