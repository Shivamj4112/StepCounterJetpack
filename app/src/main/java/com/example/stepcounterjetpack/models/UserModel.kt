package com.example.stepcounterjetpack.models

data class UserModel(

    var gender : String = "",
    var sedentary : String = "",
    var age : Int = 18,
    var height : Int = 185,
    var heightType : String = "cm",
    var weight : Int = 76,
    var weightType : String = "kg",
    var step : Int = 6000,
)
