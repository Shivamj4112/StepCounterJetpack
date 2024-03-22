package com.example.stepcounterjetpack.models

data class UserModel(

    var gender : String = "",
    var sedentary : String = "",
    var age : Int = 18,
    var height : Int = 0,
    var heightType : String = "",
    var weight : Int = 76,
    var weightType : String = "",
    var step : Int = 6000,
)
