package com.example.sobes.domain

import com.example.sobes.base.lce.LceFlow
import com.example.sobes.base.lce.lceFlow
import com.example.sobes.data.repository.users.UsersRepository
import com.example.sobes.domain.model.users.User
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val usersRepository: UsersRepository
) {
    operator fun invoke(): LceFlow<List<User>> = lceFlow {
        emit(usersRepository.getUsers())
    }
}