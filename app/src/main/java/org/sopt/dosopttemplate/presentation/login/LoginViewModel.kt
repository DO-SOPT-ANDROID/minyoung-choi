package org.sopt.dosopttemplate.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.dosopttemplate.data.dataclass.UserInfo
import org.sopt.dosopttemplate.data.dto.request.RequestLoginDto
import org.sopt.dosopttemplate.module.ApiFactory
import org.sopt.dosopttemplate.module.AuthService

class LoginViewModel() : ViewModel() {
    private val _loginSuccess: MutableLiveData<Boolean> = MutableLiveData()
    var loginSuccess: LiveData<Boolean> = _loginSuccess

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Unstarted)
    val loginState: StateFlow<LoginState> = _loginState.asStateFlow()


    fun checkLoginFromServer(id: String, password: String) {
        viewModelScope.launch {
            val loginService = ApiFactory.create<AuthService>()
            _loginState.value = LoginState.Loading
            kotlin.runCatching {
                loginService.postLogin(RequestLoginDto(id, password))
            }.onSuccess {
                val body = it.body()
                if (it.body() != null) {
                    _loginState.value = LoginState.Success(requireNotNull(body))
                    UserInfo.toUser(id, password)

                } else {
                    _loginState.value = LoginState.Error
                }
            }.onFailure {
                _loginState.value = LoginState.Error
            }

///*
//            ServicePool.authService.postLogin(RequestLoginDto(id, password))
//                .enqueue(object : Callback<ResponseLoginDto> {
//                    override fun onResponse(
//                        call: Call<ResponseLoginDto>,
//                        response: Response<ResponseLoginDto>,
//                    ) {
//                        if (response.isSuccessful) {
//                                                    val data: ResponseLoginDto = requireNotNull(response.body()!!)
//
//
//                            val userId: Int = data.id
//                            loginSuccess.value = true
//                            toast("로그인 성공")
//                                                    val intent = Intent(context, MainHomeActivity::class.java)
//                                                    intent.putExtra("id", userId)
//
//
//                            startActivity(intent)
//                        } else {
//                            toast("아이디와 패스워드가 일치 하지 않습니다.")
//                        }
//                    }
//
//                    override fun onFailure(call: Call<ResponseLoginDto>, t: Throwable) {
//                        toast("서버 에러 발생")
//                    }
//                })
//*/

        }
    }
}
