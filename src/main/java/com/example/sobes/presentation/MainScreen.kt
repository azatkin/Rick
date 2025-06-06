package com.example.sobes.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sobes.base.compose.AppTheme
import com.example.sobes.di.LocalAppComponent
import com.example.sobes.presentation.observers.ObserversDoubleCard
import com.example.sobes.presentation.observers.ObserversHeader
import com.example.sobes.presentation.sexage.GenderAndAgeBlock
import com.example.sobes.presentation.statistics.StatisticsCard
import com.example.sobes.presentation.statistics.StatisticsHeader
import com.example.sobes.presentation.statistics.StatisticsTabs
import com.example.sobes.presentation.statistics.VisitsChartStyled
import com.example.sobes.presentation.users.MostVisitedUsers

@Composable
fun Screen() {
    val component = LocalAppComponent.current
    val mainScreenViewModel: MainScreenViewModel = viewModel(
        factory = component.vmFactory()
    )
    val state = mainScreenViewModel.state.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 4.dp)
            .background(AppTheme.colors.ultraLightGray),
        contentPadding = PaddingValues(bottom = 28.dp)
    ) {
        item { StatisticsHeader() }

        item { StatisticsCard(state.value) }

        item { StatisticsTabs(state.value.selectedRange, mainScreenViewModel::onSelectRange) }

        item {
            Card(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth()
                    .height(270.dp),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Box(modifier = Modifier.fillMaxWidth()) {
                    VisitsChartStyled(visits = state.value.groupedVisits)
                }
            }
        }

        item {
            Spacer(Modifier.height(26.dp))
            MostVisitedUsers(state.value.userList)
        }

        item {
            Spacer(Modifier.height(34.dp))
            GenderAndAgeBlock()
        }

        item {
            ObserversHeader()
            ObserversDoubleCard(
                totalSubs = state.value.totalSubs,
                totalUnsubs = state.value.totalUnsubs
            )
        }
    }
}

