package com.example.presentation.stocks

import com.example.domain.usecase.GetStocksUseCase
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock

class StocksViewModelFactoryTest {
    private lateinit var getStocksUseCase: GetStocksUseCase
    private lateinit var factory: StocksViewModelFactory

    @Before
    fun setUp() {
        getStocksUseCase = mock()
        factory = StocksViewModelFactory(getStocksUseCase)
    }

    @Test
    fun `create returns StocksViewModel when class matches`() {
        val viewModel = factory.create(StocksViewModel::class.java)
        assertTrue(viewModel is StocksViewModel)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `create throws exception for unknown ViewModel class`() {
        @Suppress("UNCHECKED_CAST")
        factory.create(String::class.java as Class<androidx.lifecycle.ViewModel>)
    }
}
