package org.sopt.dosopttemplate

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
//import com.codingmy.sopt_w1_hw1.MainActivity
import org.sopt.dosopttemplate.MainActivity


import com.google.android.material.snackbar.Snackbar

//이 코드 대신 아래 코드로 수정
//import com.codingmy.sopt_w1_hw1.databinding.ActivityLoginBinding
import org.sopt.dosopttemplate.databinding.ActivityLoginBinding

class LoginActivity :AppCompatActivity(){

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var sign_id: String? = null
        var sign_pw: String? = null
        var sign_nick: String? = null
        var sign_mbti: String? = null
        sign_id = intent.getStringExtra("id")
        sign_pw = intent.getStringExtra("pw")
        sign_nick = intent.getStringExtra("nick")
        sign_mbti = intent.getStringExtra("mbti")



        //로그인 버튼 클릭
        binding.btLogin.setOnClickListener {

            val input_id=binding.etLoginId.text.toString()
            val input_pw=binding.etLoginPw.text.toString()

            //id pw 일치여부 확인
            if(sign_id== input_id && sign_pw ==input_pw)
            {
                //토스트 띄우기
                Toast.makeText(this, "로그인을 성공했습니다.", Toast.LENGTH_SHORT).show()

                //id, pw 정보 넘기기
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("id", sign_id)
                intent.putExtra("pw", sign_pw)
                intent.putExtra("nick", sign_nick)
                intent.putExtra("mbti", sign_mbti)
                setResult(RESULT_OK, intent)

                //회원정보 페이지로 이동
                startActivity(intent)

            }
            //로그인 실패
            else
            {
                Snackbar.make(
                    binding.root,
                    "로그인을 실패했습니다.",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }
        //가입 버튼 클릭
        binding.btSign.setOnClickListener {

            /*회원가입 페이지로 이동*/
            val intent=Intent(this, SignUpActivity::class.java)
            startActivity(intent)

        }

    }



}




