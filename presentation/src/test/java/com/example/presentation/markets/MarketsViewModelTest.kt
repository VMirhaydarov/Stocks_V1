package com.example.presentation.markets

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.domain.model.Market
import com.example.domain.model.Result
import com.example.domain.usecase.GetMarketsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.setMain
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.advanceUntilIdle
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MarketsViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var getMarketsUseCase: GetMarketsUseCase
    private lateinit var viewModel: MarketsViewModel
    private val testDispatcher = StandardTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        getMarketsUseCase = mock()
        viewModel = MarketsViewModel(getMarketsUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `loadMarkets success updates markets and clears error`() = testScope.runTest {
        val markets = listOf(Market(1, "NYSE", "New York Stock Exchange"))
        whenever(getMarketsUseCase.invoke()).thenReturn(Result.Success(markets))
        viewModel.loadMarkets()
        advanceUntilIdle()
        assertEquals(markets, viewModel.markets.value)
        assertNull(viewModel.error.value)
        assertFalse(viewModel.isLoading.value)
    }

    @Test
    fun `loadMarkets error sets error message`() = testScope.runTest {
        whenever(getMarketsUseCase.invoke()).thenReturn(Result.Error("Network error"))
        viewModel.loadMarkets()
        advanceUntilIdle()
        assertEquals("ОШИБКА СЕТИ: Network error", viewModel.error.value)
        assertTrue(viewModel.markets.value.isEmpty())
        assertFalse(viewModel.isLoading.value)
    }
}
