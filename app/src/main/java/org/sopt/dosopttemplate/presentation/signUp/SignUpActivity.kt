package org.sopt.dosopttemplate.presentation.signUp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity

import androidx.core.content.ContextCompat
import org.sopt.dosopttemplate.R
import org.sopt.dosopttemplate.module.ServicePool.authService
import org.sopt.dosopttemplate.databinding.ActivitySignupBinding
import org.sopt.dosopttemplate.presentation.login.LoginActivity
import org.sopt.dosopttemplate.data.dto.request.RequestSignUpDto
import org.sopt.dosopttemplate.data.dto.response.ResponseSignUpDto
import org.sopt.dosopttemplate.utils.toast
import retrofit2.Call
import retrofit2.Response
import java.util.regex.Pattern


class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding

    //false 일 때 가입 불가
    //true 일 때 가입 가능
    private var signUpIdAvailable = false
    private var signUpPwAvailable = false


    @SuppressLint("SuspiciousIndentation", "ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)

        with(binding) {
            setContentView(binding.root)

            //텍스트 감시
            setIdTextWatchers()
            setPwTextWatchers()

            //가입하기 버튼 눌렸을 때
            btSignupButton.setOnClickListener {
                //가입 조건 확인

                if (checkCondition() && signUpIdAvailable && signUpPwAvailable) {
                    signUp()


                    //토스트 띄우기
                    val intent = Intent(this@SignUpActivity, LoginActivity::class.java)

                    toast("회원가입 성공")
//   도전과제 꼭 할거라서 남겨놨습니다!                 /*
//                                //유저정보 -> 리스트로 구성
//                                val userInfoList = UserInfoToListString()
//
//                                sendUserInfo(intent, userInfoList)
//                */
                    //액티비티 이동
                    startActivity(intent)

                } else {
                    toast("모든 정보를 입력해야합니다.")
                }

            }
        }
    }


    private fun setIdTextWatchers() {
        with(binding) {

            //id 조건 확인
            etSignupId.addTextChangedListener(object : TextWatcher {
                val idPattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*[0-9]).{6,10}$")

                override fun afterTextChanged(s: Editable?) {

                    if (idPattern.matcher(s).matches()) {
                        //조건맞을때
                        etSignupPw.error = null
                        signUpIdAvailable = true
                        etSignupId.setBackgroundResource(R.drawable.shape_white_line_8_rect)
                        if (signUpPwAvailable)
                            btSignupButton.setBackgroundResource(R.drawable.shape_green_fill_rect)

                    } else {
                        //입력값이 not null일때==잘못된 값 들어왔을 때
                        //경고 창 띄우기
                        if (s != null) {
                            etSignupPw.error = getString(R.string.signUpIdErrorMsg)
                            signUpIdAvailable = false
                            etSignupId.setBackgroundResource(R.drawable.shape_red_line_8_rect)
                        }
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
                    if (idPattern.matcher(s).matches()) {
                        //조건 맞을때
                        etSignupId.error = null
                        signUpIdAvailable = true
                        etSignupId.setBackgroundResource(R.drawable.shape_white_line_8_rect)
                        if (signUpPwAvailable)
                            btSignupButton.setBackgroundResource(R.drawable.shape_green_fill_rect)


                    } else {
                        if (s != null) {

                            etSignupId.error = getString(R.string.signUpIdErrorMsg)
                            signUpIdAvailable = false
                            etSignupId.setBackgroundResource(R.drawable.shape_red_line_8_rect)
                            btSignupButton.setBackgroundResource(R.drawable.shape_gray_fill_rect)
                        }
                    }

                }
            })
        }
    }

    private fun setPwTextWatchers() {
        with(binding) {
            etSignupPw.addTextChangedListener(object : TextWatcher {
                val pwPattern =
                    Pattern.compile("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&]).{6,12}$")

                override fun afterTextChanged(s: Editable?) {
//                    if ((s == null) || (s.length !in (lengthPwMin..lengthPwMax))) {
                    if (!pwPattern.matcher(s).matches()) {
                        if (s != null) {

                            etSignupPw.error = getString(R.string.signUpPwErrorMsg)
                            signUpPwAvailable = false
                            etSignupPw.setBackgroundResource(R.drawable.shape_red_line_8_rect)
                            btSignupButton.setBackgroundResource(R.drawable.shape_gray_fill_rect)
                        }
                    } else {
                        etSignupPw.error = null
                        signUpPwAvailable = true
                        etSignupPw.setBackgroundResource(R.drawable.shape_white_line_8_rect)
                        if (signUpIdAvailable)
                            btSignupButton.setBackgroundResource(R.drawable.shape_green_fill_rect)

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
                    if (!pwPattern.matcher(s).matches()) {
                        //조건안맞
                        if (s != null) {
                            etSignupPw.error = getString(R.string.signUpIdErrorMsg)
                            signUpPwAvailable = false
                            etSignupPw.setBackgroundResource(R.drawable.shape_red_line_8_rect)
                            btSignupButton.setBackgroundResource(R.drawable.shape_gray_fill_rect)
                        }
                    } else {
                        etSignupPw.error = null
                        signUpPwAvailable = true
                        etSignupPw.setBackgroundResource(R.drawable.shape_white_line_8_rect)
                        if (signUpIdAvailable)
                            btSignupButton.setBackgroundResource(R.drawable.shape_green_fill_rect)


                    }

                }
            })

            if (signUpPwAvailable && signUpIdAvailable)
                btSignupButton.setBackgroundResource(R.drawable.shape_green_fill_rect)

        }
    }

    private fun checkCondition() =
        (!binding.etSignupNickname.text.isBlank() && !binding.etSignupNickname.text.isBlank())


//       여기도 심화과제할거라서!
//        private fun sendUserInfo(
//            intent: Intent,
//            userInfoList: List<String>
//        ) {
//            //id pw 넘기기
//            intent.putStringArrayListExtra("userInfoList", ArrayList(userInfoList))
//            setResult(RESULT_OK, intent)
//        }
//    */
//
//    /*
//        private fun UserInfoToListString(): List<String> {
//            val userInfoList = listOf<String>(
//                binding.etSignupId.text.toString(),
//                binding.etSignupPw.text.toString(),
//                binding.etSignupNickname.text.toString(),
//                binding.etSignupMbti.text.toString()
//            )
//            return userInfoList
//        }


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
                            toast("회원가입 성공")
                        }
                    }

                    override fun onFailure(call: Call<ResponseSignUpDto>, t: Throwable) {
                        toast("서버 에러 발생")
                    }
                })
        }
    }

}

