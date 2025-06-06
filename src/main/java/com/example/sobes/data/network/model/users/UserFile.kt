package com.example.sobes.data.network.model.users

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserFile(
    @SerialName("id")
    val id: Int,
    @SerialName("url")
    val url: String,
    @SerialName("type")
    val type: String
)
