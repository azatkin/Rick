package com.example.sobes.data.repository.users

import com.example.sobes.data.mapper.users.UserMapper
import com.example.sobes.data.network.api.users.UsersApi
import com.example.sobes.domain.model.users.User
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val api: UsersApi,
    private val userMapper: UserMapper,
) : UsersRepository {
    override suspend fun getUsers(): List<User> {
        val dto = api.fetchUsers()
        return userMapper.mapList(dto.userResponses)
    }
}