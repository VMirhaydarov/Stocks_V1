package com.example.stocks_v1.ui.screens.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShowChart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.presentation.onboarding.OnBoardingViewModel

@Composable
fun OnBoardingScreen(onFinish: () -> Unit) {
    val viewModel: OnBoardingViewModel = viewModel()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFFFF9800), Color(0xFF90CAF9))
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier.padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Rounded.ShowChart,
                    contentDescription = "Stocks Icon",
                    tint = Color(0xFFFF9800),
                    modifier = Modifier.size(64.dp)
                )
                Spacer(modifier = Modifier.height(18.dp))
                Text(
                    text = "Добро пожаловать в Stocks App!",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color(0xFFFF9800)
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "С помощью приложения Вы сможете отслеживать курсы акций",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color(0xFF424242),
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = {
                        viewModel.finishOnBoarding()
                        onFinish()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9800))
                ) {
                    Text("Начать", color = Color.White, fontSize = 18.sp)
                }
            }
        }
    }
}
