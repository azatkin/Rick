package com.example.sobes.data.mapper.statistics

import com.example.sobes.data.network.model.statistics.StatisticsResponse
import com.example.sobes.domain.model.statistic.Statistic

interface StatisticsMapper {
    fun map(model: StatisticsResponse): List<Statistic>
}
