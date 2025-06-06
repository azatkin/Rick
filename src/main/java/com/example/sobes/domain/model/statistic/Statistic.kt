package com.example.sobes.domain.model.statistic

data class Statistic(
    val userId: Int,
    val type: String,
    val dates: List<Long>
)