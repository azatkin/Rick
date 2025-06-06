package com.example.sobes.data.network.model.statistics

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StatisticItemResponse(
    @SerialName("user_id")
    val userId: Int,
    @SerialName("type")
    val type: String,
    @SerialName("dates")
    val dates: List<Long>
)