package com.example.data.network.engines

import com.example.domain.model.Engine

fun EnginesResponseDto.toEngineList(): List<Engine> {
    val idIndex = engines.columns.indexOf("id")
    val nameIndex = engines.columns.indexOf("name")
    val titleIndex = engines.columns.indexOf("title")
    return engines.data.mapNotNull { row ->
        try {
            Engine(
                id = (row[idIndex] as? Double)?.toInt() ?: (row[idIndex] as? Int) ?: 0,
                name = row[nameIndex]?.toString() ?: "",
                title = row[titleIndex]?.toString() ?: ""
            )
        } catch (e: Exception) {
            null
        }
    }
}

