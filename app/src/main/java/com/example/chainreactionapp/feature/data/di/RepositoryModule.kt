package com.example.chainreactionapp.feature.data.di

import com.example.chainreactionapp.feature.data.HomeRepositoryImpl
import com.example.chainreactionapp.feature.domain.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule {

    @Binds
    fun bindMainRepository(mainRepositoryImpl: HomeRepositoryImpl): HomeRepository
}