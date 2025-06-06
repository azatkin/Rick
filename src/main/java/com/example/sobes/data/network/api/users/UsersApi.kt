package com.example.sobes.data.network.api.users

import com.example.sobes.data.network.model.users.UsersResponse

interface UsersApi {
    suspend fun fetchUsers(): UsersResponse
}