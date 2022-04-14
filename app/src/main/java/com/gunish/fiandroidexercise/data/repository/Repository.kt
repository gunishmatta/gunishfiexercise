package com.gunish.fiandroidexercise.data.repository

import com.gunish.fiandroidexercise.data.Resource
import com.gunish.fiandroidexercise.data.dto.register.RegisterRequest
import com.gunish.fiandroidexercise.data.dto.register.RegisterResponse
import kotlinx.coroutines.flow.Flow

interface Repository {
  suspend fun register():Flow<Resource<RegisterResponse>>
}