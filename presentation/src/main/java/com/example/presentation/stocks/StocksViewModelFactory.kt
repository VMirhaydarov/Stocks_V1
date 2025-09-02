package com.example.presentation.stocks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.GetStocksUseCase

class StocksViewModelFactory(
    private val getStocksUseCase: GetStocksUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StocksViewModel::class.java)) {
            return StocksViewModel(getStocksUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}