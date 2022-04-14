package com.gunish.fiandroidexercise.di

import com.gunish.fiandroidexercise.data.local.LocalData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideLocalData():LocalData{
        return LocalData()
    }

    @Provides
    @Singleton
    fun provideCoroutineContext():CoroutineContext{
        return Dispatchers.IO
    }



}