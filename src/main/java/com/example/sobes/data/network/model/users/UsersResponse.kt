package com.example.sobes.data.network.model.users

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UsersResponse(
    @SerialName("users")
    val userResponses: List<UserResponse>
)