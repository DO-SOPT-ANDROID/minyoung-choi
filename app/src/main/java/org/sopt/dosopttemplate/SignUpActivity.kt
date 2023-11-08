package org.sopt.dosopttemplate

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.google.android.material.snackbar.Snackbar
import android.widget.Toast
//import com.codingmy.sopt_w1_hw1.databinding.ActivitySignupBinding
import org.sopt.dosopttemplate.databinding.ActivitySignupBinding


class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //가입하기 버튼 눌렸을 때
        binding.btSignupButton.setOnClickListener {

            //가입 조건 확인
            if (checkCondition()) {
                //토스트 띄우기
                Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, LoginActivity::class.java)
                //유저정보 -> 리스트로 구성
                val userInfoList = UserInfoToListString()

                sendUserInfo(intent, userInfoList)
                //액티비티 이동
                startActivity(intent)

            } else {
                Snackbar.make(
                    binding.root,
                    "모든 정보를 입력해야합니다.",
                    Snackbar.LENGTH_SHORT
                ).show()
            }

        }
    }

    private fun checkCondition() =
        (binding.etSignupId.text.length < 11 && binding.etSignupId.text.length > 5) && (binding.etSignupPw.text.length < 13 && binding.etSignupPw.text.length > 7) && (binding.etSignupNickname.text.length > 0 && !binding.etSignupNickname.text.isBlank())

    private fun sendUserInfo(
        intent: Intent,
        userInfoList: List<String>
    ) {
        //id pw 넘기기
        intent.putStringArrayListExtra("userInfoList", ArrayList(userInfoList))
        setResult(RESULT_OK, intent)
    }

    private fun UserInfoToListString(): List<String> {
        val userInfoList = listOf<String>(
            binding.etSignupId.text.toString(),
            binding.etSignupPw.text.toString(),
            binding.etSignupNickname.text.toString(),
            binding.etSignupMbti.text.toString()
        )
        return userInfoList
    }
}

