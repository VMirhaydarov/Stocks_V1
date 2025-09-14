package com.example.stocks_v1.ui.screens.markets

import androidx.compose.runtime.Composable
import com.example.data.repository.StockRepositoryImpl
import com.example.domain.usecase.GetMarketsUseCase
import com.example.presentation.markets.MarketsScreen
import com.example.presentation.markets.MarketsViewModel
import com.example.presentation.markets.MarketsViewModelFactory
import com.example.stocks_v1.di.AppComponent

@Composable
fun MarketsScreenWithViewModel() {
    val getMarketsUseCase = AppComponent.get().getMarketsUseCase()
    val factory = MarketsViewModelFactory(getMarketsUseCase)
    val marketsViewModel : MarketsViewModel = factory.create(MarketsViewModel::class.java)
    MarketsScreen(viewModel = marketsViewModel)
}