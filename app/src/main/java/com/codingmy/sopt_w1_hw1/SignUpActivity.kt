package com.codingmy.sopt_w1_hw1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codingmy.sopt_w1_hw1.databinding.ActivitySignupBinding
import com.google.android.material.snackbar.Snackbar

class SignUpActivity :AppCompatActivity(){
    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //가입하기 버튼 눌렸을 때
        binding.btSignupButton.setOnClickListener{
            //로그인 조건 확인
            if((binding.etSignupId.text.length<11 && binding.etSignupId.text.length>5) && (binding.etSignupPw.text.length<13 && binding.etSignupPw.text.length>7) && (binding.etSignupNickname.text.length>0 && binding.etSignupNickname.text != " "))
            {
                        //스낵바 띄우기
                        Snackbar.make(
                            binding.root,
                            "회원가입 완료",
                            Snackbar.LENGTH_SHORT
                            )
                        val intent= Intent (this,LoginActivity::class.java )

                        //id pw 넘기기
                        intent.putExtra("id", binding.etSignupId.text)
                        intent.putExtra("pw", binding.etSignupPw.text)

                        //창 이동
                        startActivity(intent)
            }
            else{
                //조건에 맞지 않을 때, 메세지 발생
                }

            }
        }
    }
}