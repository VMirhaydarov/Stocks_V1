package com.example.stocks_v1

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.data.repository.StockRepositoryImpl
import com.example.domain.usecase.GetEnginesUseCase
import com.example.presentation.engines.EnginesScreen
import com.example.presentation.engines.EnginesViewModel
import com.example.presentation.engines.EnginesViewModelFactory

@Composable
fun EnginesScreenWithViewModel() {
    val repository = StockRepositoryImpl()
    val getEnginesUseCase = GetEnginesUseCase(repository)
    val factory = EnginesViewModelFactory(getEnginesUseCase)
    val enginesViewModel: EnginesViewModel = viewModel(factory = factory)
    EnginesScreen(viewModel = enginesViewModel)
}