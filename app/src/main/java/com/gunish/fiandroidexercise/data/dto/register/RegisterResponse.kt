package com.gunish.fiandroidexercise.data.dto.register

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

data class RegisterResponse(
    @field:Json(name = "message")  val message:String?
)
