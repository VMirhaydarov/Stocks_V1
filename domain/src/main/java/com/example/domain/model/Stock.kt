package com.example.domain.model

data class Stock(
    val symbol: String,
    val name: String,
    val prices: List<StockPrice>
)

data class StockPrice(
    val date: String,
    val price: Double
)
