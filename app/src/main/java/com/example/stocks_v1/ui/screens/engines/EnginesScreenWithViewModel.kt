package com.example.stocks_v1.ui.screens.engines

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.presentation.engines.EnginesScreen
import com.example.presentation.engines.EnginesViewModel
import com.example.presentation.engines.EnginesViewModelFactory

@Composable
fun EnginesScreenWithViewModel(factory: EnginesViewModelFactory) {
    val enginesViewModel: EnginesViewModel = viewModel(factory = factory)
    val error = enginesViewModel.error.collectAsState().value
    val context = LocalContext.current

    LaunchedEffect(error) {
        error?.let {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }
    }

    EnginesScreen(enginesViewModel)
}