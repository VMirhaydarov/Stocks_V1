package com.example.data.network.markets

data class MarketsResponseDto(
    val markets: MarketsDto
)

data class MarketsDto(
    val metadata: Map<String, Any>,
    val columns: List<String>,
    val data: List<List<Any>>
)