package com.example.sobes.presentation.users

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.sobes.base.compose.AppTheme
import com.example.sobes.domain.model.users.User

@Composable
fun UserRow(user: User) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 18.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box {
            AsyncImage(
                model = user.avatarUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(46.dp)
                    .clip(CircleShape)
            )
            if (user.isOnline) {
                Box(
                    modifier = Modifier
                        .size(16.dp)
                        .align(Alignment.BottomEnd)
                        .offset(x = 2.dp, y = 2.dp)
                        .background(AppTheme.colors.white, CircleShape)
                        .padding(4.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(AppTheme.colors.brightGreen, CircleShape)
                    )
                }
            }
        }
        Spacer(Modifier.width(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "${user.username}, ${user.age}",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                color = AppTheme.colors.deepGray
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = user.emoji,
                fontSize = 26.sp,
                modifier = Modifier.offset(y = 2.dp)
            )
        }

        Spacer(Modifier.weight(1f))

        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = null,
            tint = AppTheme.colors.lightGray,
            modifier = Modifier.size(34.dp)
        )
    }
}
