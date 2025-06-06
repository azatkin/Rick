package com.example.sobes.data.network.api.statistics

import com.example.sobes.data.network.model.statistics.StatisticsResponse

interface StatisticsApi {
    suspend fun fetchStatistics(): StatisticsResponse
}