package com.gunish.fiandroidexercise.data.repository

import com.gunish.fiandroidexercise.data.Resource
import com.gunish.fiandroidexercise.data.dto.register.RegisterRequest
import com.gunish.fiandroidexercise.data.dto.register.RegisterResponse
import com.gunish.fiandroidexercise.data.local.LocalData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.time.LocalDate
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class RepositoryImp @Inject constructor(private val localData:LocalData,private val ioDispatcher:CoroutineContext):Repository  {

    override suspend fun register(): Flow<Resource<RegisterResponse>> {
       return flow {
           emit(localData.register())
       }.flowOn(ioDispatcher)
    }
}