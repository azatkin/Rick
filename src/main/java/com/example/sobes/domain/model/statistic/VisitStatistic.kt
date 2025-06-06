package com.example.sobes.domain.model.statistic

import java.time.LocalDate

data class VisitStatistic(
    val date: LocalDate,
    val visits: Int
)