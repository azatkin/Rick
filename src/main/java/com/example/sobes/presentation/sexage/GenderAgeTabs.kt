package com.example.sobes.presentation.sexage

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sobes.R
import com.example.sobes.base.compose.AppTheme

@Composable
fun GenderAgeTabs(mainRed: Color) {
    val tabs = listOf(
        R.string.tab_today,
        R.string.tab_week,
        R.string.tab_month,
        R.string.tab_all_time
    )
    var selected by remember { mutableIntStateOf(0) }
    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
    ) {
        tabs.forEachIndexed { i, labelResId ->
            val label = stringResource(labelResId)
            OutlinedButton(
                onClick = { selected = i },
                shape = RoundedCornerShape(18.dp),
                border = if (i == selected) {
                    null
                } else {
                    BorderStroke(
                        1.dp,
                        color = AppTheme.colors.lightGray
                    )
                },
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = if (i == selected) mainRed else AppTheme.colors.white
                ),
                modifier = Modifier
                    .height(38.dp)
                    .padding(end = 8.dp)
            ) {
                Text(
                    text = label,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = if (i == selected) AppTheme.colors.white else AppTheme.colors.black
                )
            }
        }
    }
}