package com.example.data.network

import com.example.data.network.engines.EnginesResponseDto
import com.example.data.network.markets.MarketsResponseDto
import com.example.data.network.stocks.StocksResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface StockApiService {

    @GET("/iss/engines.json")
    suspend fun getEngines(): EnginesResponseDto

    @GET("/iss/engines/{engine}/markets.json")
    suspend fun getMarkets(@Path("engine") engine: String): MarketsResponseDto

    @GET("/iss/history/engines/{engine}/markets/{market}/securities.json")
    suspend fun getStocks(@Path("engine") engine: String,
                          @Path("market") market: String) : StocksResponseDto

}
