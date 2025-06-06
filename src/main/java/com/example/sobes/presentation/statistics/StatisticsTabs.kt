package com.example.sobes.presentation.statistics

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sobes.R
import com.example.sobes.base.compose.AppTheme
import com.example.sobes.domain.model.statistic.StatsRange

@Composable
fun StatisticsTabs(
    selectedRange: StatsRange,
    onSelect: (StatsRange) -> Unit
) {
    val tabOptions = listOf(
        R.string.tab_by_days,
        R.string.tab_by_weeks,
        R.string.tab_by_months
    )
    val tabEnums = listOf(
        StatsRange.DAY,
        StatsRange.WEEK,
        StatsRange.MONTH
    )

    Row(
        Modifier
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),

        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        tabOptions.forEachIndexed { index, labelResId ->
            val isSelected = selectedRange == tabEnums[index]
            val label = stringResource(labelResId)
            if (isSelected) {
                Button(
                    onClick = { onSelect(tabEnums[index]) },
                    colors = ButtonDefaults.buttonColors(containerColor = AppTheme.colors.red),
                    shape = RoundedCornerShape(18.dp),
                    modifier = Modifier
                        .height(44.dp)
                ) {
                    Text(
                        text = label,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            } else {
                OutlinedButton(
                    onClick = { onSelect(tabEnums[index]) },
                    shape = RoundedCornerShape(18.dp),
                    border = BorderStroke(2.dp, AppTheme.colors.lightGray),
                    modifier = Modifier
                        .height(44.dp)
                ) {
                    Text(
                        text = label,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}