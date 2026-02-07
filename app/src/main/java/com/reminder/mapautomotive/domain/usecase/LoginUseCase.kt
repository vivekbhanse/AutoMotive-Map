package com.reminder.mapautomotive.domain.usecase

import com.reminder.mapautomotive.domain.repository.AuthRepository

class LoginUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(username: String, password: String): Result<Boolean> {
        return authRepository.login(username, password)
    }

}