package com.example.presentation.stocks

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.assertIsDisplayed
import com.example.domain.model.Stock
import com.example.domain.model.StockPrice
import com.example.domain.model.Result
import com.example.domain.repository.IStockRepository
import org.junit.Rule
import org.junit.Test

class StocksScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun stocksList_isDisplayed() {
        val prices1 = listOf(StockPrice("2023-01-01", 100.0))
        val prices2 = listOf(StockPrice("2023-01-01", 200.0))
        val stocks = listOf(
            Stock("AAPL", "Apple", prices1),
            Stock("GOOG", "Google", prices2)
        )
        val fakeRepo = object : IStockRepository {
            override suspend fun getStocks(): Result<List<Stock>> = Result.Success(stocks)
            override suspend fun getEngines() = Result.Success(emptyList<com.example.domain.model.Engine>())
            override suspend fun getMarkets() = Result.Success(emptyList<com.example.domain.model.Market>())
            override suspend fun getStockPrices(symbol: String) = Result.Success(emptyList<com.example.domain.model.StockPrice>())
        }
        val getStocksUseCase = com.example.domain.usecase.GetStocksUseCase(fakeRepo)
        val viewModel = StocksViewModel(getStocksUseCase)
        composeTestRule.setContent {
            StocksScreen(viewModel)
        }
        composeTestRule.onNodeWithText("Apple").assertIsDisplayed()
        composeTestRule.onNodeWithText("Google").assertIsDisplayed()
    }
}
