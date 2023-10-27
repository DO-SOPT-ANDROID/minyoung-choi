package org.sopt.dosopttemplate

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.fragment.app.Fragment
import org.sopt.dosopttemplate.databinding.ActivityMainhomeBinding


class MainHomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainhomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainhomeBinding.inflate(layoutInflater)
        lateinit var viewBinding: ActivityResultLauncher<Intent>

        setContentView(binding.root)

        var id: String? = intent.getStringExtra("id")
        var nick: String? = intent.getStringExtra("nick")
        var mbti: String? = intent.getStringExtra("mbti")
        var pw: String? = intent.getStringExtra("pw")

        //이전 페이지에서 id pw 전달했을 때
        if (intent.hasExtra("id")) {
            var id = intent.getStringExtra("id")
            var nick = intent.getStringExtra("nick")
            var mbti = intent.getStringExtra("mbti")
            var pw = intent.getStringExtra("pw")

        }

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
