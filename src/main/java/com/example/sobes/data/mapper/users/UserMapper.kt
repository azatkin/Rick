package com.example.sobes.data.mapper.users

import com.example.sobes.data.network.model.users.UserResponse
import com.example.sobes.domain.model.users.User

interface UserMapper {
    fun map(dto: UserResponse): User
    fun mapList(list: List<UserResponse>): List<User>
}
