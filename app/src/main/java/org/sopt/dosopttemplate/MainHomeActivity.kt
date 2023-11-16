package org.sopt.dosopttemplate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import org.sopt.dosopttemplate.databinding.ActivityMainhomeBinding
import java.util.ArrayList


class MainHomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainhomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainhomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //intent로 StringArrayList 형태로 받기
        var receivedUserInfoList = intent.getStringArrayListExtra("userInfoList")!!

        setUserInfoPrefs(receivedUserInfoList)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_home)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fcv_home, HomeFragment())
                .commit()
        }

        //하단 버튼 선택 초기값 설정
        binding.bnvHome.setSelectedItemId(R.id.menu_home)

        clickBottomNavigation()
    }

    //sharedpreference로 유저 data 넘기기
    private fun setUserInfoPrefs(receivedUserInfoList: ArrayList<String>) {
        MyApplication.prefs.setString("id", receivedUserInfoList[0])
        MyApplication.prefs.setString("pw", receivedUserInfoList[1])
        MyApplication.prefs.setString("nick", receivedUserInfoList[2])
        MyApplication.prefs.setString("mbti", receivedUserInfoList[3])
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