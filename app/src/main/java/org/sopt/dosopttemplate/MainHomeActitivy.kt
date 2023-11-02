package org.sopt.dosopttemplate

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Nickname
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import org.sopt.dosopttemplate.databinding.ActivityMainhomeBinding


class MainHomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainhomeBinding
    var id: String = ""
    var nick: String = ""
    var mbti: String = ""
    var pw: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainhomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var id = intent.getStringExtra("id")
        var nick: String? = intent.getStringExtra("nick")
        var mbti: String? = intent.getStringExtra("mbti")
        var pw: String? = intent.getStringExtra("pw")


        //데이터 수신 확인용- 여기도 손상된 data 수신
        Snackbar.make(
            binding.root,
            "id"+id,
            Snackbar.LENGTH_SHORT
        ).setAction("확인"){}.show()


        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_home)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fcv_home, HomeFragment())
                .commit()
        }
        clickBottomNavigation()
    }

    private fun clickBottomNavigation() {
        binding.bnvHome.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    replaceFragment(HomeFragment())
                    true
                }

                R.id.menu_do_android -> {
                    replaceFragment(DoAndroidFragment())
                    true
                }

                R.id.menu_mypage -> {
                    replaceFragment(MyPageFragment())
                    true
                }

                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcv_home, fragment)
            .commit()
    }
}
