package com.example.stepcounterjetpack.view.util

import android.content.Context
import android.widget.Toast

fun Context.toast(msg : String){
    Toast.makeText(this, "$msg selection is missing.", Toast.LENGTH_SHORT).show()
}
