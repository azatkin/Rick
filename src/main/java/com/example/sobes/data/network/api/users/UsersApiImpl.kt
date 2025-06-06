package com.example.sobes.data.network.api.users

import com.example.sobes.data.network.model.users.UsersResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

private const val BASE_URL = "users/"

class UsersApiImpl @Inject constructor(
    private val client: HttpClient
) : UsersApi {

    override suspend fun fetchUsers(): UsersResponse {
        return client.get(BASE_URL).body()
    }
}