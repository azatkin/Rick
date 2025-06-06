package com.example.sobes.domain

import com.example.sobes.base.lce.LceFlow
import com.example.sobes.base.lce.lceFlow
import com.example.sobes.data.mapper.statistics.StatisticsMapper
import com.example.sobes.data.repository.statistics.StatisticsRepository
import com.example.sobes.domain.model.statistic.Statistic
import javax.inject.Inject

class GetStatisticsUseCase @Inject constructor(
    private val statisticsRepository: StatisticsRepository,
    private val statisticsMapper: StatisticsMapper,
) {
    operator fun invoke(): LceFlow<List<Statistic>> = lceFlow {
        emit(statisticsMapper.map(statisticsRepository.getStatistics()))
    }
}