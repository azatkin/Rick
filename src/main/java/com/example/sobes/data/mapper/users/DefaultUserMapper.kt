package com.example.sobes.data.mapper.users

import com.example.sobes.data.network.model.users.UserFile
import com.example.sobes.data.network.model.users.UserResponse
import com.example.sobes.domain.model.users.User
import javax.inject.Inject

private const val AVATAR_TYPE = "avatar"
private const val DEFAULT_AVATAR_URL = ""

class DefaultUserMapper @Inject constructor() : UserMapper {
    override fun map(model: UserResponse): User = User(
        id = model.id,
        sex = model.sex,
        username = model.username,
        isOnline = model.isOnline,
        age = model.age,
        avatarUrl = avatarUrl(model.files)
    )

    override fun mapList(list: List<UserResponse>): List<User> = list.map(::map)

    private fun avatarUrl(files: List<UserFile>): String =
        files.firstOrNull { it.type == AVATAR_TYPE }?.url ?: DEFAULT_AVATAR_URL
}