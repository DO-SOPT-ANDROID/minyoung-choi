package org.sopt.dosopttemplate.presentation.mainhome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import org.sopt.dosopttemplate.MyApplication
import org.sopt.dosopttemplate.R
import org.sopt.dosopttemplate.module.ServicePool.authService
import org.sopt.dosopttemplate.databinding.ActivityMainhomeBinding
import org.sopt.dosopttemplate.data.dto.follower.retrofit2data.RequestInquiryDto
import org.sopt.dosopttemplate.data.dto.follower.retrofit2data.ResponseInquiryDto
import org.sopt.dosopttemplate.presentation.doandroid.DoAndroidFragment
import org.sopt.dosopttemplate.presentation.follower.FollowerFragment
import org.sopt.dosopttemplate.presentation.home.HomeFragment
import org.sopt.dosopttemplate.presentation.mypage.MyPageFragment
import retrofit2.Call
import retrofit2.Response


class MainHomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainhomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainhomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //intent로 StringArrayList 형태로 받기
//        var receivedUserInfoList = intent.getStringArrayListExtra("userInfoList")!!
        //setUserInfoPrefs(receivedUserInfoList)

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

/*
    //sharedpreference로 유저 data 넘기기
    private fun setUserInfoPrefs(receivedUserInfoList: ArrayList<String>) {
        MyApplication.prefs.setString("id", receivedUserInfoList[0])
        MyApplication.prefs.setString("pw", receivedUserInfoList[1])
        MyApplication.prefs.setString("nick", receivedUserInfoList[2])
        MyApplication.prefs.setString("mbti", receivedUserInfoList[3])
    }
*/

    private fun clickBottomNavigation() {
        var userId= intent.getIntExtra("id", -1)

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
                    inquiryUserInfo(userId)
                    replaceFragment(MyPageFragment())
                    true
                }
                R.id.menu_follower -> {
                    replaceFragment(FollowerFragment())
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

    private fun inquiryUserInfo(userId:Int)
    {
        authService.inquiry(RequestInquiryDto(userId))
            .enqueue(object :retrofit2.Callback<ResponseInquiryDto> {
                override fun onResponse(
                    call: Call<ResponseInquiryDto>,
                    response: Response<ResponseInquiryDto>,
                ) {
                    if (response.isSuccessful) {
                        val data: ResponseInquiryDto = response.body()!!
                        val userNickname = data.nickname
                        val userUsername = data.username

                        //sharedpreference로 넘기기
                        MyApplication.prefs.setString("nick", userNickname)
                        MyApplication.prefs.setString("username", userUsername)
                        MyApplication.prefs.setString("id", userId.toString())
                    }
                }

                override fun onFailure(call: Call<ResponseInquiryDto>, t: Throwable) {
                    Toast.makeText(this@MainHomeActivity, "서버 에러 발생", Toast.LENGTH_SHORT).show()
                }
            }
            )
    }
}