package com.example.chainreactionapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.chainreactionapp.database.converters.HomeDataConverter
import com.example.chainreactionapp.database.converters.ItemConverter
import com.example.chainreactionapp.feature.data.datasource.local.LocalDataSource
import com.example.chainreactionapp.feature.data.model.HomeResponseModel
import com.example.chainreactionapp.feature.data.model.ItemResponseModel


@TypeConverters(
    HomeDataConverter::class,
    ItemConverter::class
)
@Database(
    entities = [HomeResponseModel::class],
    version = 1,
    exportSchema = false
)
abstract class DataBase : RoomDatabase() {
    abstract fun homeDao(): LocalDataSource
}