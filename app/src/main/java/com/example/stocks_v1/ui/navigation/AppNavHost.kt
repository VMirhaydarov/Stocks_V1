package com.example.stocks_v1.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.stocks_v1.ui.screens.engines.EnginesScreenWithViewModel
import com.example.stocks_v1.ui.screens.main.MainScreen
import com.example.stocks_v1.ui.screens.markets.MarketsScreenWithViewModel
import com.example.stocks_v1.ui.screens.onboarding.OnBoardingScreen
import com.example.stocks_v1.ui.screens.stocks.StocksScreenWithViewModel
import com.example.presentation.engines.EnginesViewModelFactory
import com.example.presentation.markets.MarketsViewModelFactory

@Composable
fun AppNavHost(
    stocksViewModelFactory: com.example.presentation.stocks.StocksViewModelFactory,
    enginesViewModelFactory: EnginesViewModelFactory,
    marketsViewModelFactory: MarketsViewModelFactory
) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "onboarding") {
        composable("onboarding") {
            OnBoardingScreen(onFinish = {
                navController.navigate("main") {
                    popUpTo("onboarding") { inclusive = true }
                }
            })
        }
        composable("main") { MainScreen(navController) }
        composable("engines") { EnginesScreenWithViewModel(enginesViewModelFactory) }
        composable("markets") { MarketsScreenWithViewModel(marketsViewModelFactory) }
        composable("stocks") { StocksScreenWithViewModel(stocksViewModelFactory) }
    }
}