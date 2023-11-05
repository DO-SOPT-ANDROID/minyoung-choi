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


class MainHomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainhomeBinding
    private var userInfoLiveData : MutableLiveData<User> = MutableLiveData()
    val infoViewModel by viewModels<MainHomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainhomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //viewModel 생성

        //intent로 StringArrayList 형태로 받기
        var receivedUserInfoList = intent.getStringArrayListExtra("userInfoList")!!

        //StringArrayList형태의 유저정보를 User 형태로 변환
        var receivedUserInfo = User("","","","")
        receivedUserInfo.id=receivedUserInfoList[0].toString()
        receivedUserInfo.pw=receivedUserInfoList[1].toString()
        receivedUserInfo.nick=receivedUserInfoList[2].toString()
        receivedUserInfo.mbti=receivedUserInfoList[3].toString()

        // 변환한 유저정보를 viewModel로 업데이트
        userInfoLiveData.value=receivedUserInfo


        //livedata 값 변경 감지, User형 변수에 값 받아오기
        userInfoLiveData.observe(this, Observer {
            receivedUserInfo.id=it.id
            receivedUserInfo.pw=it.pw
            receivedUserInfo.nick=it.nick
            receivedUserInfo.mbti=it.mbti
        })


        //데이터 수신 확인용- 여기까지는 정상 data 수신
        //확인 완료
        Snackbar.make(
            binding.root,
            "id"+receivedUserInfo.id,
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
