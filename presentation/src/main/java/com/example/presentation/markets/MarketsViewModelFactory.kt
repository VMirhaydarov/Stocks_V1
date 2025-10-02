package com.example.presentation.markets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.GetMarketsUseCase
import javax.inject.Inject

class MarketsViewModelFactory @Inject constructor(
    private val getMarketsUseCase: GetMarketsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MarketsViewModel::class.java)) {
            return MarketsViewModel(getMarketsUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}