package com.example.chainreactionapp.feature.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.chainreactionapp.feature.data.model.HomeResponseModel

@Dao
interface LocalDataSource {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHomeData(homeData:HomeResponseModel)

    @Query("select * FROM home")
    fun getHomeData(): HomeResponseModel?
}