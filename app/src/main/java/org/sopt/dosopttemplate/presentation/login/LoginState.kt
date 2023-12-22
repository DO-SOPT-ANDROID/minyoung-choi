package org.sopt.dosopttemplate.presentation.login

import org.sopt.dosopttemplate.data.dto.response.ResponseLoginDto

sealed class LoginState {
    data class Success(val userId: ResponseLoginDto) : LoginState()
    object Loading: LoginState()
    object Error : LoginState()
}