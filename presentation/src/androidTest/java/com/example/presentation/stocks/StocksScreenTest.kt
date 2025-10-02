package com.example.presentation.stocks

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.assertIsDisplayed
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.domain.model.Engine
import com.example.domain.model.Market
import com.example.domain.model.Stock
import com.example.domain.model.Result
import com.example.domain.model.StockPrice
import com.example.domain.repository.IStockRepository
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class StocksScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun stocksList_isDisplayed() {
        val stocks = listOf(
            Stock("ABRD", "АбраюДюрсо", emptyList()),
            Stock("AFLT", "Аэрофлот", emptyList())
        )
        val fakeRepo = object : IStockRepository {
            override suspend fun getStocks() = Result.Success(stocks)
            override suspend fun getEngines() = Result.Success(emptyList<Engine>())
            override suspend fun getMarkets() = Result.Success(emptyList<Market>())
            override suspend fun getStockPrices(symbol: String) = Result.Success(emptyList<StockPrice>())
        }
        val getStocksUseCase = com.example.domain.usecase.GetStocksUseCase(fakeRepo)
        val viewModel = StocksViewModel(getStocksUseCase)
        composeTestRule.setContent {
            StocksScreen(viewModel)
        }
        composeTestRule.onNodeWithText("ABRD").assertIsDisplayed()
        composeTestRule.onNodeWithText("AFLT").assertIsDisplayed()
    }
}
