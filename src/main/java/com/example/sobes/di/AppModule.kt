package com.example.sobes.di

import com.example.sobes.data.mapper.statistics.DefaultStatisticsMapper
import com.example.sobes.data.mapper.statistics.StatisticsMapper
import com.example.sobes.data.mapper.users.DefaultUserMapper
import com.example.sobes.data.mapper.users.UserMapper
import com.example.sobes.data.network.api.statistics.StatisticsApi
import com.example.sobes.data.network.api.statistics.StatisticsApiImpl
import com.example.sobes.data.network.api.users.UsersApi
import com.example.sobes.data.network.api.users.UsersApiImpl
import com.example.sobes.data.repository.statistics.StatisticsRepository
import com.example.sobes.data.repository.statistics.StatisticsRepositoryImpl
import com.example.sobes.data.repository.users.UsersRepository
import com.example.sobes.data.repository.users.UsersRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
interface AppModule {

    @Binds
    abstract fun bindUsersApi(impl: UsersApiImpl): UsersApi

    @Binds
    abstract fun bindUsersRepository(impl: UsersRepositoryImpl): UsersRepository

    @Binds
    abstract fun bindStatisticsApi(impl: StatisticsApiImpl): StatisticsApi

    @Binds
    abstract fun bindStatisticsRepository(impl: StatisticsRepositoryImpl): StatisticsRepository

    @Binds
    abstract fun bindUserMapper(impl: DefaultUserMapper): UserMapper

    @Binds
    abstract fun bindStatisticsMapper(impl: DefaultStatisticsMapper): StatisticsMapper

    companion object {
        @Provides
        @Singleton
        fun provideHttpClient(): HttpClient = HttpClient() {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }
            defaultRequest {
                url("http://test.rikmasters.ru/api/")
            }
        }
    }
}