package com.example.sobes.presentation.observers

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
fun ObserversHeader() {
    Text(
        text = stringResource(R.string.observers),
        style = MaterialTheme.typography.titleMedium.copy(
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        ),
        modifier = Modifier.padding(top = 28.dp, start = 20.dp)
    )

    Spacer(Modifier.height(16.dp))
}