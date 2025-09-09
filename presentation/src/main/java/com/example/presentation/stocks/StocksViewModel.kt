package com.example.presentation.stocks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Stock
import com.example.domain.usecase.GetStocksUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class StocksViewModel (private val getStocksUseCase: GetStocksUseCase) : ViewModel() {
    private val _stocks = MutableStateFlow<List<Stock>>(emptyList())
    val stocks: StateFlow<List<Stock>> = _stocks

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun loadStocks() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _stocks.value = getStocksUseCase()
            } finally {
                _isLoading.value = false
            }
        }
    }
}