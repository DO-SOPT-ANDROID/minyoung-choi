package org.sopt.dosopttemplate.presentation.mainhome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import org.sopt.dosopttemplate.R
import org.sopt.dosopttemplate.databinding.ActivityMainhomeBinding
import org.sopt.dosopttemplate.presentation.home.HomeFragment


class MainHomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainhomeBinding
    private lateinit var mainHomeViewModel: MainHomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainhomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainHomeViewModel = ViewModelProvider(this).get(MainHomeViewModel::class.java)
        //intent로 StringArrayList 형태로 받기
//        var receivedUserInfoList = intent.getStringArrayListExtra("userInfoList")!!
        //setUserInfoPrefs(receivedUserInfoList)


        mainHomeViewModel.navigateTo.observe(this, Observer { fragment ->
            replaceFragment(fragment)
        })

        mainHomeViewModel.errorMsg.observe(this, Observer { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        })

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

    private fun clickBottomNavigation() {
        var userId= intent.getIntExtra("id", -1)

        binding.bnvHome.setOnItemSelectedListener {
            mainHomeViewModel.clickBottomNavigation(it.itemId, userId)
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcv_home, fragment)
            .commit()
    }

// 이 아래줄은 모두 주석입니다....급하게 과제하느라 나중에 도전 심화과제 할 때 필요할거같아서 일단은 남겨놓겠습니다!
/*
    //sharedpreference로 유저 data 넘기기
    private fun setUserInfoPrefs(receivedUserInfoList: ArrayList<String>) {
        MyApplication.prefs.setString("id", receivedUserInfoList[0])
        MyApplication.prefs.setString("pw", receivedUserInfoList[1])
        MyApplication.prefs.setString("nick", receivedUserInfoList[2])
        MyApplication.prefs.setString("mbti", receivedUserInfoList[3])
    }
*/

/*
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


    private fun inquiryUserInfo(userId:Int)
    {
        authService.inquiry(RequestUserDataDto(userId))
            .enqueue(object :retrofit2.Callback<ResponseUserDataDto> {
                override fun onResponse(
                    call: Call<ResponseUserDataDto>,
                    response: Response<ResponseUserDataDto>,
                ) {
                    if (response.isSuccessful) {
                        val data: ResponseUserDataDto = response.body()!!
                        val userNickname = data.nickname
                        val userUsername = data.username

                        //sharedpreference로 넘기기
                        MyApplication.prefs.setString("nick", userNickname)
                        MyApplication.prefs.setString("username", userUsername)
                        MyApplication.prefs.setString("id", userId.toString())
                    }
                }

                override fun onFailure(call: Call<ResponseUserDataDto>, t: Throwable) {
                    Toast.makeText(this@MainHomeActivity, "서버 에러 발생", Toast.LENGTH_SHORT).show()
                }
            }
            )
    }
*/
}