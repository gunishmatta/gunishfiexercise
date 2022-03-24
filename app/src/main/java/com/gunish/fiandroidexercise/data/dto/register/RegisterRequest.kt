package com.gunish.fiandroidexercise.data.dto.register

import com.squareup.moshi.Json

data class RegisterRequest(@field:Json(name = "pan") val pan:String,@field:Json(name = "birthdate") val birthDate: String)
