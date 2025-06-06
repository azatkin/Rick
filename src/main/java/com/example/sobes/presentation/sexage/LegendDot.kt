package com.example.sobes.presentation.sexage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LegendDot(color: Color) {
    Box(
        Modifier
            .size(16.dp)
            .clip(CircleShape)
            .background(color)
    )
    Spacer(Modifier.width(8.dp))
}