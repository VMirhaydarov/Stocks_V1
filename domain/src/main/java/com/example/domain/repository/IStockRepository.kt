package com.example.domain.repository

import com.example.domain.model.Engine
import com.example.domain.model.Market
import com.example.domain.model.Result
import com.example.domain.model.Stock
import com.example.domain.model.StockPrice

interface IStockRepository {
    suspend fun getEngines(): Result<List<Engine>>
    suspend fun getMarkets(): Result<List<Market>>
    suspend fun getStocks(): Result<List<Stock>>
    suspend fun getStockPrices(symbol: String): Result<List<StockPrice>>
}