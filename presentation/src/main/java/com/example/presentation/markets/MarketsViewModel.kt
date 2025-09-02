package com.example.presentation.markets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetMarketsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MarketsViewModel (private val getMarketsUseCase: GetMarketsUseCase) : ViewModel(){
    private val _markets = MutableStateFlow<List<String>>(emptyList())
    val markets: StateFlow<List<String>> = _markets

    fun loadMarkets() {
        viewModelScope.launch {
            _markets.value = getMarketsUseCase().map { it.title }
        }
    }
}