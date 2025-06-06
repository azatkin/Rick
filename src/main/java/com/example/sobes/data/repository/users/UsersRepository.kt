package com.example.sobes.data.repository.users

import com.example.sobes.domain.model.users.User

interface UsersRepository {
    suspend fun getUsers(): List<User>
}