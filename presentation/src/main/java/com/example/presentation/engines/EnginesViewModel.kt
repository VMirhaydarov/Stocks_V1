package com.example.presentation.engines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Engine
import com.example.domain.usecase.GetEnginesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EnginesViewModel(
    private val getEnginesUseCase: GetEnginesUseCase
) : ViewModel() {
    private val _engines = MutableStateFlow<List<Engine>>(emptyList())
    val engines : StateFlow<List<Engine>> = _engines

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun loadEngines() {
        viewModelScope.launch {
            _isLoading.value = true
            _engines.value = getEnginesUseCase()
            _isLoading.value = false
        }
    }
}