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

class StockRepositoryImpl : IStockRepository {
    private val api = RetrofitProvider.apiService

    override suspend fun getEngines(): List<Engine> {
        val response = api.getEngines()
        return response.toEngineList()
    }

    override suspend fun getMarkets(): List<Market> {
        val response = api.getMarkets("stock") // MarketsResponseDto
        val marketDtos = response.markets.toMarketList() // List<MarketDto>
        return marketDtos.map { it.toDomain() } // List<Market>
    }

    override suspend fun getStocks(): List<Stock> {
        //        val stockDtos = api.getStocks()
//        return stockDtos.map { dto ->
//            Stock(
//                symbol = dto.symbol,
//                name = dto.name,
//                prices = emptyList() // Можно загрузить цены отдельно
//            )
//        }
        return emptyList()
    }

    override suspend fun getStockPrices(symbol: String): List<StockPrice> {
//        val priceDtos = api.getStockPrices(symbol)
//        return priceDtos.map { dto ->
//            StockPrice(
//                date = dto.date,
//                price = dto.price
//            )
//        }
        return emptyList()
    }

}