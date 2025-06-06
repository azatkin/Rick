package com.example.sobes.presentation.observers

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import com.example.sobes.presentation.util.SimpleLineChart


@Composable
fun ObserversDoubleCard(
    totalSubs: Int,
    totalUnsubs: Int,
    modifier: Modifier = Modifier
) {

    Box(modifier = modifier) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = AppTheme.colors.white),
            elevation = CardDefaults.cardElevation(2.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SimpleLineChart(
                        modifier = Modifier
                            .padding(end = 12.dp)
                            .size(90.dp, 70.dp),
                    )
                    Spacer(Modifier.width(12.dp))
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = totalSubs.toString(),
                                style = MaterialTheme.typography.headlineLarge.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 28.sp,
                                    color = Color.Black
                                )
                            )
                            Icon(
                                imageVector = Icons.Default.ArrowUpward,
                                contentDescription = null,
                                tint = AppTheme.colors.green,
                                modifier = Modifier
                                    .size(28.dp)
                                    .padding(start = 4.dp)
                            )
                        }
                        Text(
                            text = stringResource(R.string.new_observers_this_month),
                            style = MaterialTheme.typography.bodyLarge.copy(
                                color = AppTheme.colors.grayText,
                                fontWeight = FontWeight.Normal,
                                fontSize = 15.sp
                            ),
                            modifier = Modifier.padding(top = 2.dp)
                        )
                    }
                }

                HorizontalDivider(
                    color = AppTheme.colors.lightGray,
                    thickness = 1.dp,
                    modifier = Modifier.padding(horizontal = 18.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SimpleLineChart(
                        modifier = Modifier
                            .padding(end = 12.dp)
                            .size(90.dp, 70.dp),
                        lineColor = Color.Red,
                        isDownward = true
                    )
                    Spacer(Modifier.width(12.dp))
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "$totalUnsubs",
                                style = MaterialTheme.typography.headlineLarge.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 28.sp,
                                    color = Color.Black
                                )
                            )
                            Icon(
                                imageVector = Icons.Default.ArrowDownward,
                                contentDescription = null,
                                tint = AppTheme.colors.red,
                                modifier = Modifier
                                    .size(28.dp)
                                    .padding(start = 4.dp)
                            )
                        }
                        Text(
                            text = stringResource(R.string.users_stopped_following_you),
                            style = MaterialTheme.typography.bodyLarge.copy(
                                color = AppTheme.colors.grayText,
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp
                            ),
                            modifier = Modifier.padding(top = 2.dp)
                        )
                    }
                }
            }
        }
    }
}

