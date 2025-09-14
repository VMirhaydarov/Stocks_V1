package com.example.stocks_v1.ui.screens.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.presentation.onboarding.OnBoardingViewModel

@Composable
fun OnBoardingScreen(onFinish: () -> Unit) {
    val viewModel: OnBoardingViewModel = viewModel()
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Добро пожаловать в Stocks App!", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = {
                viewModel.finishOnBoarding()
                onFinish()
            }) {
                Text("Начать")
            }
        }
    }
}
