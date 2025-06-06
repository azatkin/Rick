package com.example.sobes.domain.model.users

data class User(
    val id: Int,
    val sex: String,
    val username: String,
    val isOnline: Boolean,
    val age: Int,
    val avatarUrl: String
) {
    val emoji = when (sex) {
        "W" -> "\uD83C\uDF52" // Вишенка
        "M" -> "\uD83D\uDE08" // Дьявол
        else -> ""
    }
}