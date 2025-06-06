package com.example.sobes.data.mapper.statistics

import com.example.sobes.data.network.model.statistics.StatisticsResponse
import com.example.sobes.domain.model.statistic.Statistic
import javax.inject.Inject

class DefaultStatisticsMapper @Inject constructor() : StatisticsMapper {

    override fun map(model: StatisticsResponse): List<Statistic> {
        return model.statistics.map {
            Statistic(userId = it.userId, type = it.type, dates = it.dates)
        }
    }
}