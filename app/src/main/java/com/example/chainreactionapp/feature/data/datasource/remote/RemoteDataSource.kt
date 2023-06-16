package com.example.chainreactionapp.feature.data.datasource.remote

import com.example.chainreactionapp.feature.data.model.HomeResponseModel
import retrofit2.http.GET

interface RemoteDataSource {

    @GET("default/dynamodb-writer")
    suspend fun getHomeData(): HomeResponseModel
}