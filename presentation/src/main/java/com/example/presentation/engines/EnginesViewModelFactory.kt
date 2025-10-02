package com.example.presentation.engines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.GetEnginesUseCase
import javax.inject.Inject

class EnginesViewModelFactory @Inject constructor(
    private val getEnginesUseCase: GetEnginesUseCase
)  : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EnginesViewModel::class.java)) {
            return EnginesViewModel(getEnginesUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}