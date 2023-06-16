package com.example.chainreactionapp.feature.domain.usecase

import com.example.chainreactionapp.feature.data.di.RepositoryModule
import com.example.chainreactionapp.feature.domain.HomeRepository
import com.example.chainreactionapp.feature.domain.model.HomeModel
import javax.inject.Inject

class GetHomeDataUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    suspend operator fun invoke(): HomeModel = homeRepository.getHomeData()
}