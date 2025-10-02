package com.example.stocks_v1.ui.screens.markets

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import com.example.presentation.markets.MarketsScreen
import com.example.presentation.markets.MarketsViewModel
import com.example.presentation.markets.MarketsViewModelFactory

@Composable
fun MarketsScreenWithViewModel(factory: MarketsViewModelFactory) {
    val marketsViewModel: MarketsViewModel = androidx.lifecycle.viewmodel.compose.viewModel(factory = factory)
    val error = marketsViewModel.error.collectAsState().value
    val context = LocalContext.current

    LaunchedEffect(error) {
        error?.let {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }
    }

    MarketsScreen(marketsViewModel)
}