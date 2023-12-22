package org.sopt.dosopttemplate.presentation.signUp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.dosopttemplate.data.dto.request.RequestSignUpDto
import org.sopt.dosopttemplate.module.ApiFactory
import org.sopt.dosopttemplate.module.AuthService

class SignUpViewModel : ViewModel() {
    private val _signUpSuccess: MutableLiveData<String> = MutableLiveData()
    val signUpSuccess: LiveData<String> = _signUpSuccess

    suspend fun signUp(id: String, pw: String, nickname: String) {
        viewModelScope.launch {
            val signUpService = ApiFactory.create<AuthService>()
            kotlin.runCatching {
                signUpService.postSignUp(RequestSignUpDto(id, pw, nickname))
            }.onSuccess {
                _signUpSuccess.value = "회원가입 성공"
            }.onFailure {
                _signUpSuccess.value = "서버 에러 발생"
            }
        }
    }

}