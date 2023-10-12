package com.codingmy.sopt_w1_hw1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codingmy.sopt_w1_hw1.databinding.ActivitySignupBinding
import com.google.android.material.snackbar.Snackbar
import android.widget.Toast
import android.app.Activity


class SignUpActivity :AppCompatActivity(){
    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //가입하기 버튼 눌렸을 때
        binding.btSignupButton.setOnClickListener{

            //가입 조건 확인
            if((binding.etSignupId.text.length<11 && binding.etSignupId.text.length>5) && (binding.etSignupPw.text.length<13 && binding.etSignupPw.text.length>7) && (binding.etSignupNickname.text.length>0 && !binding.etSignupNickname.text.isBlank() ))
            {
                //스낵바 띄우기
                Snackbar.make(
                    binding.root,
                    "회원가입 완료",
                    Snackbar.LENGTH_LONG
                ).show()
                val intent= Intent (this,LoginActivity::class.java )

                //id pw 넘기기
                intent.putExtra("id", binding.etSignupId.text.toString())
                intent.putExtra("pw", binding.etSignupPw.text.toString())
                intent.putExtra("nick", binding.etSignupNickname.text.toString())
                intent.putExtra("mbti", binding.etSignupMbti.text.toString())
                setResult(Activity.RESULT_OK, intent)
                //창 이동
                startActivity(intent)
            }
            else{
                Snackbar.make(
                    binding.root,
                    "모든 정보를 입력해야합니다.",
                    Snackbar.LENGTH_SHORT
                ).show()
                }

            }
        }
    }

