package com.example.data.network.markets

import com.example.domain.model.Market

data class MarketDto(
    val id: Int,
    val name: String,
    val title: String
)

fun MarketsDto.toMarketList(): List<MarketDto> {
    val idIdx = columns.indexOf("id")
    val nameIdx = columns.indexOf("NAME")
    val titleIdx = columns.indexOf("title")
    return data.mapNotNull { row ->
        try {
            MarketDto(
                id = (row[idIdx] as Number).toInt(),
                name = row[nameIdx] as String,
                title = row[titleIdx] as String
            )
        } catch (_: Exception) {
            null
        }
    }
}

fun MarketDto.toDomain(): Market = Market(
    id = id,
    name = name,
    title = title
)
