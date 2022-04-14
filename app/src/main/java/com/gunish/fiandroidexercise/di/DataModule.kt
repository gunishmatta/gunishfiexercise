package com.gunish.fiandroidexercise.di

import com.gunish.fiandroidexercise.data.repository.Repository
import com.gunish.fiandroidexercise.data.repository.RepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun provideRepository(repositoryImp: RepositoryImp):Repository
}