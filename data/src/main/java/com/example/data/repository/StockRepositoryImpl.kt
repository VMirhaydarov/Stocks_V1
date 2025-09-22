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
import java.io.IOException
import retrofit2.HttpException
import com.example.domain.model.Result

class StockRepositoryImpl : IStockRepository {
    private val api = RetrofitProvider.apiService

    override suspend fun getEngines(): Result<List<Engine>> {
        return try {
            val response = api.getEngines()
            Result.Success(response.toEngineList())
        } catch (e: IOException) {
            Result.Error(message = e.message)
        } catch (e: HttpException) {
            Result.Error(message = e.message(), code = e.code())
        }
    }

    override suspend fun getMarkets(): Result<List<Market>> {
        return try {
            val response = api.getMarkets("stock")
            val marketDtos = response.markets.toMarketList()
            Result.Success(marketDtos.map { it.toDomain() })
        } catch (e: IOException) {
            Result.Error(message = e.message)
        } catch (e: HttpException) {
            Result.Error(message = e.message(), code = e.code())
        }
    }

    override suspend fun getStocks(): Result<List<Stock>> {
        return try {
            val response = api.getStocks("stock", "shares")
            Result.Success(response.toStockList())
        } catch (e: IOException) {
            Result.Error(message = e.message)
        } catch (e: HttpException) {
            Result.Error(message = e.message(), code = e.code())
        }
    }

    override suspend fun getStockPrices(symbol: String): Result<List<StockPrice>> {
        return Result.Success(emptyList())
    }

}