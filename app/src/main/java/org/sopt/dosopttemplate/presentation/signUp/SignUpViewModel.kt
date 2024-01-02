package org.sopt.dosopttemplate.presentation.signUp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.dosopttemplate.data.dto.request.RequestSignUpDto
import org.sopt.dosopttemplate.module.ApiFactory
import org.sopt.dosopttemplate.module.AuthService

class SignUpViewModel : ViewModel() {
    private var _signUpSuccess: MutableLiveData<Boolean> = MutableLiveData()
    var signUpSuccess: LiveData<Boolean> = _signUpSuccess

    fun signUp(id: String, pw: String, nickname: String) {
        viewModelScope.launch {
            val signUpService = ApiFactory.create<AuthService>()
            kotlin.runCatching {
                signUpService.postSignUp(RequestSignUpDto(id, pw, nickname))
            }.onSuccess {
                _signUpSuccess.value = true
                Log.e("서버", _signUpSuccess.value.toString())
            }.onFailure {
                Log.e("서버", "가입 불가")

            }
        }
    }

}