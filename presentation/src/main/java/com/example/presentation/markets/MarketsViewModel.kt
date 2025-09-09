package com.example.presentation.markets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Market
import com.example.domain.usecase.GetMarketsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MarketsViewModel (private val getMarketsUseCase: GetMarketsUseCase) : ViewModel(){
    private val _markets = MutableStateFlow<List<Market>>(emptyList())
    val markets: StateFlow<List<Market>> = _markets

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun loadMarkets() {
        viewModelScope.launch {
            _isLoading.value = true
            _markets.value = getMarketsUseCase()
            _isLoading.value = false
        }
    }
}