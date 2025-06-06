package com.example.sobes.presentation.statistics

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sobes.R
import com.example.sobes.base.compose.AppColor.Light.grayDashed
import com.example.sobes.base.compose.AppColor.Light.red
import com.example.sobes.base.compose.AppColor.Light.white
import com.example.sobes.base.compose.AppTheme
import com.example.sobes.domain.model.statistic.VisitStatistic
import java.time.format.DateTimeFormatter
import kotlin.math.abs

private val dateFormatter = DateTimeFormatter.ofPattern("dd.MM")

@Composable
fun VisitsChartStyled(
    visits: List<VisitStatistic>,
    modifier: Modifier = Modifier
) {
    if (visits.isEmpty()) {
        Box(
            modifier = modifier
                .fillMaxSize()
        ) {
            Text(
                text = stringResource(R.string.empty_data),
                modifier = Modifier.align(Alignment.Center),
                style = MaterialTheme.typography.bodyMedium.copy(AppTheme.colors.gray)
            )
            return
        }
    }
    var selectedIndex by remember(visits) { mutableIntStateOf(visits.lastIndex) }

    BoxWithConstraints(
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(28.dp))
            .background(AppTheme.colors.white)
    ) {
        val density = LocalDensity.current
        val widthPx = with(density) { maxWidth.toPx() }
        val heightPx = with(density) { maxHeight.toPx() }

        val paddingStartPx = with(density) { 24.dp.toPx() }
        val paddingEndPx = with(density) { 24.dp.toPx() }
        val chartWidthPx = widthPx - paddingStartPx - paddingEndPx

        val bottomOffsetPx = with(density) { 30.dp.toPx() }
        val topOffsetPx = with(density) { 34.dp.toPx() }
        val chartHeightPx = heightPx - bottomOffsetPx - topOffsetPx

        val gridLineCount = 3
        val gridLinesY = List(gridLineCount) { i ->
            topOffsetPx + i * (chartHeightPx / (gridLineCount - 1))
        }

        val maxYValue = maxOf(40, visits.maxOf { it.visits })
        val spacing = chartWidthPx / (visits.size - 1).coerceAtLeast(1)
        val points = visits.mapIndexed { idx, visit ->
            val x = paddingStartPx + idx * spacing
            val y =
                topOffsetPx + chartHeightPx - (visit.visits.toFloat() / maxYValue) * chartHeightPx
            Offset(x, y)
        }

        Box(
            Modifier
                .matchParentSize()
                .pointerInput(visits, points) {
                    detectTapGestures { tapOffset ->
                        val tapped = points.minByOrNull { abs(it.x - tapOffset.x) }
                        val tappedIndex = tapped?.let { points.indexOf(it) }
                        if (tappedIndex != null) selectedIndex = tappedIndex
                    }
                }
        )

        Canvas(Modifier.matchParentSize()) {
            val dashed = PathEffect.dashPathEffect(floatArrayOf(16f, 16f), 0f)
            gridLinesY.forEach { y ->
                drawLine(
                    color = grayDashed,
                    start = Offset(paddingStartPx, y),
                    end = Offset(widthPx - paddingEndPx, y),
                    strokeWidth = 2f,
                    pathEffect = dashed
                )
            }
            val selPt = points[selectedIndex]
            drawLine(
                color = red.copy(alpha = 0.7f),
                start = Offset(selPt.x, gridLinesY.last()),
                end = Offset(selPt.x, gridLinesY.first()),
                strokeWidth = 5f,
                pathEffect = dashed
            )
            for (i in 1 until points.size) {
                drawLine(
                    color = red,
                    start = points[i - 1],
                    end = points[i],
                    strokeWidth = 10f,
                    cap = StrokeCap.Round
                )
            }
            points.forEachIndexed { idx, pt ->
                drawCircle(
                    color = red,
                    center = pt,
                    radius = if (idx == selectedIndex) 23f else 18f,
                    style = Stroke(width = if (idx == selectedIndex) 8f else 6f)
                )
                drawCircle(
                    color = white,
                    center = pt,
                    radius = if (idx == selectedIndex) 15f else 11f
                )
            }
        }

        visits.forEachIndexed { idx, visit ->
            val pt = points[idx]
            Box(
                Modifier
                    .offset(
                        x = with(density) { pt.x.toDp() - 18.dp },
                        y = with(density) { heightPx.toDp() - 20.dp }
                    )
                    .width(36.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = visit.date.format(dateFormatter),
                    color = AppTheme.colors.grayText,
                    fontSize = 10.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Medium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

        Tooltip(points, selectedIndex, density, widthPx, visits)
    }
}