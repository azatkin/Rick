package com.example.sobes.data.repository.statistics

import com.example.sobes.data.network.model.statistics.StatisticsResponse

interface StatisticsRepository {
    suspend fun getStatistics(): StatisticsResponse
}