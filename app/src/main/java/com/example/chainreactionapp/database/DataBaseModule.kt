package com.example.chainreactionapp.database

import android.app.Application
import androidx.room.Room
import com.example.chainreactionapp.feature.data.datasource.local.LocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Singleton
    @Provides
    fun provideDataBase(application: Application) =
        Room.databaseBuilder(application, DataBase::class.java, "app_database")
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideCustomersDao(dataBase: DataBase): LocalDataSource =
        dataBase.homeDao()

}