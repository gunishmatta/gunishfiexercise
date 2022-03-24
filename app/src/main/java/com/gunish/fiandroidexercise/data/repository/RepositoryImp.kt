package com.gunish.fiandroidexercise.data.repository

import com.gunish.fiandroidexercise.data.Resource
import com.gunish.fiandroidexercise.data.dto.register.RegisterRequest
import kotlinx.coroutines.flow.Flow

class RepositoryImp:Repository {

    override fun register(): Flow<Resource<RegisterRequest>> {
        TODO("Not yet implemented")
    }
}