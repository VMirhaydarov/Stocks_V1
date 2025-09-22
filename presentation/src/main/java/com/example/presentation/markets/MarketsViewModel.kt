package com.example.presentation.markets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Market
import com.example.domain.model.Result
import com.example.domain.usecase.GetMarketsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MarketsViewModel (private val getMarketsUseCase: GetMarketsUseCase) : ViewModel(){
    private val _markets = MutableStateFlow<List<Market>>(emptyList())
    val markets: StateFlow<List<Market>> = _markets

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun loadMarkets() {
        viewModelScope.launch {
            _isLoading.value = true
            when (val result = getMarketsUseCase()) {
                is Result.Success -> {
                    _markets.value = result.data
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