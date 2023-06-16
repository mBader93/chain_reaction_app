package com.example.chainreactionapp.feature.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chainreactionapp.feature.domain.model.HomeModel
import com.example.chainreactionapp.feature.domain.usecase.GetHomeDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHomeDataUseCase: GetHomeDataUseCase
) : ViewModel() {

    private val _loadingStateFLow = MutableStateFlow<Boolean>(true)
    val loadingStateFLow: StateFlow<Boolean> = _loadingStateFLow

    private val _homeStateFlow = MutableStateFlow<HomeModel?>(null)
    val homeStateFlow: StateFlow<HomeModel?> = _homeStateFlow

    private val _onErrorStateFlow = MutableStateFlow<String?>(null)
    val onErrorStateFlow: StateFlow<String?> = _onErrorStateFlow

    init {
        getHomeData()
    }

    private fun getHomeData() {
        viewModelScope.launch(Dispatchers.IO) {
            _loadingStateFLow.value = true
            try {
                _homeStateFlow.value = getHomeDataUseCase()
            } catch (e: Exception) {
                e.message?.let { _onErrorStateFlow.value = it }
            }
            _loadingStateFLow.value = false
        }
    }


}