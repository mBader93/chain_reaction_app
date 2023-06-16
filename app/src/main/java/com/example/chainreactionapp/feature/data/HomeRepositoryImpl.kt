package com.example.chainreactionapp.feature.data

import com.example.chainreactionapp.feature.data.datasource.local.LocalDataSource
import com.example.chainreactionapp.feature.data.datasource.remote.RemoteDataSource
import com.example.chainreactionapp.feature.data.mapper.HomeModelMapper
import com.example.chainreactionapp.feature.data.model.HomeResponseModel
import com.example.chainreactionapp.feature.domain.HomeRepository
import com.example.chainreactionapp.feature.domain.model.HomeModel
import javax.inject.Inject

internal class HomeRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val homeMapperHelper: HomeModelMapper
) : HomeRepository {

    override suspend fun getHomeData(): HomeModel {
        val remoteData = remoteDataSource.getHomeData()
        localDataSource.insertHomeData(remoteData)
        val localDataSource: HomeResponseModel? = localDataSource.getHomeData()
        localDataSource?.let {
            return homeMapperHelper.map(localDataSource)
        }
        return homeMapperHelper.map(remoteData)
    }
}