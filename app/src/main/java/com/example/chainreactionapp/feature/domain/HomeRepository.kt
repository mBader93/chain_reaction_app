package com.example.chainreactionapp.feature.domain

import com.example.chainreactionapp.feature.domain.model.HomeModel

interface HomeRepository {

    suspend fun getHomeData(): HomeModel
    suspend fun updateLocalData()
}