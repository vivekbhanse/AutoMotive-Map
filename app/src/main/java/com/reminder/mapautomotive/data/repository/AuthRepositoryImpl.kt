package com.reminder.mapautomotive.data.repository

import com.reminder.mapautomotive.domain.repository.AuthRepository

class AuthRepositoryImpl : AuthRepository {
    override suspend fun login(
        username: String,
        password: String
    ): Result<Boolean> {
        // Fake check
        return try {
            val success = username == "admin" && password == "1234"

            if (success) {
                Result.success(true)
            } else {
                Result.failure(Exception("Invalid username or password"))
            }

        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}