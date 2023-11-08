package org.sopt.dosopttemplate

//import com.codingmy.sopt_w1_hw1.MainActivity


//이 코드 대신 아래 코드로 수정
//import com.codingmy.sopt_w1_hw1.databinding.ActivityLoginBinding
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import org.sopt.dosopttemplate.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val receivedUserInfoList = intent.getStringArrayListExtra("userInfoList")!!

        //로그인 버튼 클릭
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
                Snackbar.make(
                    binding.root, "로그인을 실패했습니다.", Snackbar.LENGTH_SHORT
                ).show()
            }
        }
        //가입 버튼 클릭
        binding.btSign.setOnClickListener {

            //회원가입 페이지로 이동
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)

        }

    }


}




