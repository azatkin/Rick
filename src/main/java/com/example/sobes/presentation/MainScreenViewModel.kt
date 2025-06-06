package com.example.sobes.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sobes.base.lce.Lce
import com.example.sobes.domain.GetStatisticsUseCase
import com.example.sobes.domain.GetUsersUseCase
import com.example.sobes.domain.model.statistic.StatsRange
import com.example.sobes.domain.util.countSubscribed
import com.example.sobes.domain.util.countTotalVisits
import com.example.sobes.domain.util.countUnsubscribed
import com.example.sobes.domain.util.countViewPerDay
import com.example.sobes.domain.util.groupByMonth
import com.example.sobes.domain.util.groupByWeek
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase,
    private val getStatisticsUseCase: GetStatisticsUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(MainScreenUiState())
    val state: StateFlow<MainScreenUiState> = _state

    init {
        loadData()
    }

    private fun loadData() {
        combine(
            getUsersUseCase(),
            getStatisticsUseCase()
        ) { users, stats ->
            when {
                users is Lce.Loading || stats is Lce.Loading -> Lce.Loading
                users is Lce.Error -> Lce.Error(users.error)
                stats is Lce.Error -> Lce.Error(stats.error)
                users.isContent && stats.isContent -> {
                    val stats = stats.contentOrNull() ?: emptyList()
                    _state.value = _state.value.copy(
                        allVisits = countViewPerDay(stats),
                        totalVisitors = countTotalVisits(stats),
                        totalUnsubs = countUnsubscribed(stats),
                        totalSubs = countSubscribed(stats),
                        userList = users.contentOrNull() ?: emptyList(),
                    )
                }

                else -> Lce.Loading
            }
            onSelectRange(_state.value.selectedRange)
        }
            .launchIn(viewModelScope)
    }

    fun onSelectRange(range: StatsRange) {
        val groupedVisits = when (range) {
            StatsRange.DAY -> _state.value.allVisits
            StatsRange.WEEK -> groupByWeek(_state.value.allVisits)
            StatsRange.MONTH -> groupByMonth(_state.value.allVisits)
        }
        _state.value = _state.value.copy(
            groupedVisits = groupedVisits,
            selectedRange = range
        )
    }
}
