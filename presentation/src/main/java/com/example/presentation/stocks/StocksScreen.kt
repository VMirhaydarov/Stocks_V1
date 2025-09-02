package com.example.presentation.stocks

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

@Composable
fun StocksScreen(viewModel: StocksViewModel) {
    val stocks = viewModel.stocks.collectAsState()
    // Здесь можно использовать библиотеку для графиков, например, MPAndroidChart
    Column {
        stocks.value.forEach { stock ->
            Text(text = "${stock.name} (${stock.symbol})")
            // График цен
        }
    }
}