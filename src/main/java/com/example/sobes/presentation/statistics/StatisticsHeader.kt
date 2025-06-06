package com.example.sobes.presentation.statistics

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sobes.R

@Composable
fun StatisticsHeader() {
    Text(
        text = stringResource(R.string.statistics),
        style = MaterialTheme.typography.headlineLarge.copy(
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp
        ),
        modifier = Modifier.padding(top = 32.dp, start = 24.dp)
    )
    Text(
        text = stringResource(R.string.visitors),
        style = MaterialTheme.typography.titleMedium.copy(
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp
        ),
        modifier = Modifier.padding(top = 24.dp, start = 24.dp)
    )
}
