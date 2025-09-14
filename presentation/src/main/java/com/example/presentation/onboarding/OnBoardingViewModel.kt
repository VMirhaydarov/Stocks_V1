package com.example.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class OnBoardingViewModel : ViewModel() {
    private val _isFinished = MutableStateFlow(false)
    val isFinished: StateFlow<Boolean> = _isFinished

    fun finishOnBoarding() {
        viewModelScope.launch {
            _isFinished.value = true
            // Здесь можно добавить сохранение состояния (например, в DataStore)
        }
    }
}

