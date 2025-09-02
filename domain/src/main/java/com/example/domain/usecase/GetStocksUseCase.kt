package com.example.domain.usecase

import com.example.domain.repository.IStockRepository

class GetStocksUseCase(private val stockRepository: IStockRepository) {
    suspend operator fun invoke() = stockRepository.getStocks()
}