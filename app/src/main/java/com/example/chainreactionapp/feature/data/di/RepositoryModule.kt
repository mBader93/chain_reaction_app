package com.example.chainreactionapp.feature.data.di

import com.example.chainreactionapp.feature.data.MainRepositoryImpl
import com.example.chainreactionapp.feature.domain.MainRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindMainRepository(mainRepositoryImpl: MainRepositoryImpl): MainRepository
}