package com.example.data.network.stocks

import com.example.domain.model.Stock

fun StocksResponseDto.toStockList(): List<Stock> {
    val symbolIndex = history.columns.indexOf("SECID")
    val nameIndex = history.columns.indexOf("SHORTNAME")
    return history.data.mapNotNull { row ->
        try {
            Stock(
                symbol = row.getOrNull(symbolIndex)?.toString() ?: "",
                name = row.getOrNull(nameIndex)?.toString() ?: "",
                prices = emptyList() // TODO
            )
        } catch (e: Exception) {
            null
        }
    }
}
