package com.example.presentation.markets

import com.example.domain.usecase.GetMarketsUseCase
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock

class MarketsViewModelFactoryTest {
    private lateinit var getMarketsUseCase: GetMarketsUseCase
    private lateinit var factory: MarketsViewModelFactory

    @Before
    fun setUp() {
        getMarketsUseCase = mock()
        factory = MarketsViewModelFactory(getMarketsUseCase)
    }

    @Test
    fun `create returns MarketsViewModel when class matches`() {
        val viewModel = factory.create(MarketsViewModel::class.java)
        assertTrue(viewModel is MarketsViewModel)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `create throws exception for unknown ViewModel class`() {
        @Suppress("UNCHECKED_CAST")
        factory.create(String::class.java as Class<androidx.lifecycle.ViewModel>)
    }
}
