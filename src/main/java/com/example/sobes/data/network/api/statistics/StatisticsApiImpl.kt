package com.example.sobes.data.network.api.statistics

import com.example.sobes.data.network.model.statistics.StatisticsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

private const val BASE_URL = "statistics/"

class StatisticsApiImpl @Inject constructor(
    private val client: HttpClient
) : StatisticsApi {
    override suspend fun fetchStatistics(): StatisticsResponse {
        return client.get(BASE_URL).body()
    }
}