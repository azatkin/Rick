package com.example.sobes.presentation.users

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sobes.R
import com.example.sobes.base.compose.AppTheme
import com.example.sobes.domain.model.users.User

@Composable
fun MostVisitedUsers(users: List<User>) {

    val paleLavender: Color = AppTheme.colors.paleLavender

    Column(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.most_frequent_visitors),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(start = 12.dp, bottom = 18.dp, top = 6.dp)
        )

        Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(2.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                users.forEachIndexed { idx, user ->
                    UserRow(user)
                    if (idx < users.size - 1) {
                        Divider(
                            color = paleLavender,
                            thickness = 1.dp,
                            modifier = Modifier.padding(start = 78.dp, end = 6.dp)
                        )
                    }
                }
            }
        }
    }
}
