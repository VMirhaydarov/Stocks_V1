package com.example.stocks_v1.ui.screens.markets

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
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

    val error = marketsViewModel.error.collectAsState().value
    val context = LocalContext.current

    LaunchedEffect(error) {
        error?.let {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }
    }

    MarketsScreen(viewModel = marketsViewModel)
}