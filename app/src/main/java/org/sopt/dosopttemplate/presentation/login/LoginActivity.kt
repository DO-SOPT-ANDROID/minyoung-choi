package org.sopt.dosopttemplate.presentation.login


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.sopt.dosopttemplate.databinding.ActivityLoginBinding
import org.sopt.dosopttemplate.presentation.mainhome.MainHomeActivity
import org.sopt.dosopttemplate.presentation.mainhome.MainHomeViewModel
import org.sopt.dosopttemplate.presentation.signUp.SignUpActivity
import org.sopt.dosopttemplate.utils.toast


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        initLoginClickListener()
        //    val receivedUserInfoList = intent.getStringArrayListExtra("userInfoList")!!

        /*
        //1주차 도전과제 수행시 사용을 위해
                //로그인 버튼 클릭
                //로컬 로그인
                binding.btLogin.setOnClickListener {

                    val input_id = binding.etLoginId.text.toString()
                    val input_pw = binding.etLoginPw.text.toString()

                    //id pw 일치여부 확인
                    if (receivedUserInfoList[0].toString() == input_id && receivedUserInfoList[1].toString() == input_pw) {
                        //토스트 띄우기
                        Toast.makeText(this, "로그인을 성공했습니다.", Toast.LENGTH_SHORT).show()

                        //id, pw 정보 넘기기
                        val intent = Intent(this, MainHomeActivity::class.java)
                        intent.putExtra("userInfoList", receivedUserInfoList)

                        //메인홈페이지로 이동
                        startActivity(intent)

                    }
                    //로그인 실패
                    else {
                        snackbar(binding.root, "로그인을 실패했습니다.")
                    }
                }
        */
        //가입 버튼 클릭
        binding.btSign.setOnClickListener {

            //회원가입 페이지로 이동
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initLoginClickListener() {
        with(binding) {
            val id = binding.etLoginId.text.toString()
            val password = binding.etLoginPw.text.toString()
            binding.btLogin.setOnClickListener {
                loginViewModel.checkLoginFromServer(id, password)
                checkLoginAvailableFromServer()
            }
        }
    }

    private fun checkLoginAvailableFromServer() {
        lifecycleScope.launch {
            loginViewModel.loginState.collect { loginState ->
                when (loginState) {
                    is LoginState.Success -> {
                        toast("로그인 성공")
                        val intent = Intent(this@LoginActivity, MainHomeActivity::class.java)
                        startActivity(intent)
                    }

                    is LoginState.Error -> {
                        toast("로그인 실패")
                    }

                    is LoginState.Loading -> {}

                    else -> {}
                }
            }
        }
    }

    /*
        authService.postLogin(RequestLoginDto(id, password))
            .enqueue(object : Callback<ResponseLoginDto> {
                override fun onResponse(
                    call: Call<ResponseLoginDto>,
                    response: Response<ResponseLoginDto>,
                ) {
                    if (response.isSuccessful) {
                        val data: ResponseLoginDto = requireNotNull(response.body()!!)
                        val userId: Int = data.id
                        toast("로그인 성공")
                        val intent = Intent(this@LoginActivity, MainHomeActivity::class.java)
                        intent.putExtra("id", userId)
                        startActivity(intent)
                    } else {
                        toast("아이디와 패스워드가 일치 하지 않습니다.")
                    }
                }

                override fun onFailure(call: Call<ResponseLoginDto>, t: Throwable) {
                    toast("서버 에러 발생")
                }
            })
*/
}




