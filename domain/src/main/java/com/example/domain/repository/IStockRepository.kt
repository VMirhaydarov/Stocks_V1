package com.example.domain.repository

import com.example.domain.model.Engine
import com.example.domain.model.Market
import com.example.domain.model.Stock
import com.example.domain.model.StockPrice

interface IStockRepository {
    suspend fun getEngines(): List<Engine>
    suspend fun getMarkets(): List<Market>
    suspend fun getStocks(): List<Stock>
    suspend fun getStockPrices(symbol: String): List<StockPrice>
}