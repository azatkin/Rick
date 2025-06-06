package com.example.sobes.presentation.sexage

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.example.sobes.base.compose.AppTheme


@Composable
fun DonutChartDoubleGap(male: Int, female: Int) {
    val mainRed: Color = AppTheme.colors.red
    val lightRed: Color = AppTheme.colors.lightRed
    val strokeWidth = 9.dp

    val totalAngle = 350f
    val splitAngle = 5f
    val maleSweep = (male / 100f) * (totalAngle - 2 * splitAngle)
    val femaleSweep = (female / 100f) * (totalAngle - 2 * splitAngle)
    val maleStartAngle = -244f + splitAngle
    val femaleStartAngle = maleStartAngle + maleSweep + 2 * splitAngle

    Canvas(Modifier.size(160.dp)) {
        drawArc(
            color = mainRed,
            startAngle = maleStartAngle,
            sweepAngle = maleSweep,
            useCenter = false,
            style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
        )
        drawArc(
            color = lightRed,
            startAngle = femaleStartAngle,
            sweepAngle = femaleSweep,
            useCenter = false,
            style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
        )
    }
}

