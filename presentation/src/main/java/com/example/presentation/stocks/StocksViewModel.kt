package com.example.presentation.stocks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Stock
import com.example.domain.usecase.GetStocksUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.domain.model.Result

class StocksViewModel(private val getStocksUseCase: GetStocksUseCase) : ViewModel() {
    private val _stocks = MutableStateFlow<List<Stock>>(emptyList())
    val stocks: StateFlow<List<Stock>> = _stocks

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun loadStocks() {
        viewModelScope.launch {
            _isLoading.value = true
            when (val result = getStocksUseCase()) {
                is Result.Success -> {
                    _stocks.value = result.data
                    _error.value = null
                }
                is Result.Error -> {
                    _error.value = ("ОШИБКА СЕТИ: " + result.message)
                }
            }
            _isLoading.value = false
        }
    }
}