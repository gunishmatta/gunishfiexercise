package com.gunish.fiandroidexercise.data.local

import android.content.Context
import com.gunish.fiandroidexercise.data.Resource
import com.gunish.fiandroidexercise.data.dto.register.RegisterResponse
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class LocalData {
    fun register():Resource<RegisterResponse>
    {
        return Resource.Success(RegisterResponse("Success"))
    }
}