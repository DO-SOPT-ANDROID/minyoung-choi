package org.sopt.dosopttemplate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar
import org.sopt.dosopttemplate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewBinding: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var id:String? = intent.getStringExtra("id")
        var nick:String? = intent.getStringExtra("nick")
        var mbti:String? =  intent.getStringExtra("mbti")
        var pw:String? = intent.getStringExtra("pw")

        val resultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){ result ->
            if(result.resultCode == RESULT_OK){
                val data: Intent? = result.data

                val id_sign = data?.getStringExtra("id")
                val pw_sign = data?.getStringExtra("pw")
                val nick_sign = data?.getStringExtra("name")
                val mbti_sign = data?.getStringExtra("mbti")

                id=id_sign
                pw=pw_sign
                nick=nick_sign
                mbti=mbti_sign

                Snackbar.make(
                    binding.root,
                    "회원가입을 완료했습니다.",
                    Snackbar.LENGTH_SHORT
                ).setAction("확인"){}.show()
            }
        }


        //이전 페이지에서 id pw 전달했을 때
        if (intent.hasExtra("id")) {
            id = intent.getStringExtra("id")
            nick = intent.getStringExtra("nick")
            mbti = intent.getStringExtra("mbti")
            pw = intent.getStringExtra("pw")
            binding.tvMainID.text=id
            binding.tvMainNick.text=nick
            binding.tvMainMbti.text=mbti
        }


    }
}