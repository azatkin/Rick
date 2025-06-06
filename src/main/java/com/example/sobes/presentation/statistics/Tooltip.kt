package com.example.sobes.presentation.statistics

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sobes.R
import com.example.sobes.base.compose.AppTheme
import com.example.sobes.domain.model.statistic.VisitStatistic
import java.time.format.DateTimeFormatter
import java.util.Locale

private val fullDateFormatter = DateTimeFormatter.ofPattern("d MMMM", Locale("ru"))

@Composable
fun Tooltip(
    points: List<Offset>,
    selectedIndex: Int,
    density: Density,
    widthPx: Float,
    visits: List<VisitStatistic>
) {
    val tooltipPt = points[selectedIndex]
    val tooltipWidth = 200.dp
    val tooltipHeight = 110.dp

    val tooltipHalfWidthPx = with(density) { (tooltipWidth / 2).toPx() }
    val edgePaddingPx = with(density) { 4.dp.toPx() }
    val minX = tooltipHalfWidthPx + edgePaddingPx
    val maxX = widthPx - tooltipHalfWidthPx - edgePaddingPx
    val tooltipDrawX = tooltipPt.x.coerceIn(minX, maxX)

    Box(
        Modifier
            .offset(
                x = with(density) { tooltipDrawX.toDp() - tooltipWidth / 2 },
                y = with(density) { tooltipPt.y.toDp() - tooltipHeight - 10.dp }
            )
            .width(tooltipWidth)
            .height(tooltipHeight)
    ) {
        Card(
            shape = RoundedCornerShape(18.dp),
            border = BorderStroke(1.dp, AppTheme.colors.tooltipBorder),
            colors = CardDefaults.cardColors(containerColor = AppTheme.colors.white),
            elevation = CardDefaults.cardElevation(0.dp)
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 18.dp, top = 18.dp, bottom = 18.dp, end = 18.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = pluralStringResource(
                        R.plurals.visitors_count,
                        visits[selectedIndex].visits,
                        visits[selectedIndex].visits
                    ),
                    color = AppTheme.colors.red,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                    maxLines = 1
                )
                Spacer(Modifier.height(14.dp))
                Text(
                    text = visits[selectedIndex].date.format(fullDateFormatter),
                    color = AppTheme.colors.grayText,
                    fontSize = 16.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}
