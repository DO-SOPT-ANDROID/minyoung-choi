package org.sopt.dosopttemplate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import org.sopt.dosopttemplate.databinding.ActivityMainhomeBinding


class MainHomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainhomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainhomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val receivedUserInfoList = intent.getStringArrayListExtra("userInfoList")!!

        //데이터 수신 확인용- 여기까지는 정상 data 수신
        //확인 완료
//        Snackbar.make(
//            binding.root,
//            "id"+receivedUserInfoList[0].toString(),
//            Snackbar.LENGTH_SHORT
//        ).setAction("확인"){}.show()

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_home)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fcv_home, HomeFragment())
                .commit()
        }
        clickBottomNavigation()
    }

    private fun clickBottomNavigation() {

        //fragment result api 적용중
//        val result = receivedUserInfoList
//        setFragmentResult("userInfoList".bundleOf("BundleKey" to result))
        ///////////////////////////


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
