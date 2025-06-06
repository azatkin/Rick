package com.example.sobes.presentation.util

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import com.example.sobes.base.compose.AppTheme

@Composable
fun SimpleLineChart(
    modifier: Modifier = Modifier,
    lineColor: Color = AppTheme.colors.green,
    shadowColor: Color = AppTheme.colors.green.copy(alpha = 0.1f),
    isDownward: Boolean = false
) {
    Canvas(
        modifier = modifier
    ) {
        val upPoints = listOf(
            Offset(size.width * 0.05f, size.height * 0.8f),
            Offset(size.width * 0.25f, size.height * 0.6f),
            Offset(size.width * 0.45f, size.height * 0.7f),
            Offset(size.width * 0.7f, size.height * 0.4f),
            Offset(size.width * 0.93f, size.height * 0.6f),
            Offset(size.width * 0.98f, size.height * 0.18f)
        )
        val downPoints = listOf(
            Offset(size.width * 0.05f, size.height * 0.25f),
            Offset(size.width * 0.25f, size.height * 0.45f),
            Offset(size.width * 0.45f, size.height * 0.38f),
            Offset(size.width * 0.7f, size.height * 0.7f),
            Offset(size.width * 0.93f, size.height * 0.5f),
            Offset(size.width * 0.98f, size.height * 0.85f)
        )
        val points = if (isDownward) downPoints else upPoints

        fun cubicBezierSmoothPath(points: List<Offset>): Path {
            val path = Path()
            if (points.isEmpty()) return path
            path.moveTo(points.first().x, points.first().y)
            for (i in 1 until points.size) {
                val prev = points[i - 1]
                val cur = points[i]
                val control1 = Offset((prev.x + cur.x) / 2, prev.y)
                val control2 = Offset((prev.x + cur.x) / 2, cur.y)
                path.cubicTo(
                    control1.x, control1.y,
                    control2.x, control2.y,
                    cur.x, cur.y
                )
            }
            return path
        }

        val shadowPath = cubicBezierSmoothPath(points)
        drawPath(
            path = shadowPath,
            color = shadowColor,
            style = Stroke(width = 18f, cap = StrokeCap.Round)
        )

        drawPath(
            path = shadowPath,
            color = lineColor,
            style = Stroke(width = 12f, cap = StrokeCap.Round)
        )

        val last = points.last()
        drawCircle(
            color = lineColor,
            radius = 22f,
            center = last
        )
        drawCircle(
            color = Color.White,
            radius = 13f,
            center = last
        )
    }
}

