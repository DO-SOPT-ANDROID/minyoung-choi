package org.sopt.dosopttemplate.presentation.signUp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity

import android.widget.Toast
import org.sopt.dosopttemplate.R
import org.sopt.dosopttemplate.module.ServicePool.authService
import org.sopt.dosopttemplate.databinding.ActivitySignupBinding
import org.sopt.dosopttemplate.presentation.login.LoginActivity
import org.sopt.dosopttemplate.data.dto.request.RequestSignUpDto
import org.sopt.dosopttemplate.data.dto.response.ResponseSignUpDto
import retrofit2.Call
import retrofit2.Response


class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    //0일 때 가입 불가
    //1일 때 가입 가능
    private var signUpAvailable=0


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)

        with(binding) {
            setContentView(binding.root)

            //텍스트 감시
            setUpTextWatchers()

            //가입하기 버튼 눌렸을 때
            btSignupButton.setOnClickListener {

                //가입 조건 확인
                if (checkCondition()) {
                    //토스트 띄우기
                    val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
                    signUp()

                    Toast.makeText(this@SignUpActivity, "회원가입 성공", Toast.LENGTH_SHORT).show()
                    /*
                                //유저정보 -> 리스트로 구성
                                val userInfoList = UserInfoToListString()

                                sendUserInfo(intent, userInfoList)
                */
                    //액티비티 이동
                    startActivity(intent)

                } else {
/*
                    Snackbar.make(
                        this,
                        "모든 정보를 입력해야합니다.",
                        Snackbar.LENGTH_SHORT
                    ).show()
*/
                }

            }
        }
    }


    private fun setUpTextWatchers() {
        with(binding) {

            //id 조건 확인
            etSignupId.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    //길이 확인
                    if ((s == null) || (s.length !in (lengthIdMin..lengthIdMax))) {
                        //아무것도 입력x 거나 길이가 안맞을 때
                        etSignupPw.error = getString(R.string.signUpIdErrorMsg)
                    } else {
                        etSignupPw.error = null
                    }
                }

                //변하기 전
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int,
                ) {
                }

                //입력값 있고나서
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    //여기에 입력 후 내용물 감시
                    if ((s != null) && ((s.length !in (lengthIdMin..lengthIdMax))/* || 영문숫자조건 안맞을때*/)) {
                        //아무것도 입력x 거나 길이가 안맞을 때
                        etSignupPw.error = getString(R.string.signUpIdErrorMsg)
                    } else {
                        etSignupPw.error = null
                    }

                }
            })

            etSignupPw.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    if ((s == null) || (s.length !in (lengthPwMin..lengthPwMax))) {
                        etSignupPw.error = getString(R.string.signUpPwErrorMsg)
                    } else {
                        etSignupPw.error = null
                    }
                }

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int,
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    //여기에 입력 후 내용물 감시
                    if ((s != null) && ((s.length !in (lengthPwMin..lengthPwMax))/* || 영문숫자조건 안맞을때*/)) {
                        //아무것도 입력x 거나 길이가 안맞을 때
                        etSignupPw.error = getString(R.string.signUpIdErrorMsg)
                    } else {
                        etSignupPw.error = null
                    }

                }
            })

        }
    }

    private fun checkCondition() =
        (binding.etSignupId.text.length < 11 && binding.etSignupId.text.length > 5) && (binding.etSignupPw.text.length < 13 && binding.etSignupPw.text.length > 7) && (binding.etSignupNickname.text.length > 0 && !binding.etSignupNickname.text.isBlank())

    /*
        private fun sendUserInfo(
            intent: Intent,
            userInfoList: List<String>
        ) {
            //id pw 넘기기
            intent.putStringArrayListExtra("userInfoList", ArrayList(userInfoList))
            setResult(RESULT_OK, intent)
        }
    */

    /*
        private fun UserInfoToListString(): List<String> {
            val userInfoList = listOf<String>(
                binding.etSignupId.text.toString(),
                binding.etSignupPw.text.toString(),
                binding.etSignupNickname.text.toString(),
                binding.etSignupMbti.text.toString()
            )
            return userInfoList
        }
    */

    private fun signUp() = with(binding) {
        val id = etSignupId.text.toString();
        val pw = etSignupPw.text.toString()
        val nickname = etSignupNickname.text.toString()

        btSignupButton.setOnClickListener {
            authService.signUp(RequestSignUpDto(id, pw, nickname))
                .enqueue(object : retrofit2.Callback<ResponseSignUpDto> {
                    override fun onResponse(
                        call: Call<ResponseSignUpDto>,
                        response: Response<ResponseSignUpDto>,
                    ) {
                        if (response.isSuccessful) {
                            Toast.makeText(
                                this@SignUpActivity,
                                "회원가입 성공",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    override fun onFailure(call: Call<ResponseSignUpDto>, t: Throwable) {
                        Toast.makeText(this@SignUpActivity, "서버 에러 발생", Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }
    companion object {
        const val lengthIdMin = 6
        const val lengthIdMax = 10
        const val lengthPwMin = 6
        const val lengthPwMax = 12
    }

}

