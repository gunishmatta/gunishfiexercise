package com.gunish.fiandroidexercise.data.remote.api

import com.gunish.fiandroidexercise.data.dto.register.RegisterResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface RemoteService {
@POST("/register")
suspend fun register():Response<RegisterResponse>


companion object{
const val API_URL=""
}

}