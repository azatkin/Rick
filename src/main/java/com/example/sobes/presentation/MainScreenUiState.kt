package com.example.sobes.presentation

import com.example.sobes.domain.model.statistic.StatsRange
import com.example.sobes.domain.model.statistic.VisitStatistic
import com.example.sobes.domain.model.users.User

data class MainScreenUiState(
    val selectedRange: StatsRange = StatsRange.DAY,
    val totalVisitors: Int = 0,
    val totalUnsubs: Int = 0,
    val totalSubs: Int = 0,
    val allVisits: List<VisitStatistic> = emptyList(),
    val groupedVisits: List<VisitStatistic> = emptyList(),
    val userList: List<User> = emptyList()
)