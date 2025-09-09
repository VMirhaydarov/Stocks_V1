package com.example.data.network.stocks

data class StocksResponseDto(
    val history: HistoryDto
)

data class HistoryDto(
    val columns: List<String>,
    val data: List<List<Any?>>
)
