package com.gunish.fiandroidexercise.data.repository

import com.gunish.fiandroidexercise.data.Resource
import com.gunish.fiandroidexercise.data.dto.register.RegisterRequest
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun register():Flow<Resource<RegisterRequest>>
}