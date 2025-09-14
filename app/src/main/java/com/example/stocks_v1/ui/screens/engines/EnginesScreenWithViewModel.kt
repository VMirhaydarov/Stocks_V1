package com.example.stocks_v1.ui.screens.engines

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.stocks_v1.di.AppComponent
import com.example.presentation.engines.EnginesScreen
import com.example.presentation.engines.EnginesViewModel
import com.example.presentation.engines.EnginesViewModelFactory

@Composable
fun EnginesScreenWithViewModel() {
    val getEnginesUseCase = AppComponent.get().getEnginesUseCase()
    val factory = EnginesViewModelFactory(getEnginesUseCase)
    val enginesViewModel: EnginesViewModel = viewModel(factory = factory)
    EnginesScreen(viewModel = enginesViewModel)
}