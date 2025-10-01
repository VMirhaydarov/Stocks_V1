package com.example.presentation.stocks

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.domain.model.Result
import com.example.domain.model.Stock
import com.example.domain.model.StockPrice
import com.example.domain.usecase.GetStocksUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlinx.coroutines.test.resetMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class StocksViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var getStocksUseCase: GetStocksUseCase
    private lateinit var viewModel: StocksViewModel
    private val testDispatcher = StandardTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        getStocksUseCase = mock()
        viewModel = StocksViewModel(getStocksUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `loadStocks success updates stocks and clears error`() = testScope.runTest {
        val prices = listOf(StockPrice("2023-01-01", 100.0))
        val stocks = listOf(Stock("AAPL", "Apple", prices))
        whenever(getStocksUseCase.invoke()).thenReturn(Result.Success(stocks))
        viewModel.loadStocks()
        advanceUntilIdle()
        assertEquals(stocks, viewModel.stocks.value)
        assertNull(viewModel.error.value)
        assertFalse(viewModel.isLoading.value)
    }

    @Test
    fun `loadStocks error sets error message`() = testScope.runTest {
        whenever(getStocksUseCase.invoke()).thenReturn(Result.Error("Network error"))
        viewModel.loadStocks()
        advanceUntilIdle()
        assertEquals("ОШИБКА СЕТИ: Network error", viewModel.error.value)
        assertTrue(viewModel.stocks.value.isEmpty())
        assertFalse(viewModel.isLoading.value)
    }
}
