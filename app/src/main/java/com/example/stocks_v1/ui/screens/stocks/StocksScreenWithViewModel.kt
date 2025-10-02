package com.example.stocks_v1.ui.screens.stocks

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.presentation.stocks.StocksScreen
import com.example.presentation.stocks.StocksViewModel
import com.example.presentation.stocks.StocksViewModelFactory

@Composable
fun StocksScreenWithViewModel(factory: StocksViewModelFactory) {
    val stocksViewModel: StocksViewModel = viewModel(factory = factory)

    val error = stocksViewModel.error.collectAsState().value
    val context = LocalContext.current

    LaunchedEffect(error) {
        error?.let {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }
    }

    StocksScreen(stocksViewModel)
}
