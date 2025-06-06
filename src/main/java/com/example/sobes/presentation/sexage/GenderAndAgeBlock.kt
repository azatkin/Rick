package com.example.sobes.presentation.sexage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sobes.R
import com.example.sobes.base.compose.AppTheme

private const val MALE_PERCENT = 40
private const val FEMALE_PERCENT = 60

@Composable
fun GenderAndAgeBlock() {

    val ageGroups = listOf(
        "18-21" to (10 to 20),
        "22-25" to (20 to 30),
        "26-30" to (5 to 0),
        "31-35" to (0 to 0),
        "36-40" to (5 to 0),
        "40-50" to (0 to 10),
        ">50" to (0 to 0),
    )

    Column(
        Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(horizontal = 14.dp)
    ) {
        Text(
            text = stringResource(R.string.sex_age),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 4.dp, bottom = 10.dp)
        )
        GenderAgeTabs(AppTheme.colors.red)
        Spacer(Modifier.height(12.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(28.dp),
            colors = CardDefaults.cardColors(containerColor = AppTheme.colors.white),
            elevation = CardDefaults.cardElevation(0.dp)
        ) {
            Column(
                Modifier
                    .padding(vertical = 22.dp)
            ) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 6.dp, bottom = 12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    DonutChartDoubleGap(MALE_PERCENT, FEMALE_PERCENT)
                }
                Spacer(Modifier.height(14.dp))
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    LegendDot(AppTheme.colors.red)
                    Text(
                        text = stringResource(R.string.men, MALE_PERCENT),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = AppTheme.colors.deepGray,
                        modifier = Modifier.padding(end = 24.dp)
                    )
                    Spacer(Modifier.width(50.dp))
                    LegendDot(AppTheme.colors.lightRed)
                    Text(
                        text = stringResource(R.string.girl, FEMALE_PERCENT),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = AppTheme.colors.deepGray
                    )
                }
                Spacer(Modifier.height(22.dp))
                HorizontalDivider(Modifier.fillMaxWidth(), color = AppTheme.colors.lightGray)
                Spacer(Modifier.height(10.dp))
                Column(Modifier.padding(horizontal = 12.dp)) {
                    ageGroups.forEach { (group, percents) ->
                        AgeGroupBarColumnStyle(
                            label = group,
                            male = percents.first,
                            female = percents.second
                        )
                    }
                }
            }
        }
    }
}

