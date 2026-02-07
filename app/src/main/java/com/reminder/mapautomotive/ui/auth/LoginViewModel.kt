package com.reminder.mapautomotive.ui.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reminder.mapautomotive.domain.model.LoginUiState
import com.reminder.mapautomotive.domain.usecase.LoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {

    var uiState by mutableStateOf(LoginUiState())
        private set

    fun login() {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true)

            val isSuccess = loginUseCase.invoke(uiState.username, uiState.password)

            uiState = uiState.copy(
                isSuccess = isSuccess.isSuccess,
                error = isSuccess.exceptionOrNull()?.message,
                isLoading = false
            )


        }
    }

    fun onUsernameChange(text: String) {
        uiState = uiState.copy(username = text)
    }

    fun onPasswordChange(text: String) {
        uiState = uiState.copy(password = text)
    }


}