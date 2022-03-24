package com.gunish.fiandroidexercise.di

import com.gunish.fiandroidexercise.data.remote.api.RemoteService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ApiModule {

    @Singleton
    @Provides
    fun provideRetrofitService():RemoteService  = Retrofit.Builder()
        .baseUrl(RemoteService.API_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(RemoteService::class.java)
}