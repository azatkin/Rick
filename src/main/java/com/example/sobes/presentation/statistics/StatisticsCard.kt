package com.example.sobes.presentation.statistics

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sobes.R
import com.example.sobes.base.compose.AppTheme
import com.example.sobes.presentation.MainScreenUiState
import com.example.sobes.presentation.util.SimpleLineChart

@Composable
fun StatisticsCard(
    state: MainScreenUiState
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 18.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(containerColor = AppTheme.colors.white),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(28.dp)
        ) {
            SimpleLineChart(
                modifier = Modifier
                    .padding(end = 12.dp)
                    .size(90.dp, 70.dp),
            )
            Spacer(Modifier.width(16.dp))
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "${state.totalVisitors}",
                        style = MaterialTheme.typography.headlineLarge.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 32.sp
                        )
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowUpward,
                        contentDescription = null,
                        tint = AppTheme.colors.green,
                        modifier = Modifier
                            .size(40.dp)
                            .padding(start = 6.dp)
                    )
                }
                Spacer(Modifier.height(4.dp))
                Text(
                    text = stringResource(R.string.visitors_count_grew_this_month),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = AppTheme.colors.grayText,
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp
                    ),
                    modifier = Modifier.padding(top = 2.dp)
                )
            }
        }
    }
}