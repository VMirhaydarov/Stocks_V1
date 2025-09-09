package com.example.data.repository

import com.example.domain.model.Stock
import com.example.domain.model.StockPrice
import com.example.domain.repository.IStockRepository
import com.example.data.network.RetrofitProvider
import com.example.domain.model.Market
import com.example.data.network.markets.toMarketList
import com.example.data.network.markets.toDomain
import com.example.data.network.engines.toEngineList
import com.example.domain.model.Engine
import com.example.data.network.stocks.toStockList

class StockRepositoryImpl : IStockRepository {
    private val api = RetrofitProvider.apiService

    override suspend fun getEngines(): List<Engine> {
        val response = api.getEngines()
        return response.toEngineList()
    }

    override suspend fun getMarkets(): List<Market> {
        val response = api.getMarkets("stock")
        val marketDtos = response.markets.toMarketList()
        return marketDtos.map { it.toDomain() }
    }

    override suspend fun getStocks(): List<Stock> {
        val response = api.getStocks("stock", "shares")
        return response.toStockList()
    }

    override suspend fun getStockPrices(symbol: String): List<StockPrice> {
        return emptyList()
    }

}