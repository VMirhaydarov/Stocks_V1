package com.example.data.network.engines

data class EnginesResponseDto(
    val engines: EnginesDataDto
)

data class EnginesDataDto(
    val columns: List<String>,
    val data: List<List<Any>>
)

