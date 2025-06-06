package com.example.sobes.data.repository.statistics

import com.example.sobes.data.network.api.statistics.StatisticsApi
import com.example.sobes.data.network.model.statistics.StatisticsResponse
import javax.inject.Inject

class StatisticsRepositoryImpl @Inject constructor(
    private val api: StatisticsApi
) : StatisticsRepository {

    override suspend fun getStatistics(): StatisticsResponse {
        return api.fetchStatistics()
    }
}
