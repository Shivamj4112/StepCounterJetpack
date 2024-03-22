package com.example.stepcounterjetpack.models

import android.health.connect.datatypes.HeightRecord

data class UserModel(

    var gender : String = "",
    var sedentary : String = "",
    var age : Int = 18,
    var height : Int = 0,
    var cmHeight : Int = 185,
    var ftHeight : Int = 5,
    var heightType : String = "",
    var weight : Int = 76,
    var kgweight : Int = 76,
    var lbsweight : Int = 176,
    var weightType : String = "",
    var step : Int = 6000,
)
