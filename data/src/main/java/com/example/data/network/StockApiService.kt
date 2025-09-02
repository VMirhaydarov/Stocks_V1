package com.example.data.network

import com.example.data.network.markets.MarketsResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface StockApiService {
    @GET("/iss/engines/{engine}/markets.json")
    suspend fun getMarkets(@Path("engine") engine: String): MarketsResponseDto

}
