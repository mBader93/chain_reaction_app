package com.example.chainreactionapp.feature.domain.usecase

import com.example.chainreactionapp.feature.domain.HomeRepository
import com.example.chainreactionapp.feature.domain.model.HomeModel
import javax.inject.Inject

class UpdateLocalUseCase @Inject constructor(
    private val repository: HomeRepository
) {

    suspend operator fun invoke() {
        return repository.updateLocalData()
    }
}