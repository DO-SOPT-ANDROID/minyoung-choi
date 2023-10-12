package com.codingmy.sopt_w1_hw1

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.codingmy.sopt_w1_hw1.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar


class LoginActivity :AppCompatActivity(){
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btLogin.setOnClickListener {
            //토스트 보이기
            if(/*데이터 id, pw 일치시*/) {
                Snackbar.make(
                    binding.root,
                    "로그인을 성공했습니다.",
                    Snackbar.LENGTH_SHORT
                ).show()
                //메인페이지로 이동
                val intent=Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            //로그인 실패
            else
            {
                Snackbar.make(
                    binding.root,
                    "로그인을 실패했습니다.",
                    Snackbar.LENGTH_SHORT
                )
            }
        }

        binding.btSign.setOnClickListener {
            /*회원가입 페이지로 이동*/
            val intent=Intent(this, SignUpActivity::class.java)
            startActivity(intent)

        }

    }




}