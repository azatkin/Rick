package com.example.sobes.data.network.model.statistics

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StatisticsResponse(
    @SerialName("statistics")
    val statistics: List<StatisticItemResponse>
)