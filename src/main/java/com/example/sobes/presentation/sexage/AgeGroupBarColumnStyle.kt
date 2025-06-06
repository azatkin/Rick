package com.example.sobes.presentation.sexage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sobes.base.compose.AppTheme

@Composable
fun AgeGroupBarColumnStyle(
    label: String,
    male: Int,
    female: Int
) {
    val barHeight = 8.dp

    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp),
        verticalAlignment = Alignment.Top
    ) {
        Text(
            label,
            modifier = Modifier
                .width(86.dp)
                .padding(
                    top = 16.dp,
                    start = 20.dp,
                    bottom = 25.dp
                ),
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp
        )

        Spacer(Modifier.width(40.dp))
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(top = 14.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.heightIn(min = barHeight + 8.dp)
            ) {
                if (male > 0) {
                    Box(
                        Modifier
                            .height(barHeight)
                            .width(400.dp * (male / 100f))
                            .clip(RoundedCornerShape(6.dp))
                            .background(AppTheme.colors.red)
                    )
                } else {
                    Box(
                        Modifier
                            .size(10.dp)
                            .background(AppTheme.colors.red, CircleShape)
                    )
                }
                Spacer(Modifier.width(16.dp))
                Text(
                    "$male%",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    modifier = Modifier.width(40.dp)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.heightIn(min = barHeight + 8.dp)
            ) {
                if (female > 0) {
                    Box(
                        Modifier
                            .height(barHeight)
                            .width(400.dp * (female / 100f))
                            .clip(RoundedCornerShape(6.dp))
                            .background(AppTheme.colors.lightRed)
                    )
                } else {
                    Box(
                        Modifier
                            .size(10.dp)
                            .background(AppTheme.colors.lightRed, CircleShape)
                    )
                }
                Spacer(Modifier.width(16.dp))
                Text(
                    "$female%",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    modifier = Modifier.width(40.dp)
                )
            }
        }
    }
}

