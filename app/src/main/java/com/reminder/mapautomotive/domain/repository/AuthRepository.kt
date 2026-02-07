package com.reminder.mapautomotive.domain.repository

interface AuthRepository {
    suspend fun login(username: String, password: String): Result<Boolean>
}

interface AuthUseCase {
    suspend operator fun invoke(username: String, password: String): Result<Boolean>
}

