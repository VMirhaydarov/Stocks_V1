package com.example.stocks_v1.ui.screens.stocks

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.data.repository.StockRepositoryImpl
import com.example.domain.usecase.GetStocksUseCase
import com.example.presentation.stocks.StocksScreen
import com.example.presentation.stocks.StocksViewModel
import com.example.presentation.stocks.StocksViewModelFactory
import com.example.stocks_v1.di.AppComponent

@Composable
fun StocksScreenWithViewModel() {
    val getStocksUseCase = AppComponent.get().getStocksUseCase()
    val factory = StocksViewModelFactory(getStocksUseCase)
    val stocksViewModel: StocksViewModel = viewModel(factory = factory)
    StocksScreen(viewModel = stocksViewModel)
}
