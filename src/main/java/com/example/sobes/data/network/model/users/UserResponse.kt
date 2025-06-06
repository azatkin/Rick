package com.example.sobes.data.network.model.users

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("sex")
    val sex: String,
    @SerialName("username")
    val username: String,
    @SerialName("isOnline")
    val isOnline: Boolean,
    @SerialName("age")
    val age: Int,
    @SerialName("files")
    val files: List<UserFile>
)