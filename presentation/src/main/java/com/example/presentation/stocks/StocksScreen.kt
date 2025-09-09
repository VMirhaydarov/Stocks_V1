package com.example.presentation.stocks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun StocksScreen(viewModel: StocksViewModel) {
    androidx.compose.runtime.LaunchedEffect(Unit) {
        viewModel.loadStocks()
    }
    val stocks = viewModel.stocks.collectAsState()
    val isLoading = viewModel.isLoading.collectAsState(initial = false).value
    if (isLoading) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
                .navigationBarsPadding()
        ) {
            Text(
                text = "Список акций",
                style = MaterialTheme.typography.headlineMedium,
                color = Color(0xFFFF9800),
                modifier = Modifier.padding(bottom = 24.dp)
            )
            LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                items(stocks.value) { stock ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFE0B2))
                    ) {
                        Column(modifier = Modifier.padding(20.dp)) {
                            Text(text = "symbol: ${stock.symbol}", style = MaterialTheme.typography.bodyLarge)
                            Text(text = "name: ${stock.name}", style = MaterialTheme.typography.bodyLarge)
                        }
                    }
                }
            }
        }
    }
}