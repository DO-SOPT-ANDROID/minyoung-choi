package org.sopt.dosopttemplate

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Nickname
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.fragment.app.Fragment
import org.sopt.dosopttemplate.databinding.ActivityMainhomeBinding


class MainHomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainhomeBinding
     var id:String=""
     var nick:String=""
    var mbti:String=""
     var pw:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainhomeBinding.inflate(layoutInflater)
        lateinit var viewBinding: ActivityResultLauncher<Intent>

        setContentView(binding.root)

        var id = intent.getStringExtra("id")
        var nick: String? = intent.getStringExtra("nick")
        var mbti: String? = intent.getStringExtra("mbti")
        var pw: String? = intent.getStringExtra("pw")

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

                    //argument를 통해 fragment로 데이터 전달
                    setDataFragment(MyPageFragment(), id, pw, nick, mbti)

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

    //프래그먼트 띄우기
    fun setFragment(fragment: Fragment)
    {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.rv_friends, fragment)
        transaction.commit()
    }

    //프래그먼트에 데이터 전달
    fun setDataFragment(fragment: Fragment, id: String, pw:String, nick: String, mbti: String )
    {
        val bundle=Bundle()
        bundle.putString("id", id)
        bundle.putString("nick", nick)
        bundle.putString("mbti", mbti)
        bundle.putString("pw", pw)

        Log.d("BasicSyntax","로그를 출력합니다. method = Log.d")

        val myPageFragment = MyPageFragment()
        myPageFragment.arguments = bundle
        setFragment(myPageFragment)
    }
}
