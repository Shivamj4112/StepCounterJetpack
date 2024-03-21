package com.example.stepcounterjetpack.viewModels

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.stepcounterjetpack.view.activities.LoginActivity
import com.example.stepcounterjetpack.view.activities.UserDetailsActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase

class SignupViewModel : ViewModel(){

    private var auth :FirebaseAuth = FirebaseAuth.getInstance()
    private val userRef = FirebaseDatabase.getInstance().getReference("Users")


    fun createAccount(context : Activity ,name: String, email: String, password: String) {

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->

                if (task.isSuccessful){

                    val user = auth.currentUser

                    addDataToDatabase(context,user,name, email, password)

                } else{
                    Toast.makeText(context, task.exception?.message ?: "Authentication failed.", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun addDataToDatabase(
        context: Activity,
        user: FirebaseUser?,
        name: String,
        email: String,
        password: String
    ){
        val userId = user?.uid

        val userData = hashMapOf(
            "name" to name,
            "email" to email,
            "password" to password,
        )

        userRef.child(userId!!).child("profile").setValue(userData).addOnCompleteListener { task ->

            if (task.isSuccessful){
                Toast.makeText(context, "Successful to add user data.", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(context, task.exception?.message ?: "Failed to add user data.", Toast.LENGTH_SHORT).show()
            }
        }
    }

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