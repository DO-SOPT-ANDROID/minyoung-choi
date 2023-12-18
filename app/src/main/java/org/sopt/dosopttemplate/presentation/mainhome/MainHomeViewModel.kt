package org.sopt.dosopttemplate.presentation.mainhome

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.dosopttemplate.MyApplication
import org.sopt.dosopttemplate.data.dataclass.Friend
import org.sopt.dosopttemplate.R
import org.sopt.dosopttemplate.data.dto.request.RequestUserDataDto
import org.sopt.dosopttemplate.data.dto.response.ResponseUserDataDto
import org.sopt.dosopttemplate.module.ServicePool.authService
import org.sopt.dosopttemplate.presentation.doandroid.DoAndroidFragment
import org.sopt.dosopttemplate.presentation.follower.FollowerFragment
import org.sopt.dosopttemplate.presentation.home.HomeFragment
import org.sopt.dosopttemplate.presentation.mypage.MyPageFragment
import retrofit2.Call
import retrofit2.Response

class MainHomeViewModel : ViewModel() {
    private val _navigateTo = MutableLiveData<Fragment>()
    val navigateTo: LiveData<Fragment>
        get() = _navigateTo

    var userId: Int = 0
    fun clickBottomNavigation(itemId: Int): Boolean {

        when (itemId) {
            R.id.menu_home -> {
                _navigateTo.value = HomeFragment()
                return true
            }

            R.id.menu_do_android -> {
                _navigateTo.value = DoAndroidFragment()
                return true
            }

            R.id.menu_mypage -> {
                myPageUserInfo(userId)
                _navigateTo.value = MyPageFragment()
                return true
            }

            R.id.menu_follower -> {
                _navigateTo.value = FollowerFragment()
                return true
            }

            else -> return false
        }
    }


    private fun myPageUserInfo(userId: Int) {
        authService.getUserInfo(userId)
            .enqueue(object : retrofit2.Callback<ResponseUserDataDto> {
                override fun onResponse(
                    call: Call<ResponseUserDataDto>,
                    response: Response<ResponseUserDataDto>,
                ) {
                    if (response.isSuccessful) {
                        val data: ResponseUserDataDto = requireNotNull(response.body())
                        val userNickname = data.nickname
                        val userUsername = data.username

                        //sharedpreference로 넘기기
                        MyApplication.prefs.setString("nick", userNickname)
                        MyApplication.prefs.setString("username", userUsername)
                        MyApplication.prefs.setString("id", userId.toString())
                    }
                }

                override fun onFailure(call: Call<ResponseUserDataDto>, t: Throwable) {
                    _errorMsg.value = "서버 에러 발생"
                }
            })
    }

    private var _errorMsg = MutableLiveData<String>()
    val errorMsg: LiveData<String>
        get() = _errorMsg

    //viewModel에 친구 리스트 저장
    val mockFriendList = listOf<Friend>(
        Friend(
            profileImage = R.drawable.pr_image,
            name = "친구1",
            self_description = "상태창1",
        ),
        Friend(
            profileImage = R.drawable.pr_image,
            name = "친구2",
            self_description = "상태창2",
        ),
        Friend(
            profileImage = R.drawable.pr_image,
            name = "친구3",
            self_description = "상태창3",
        ),
        Friend(
            profileImage = R.drawable.pr_image,
            name = "친구4",
            self_description = "상태창4",
        ),
        Friend(
            profileImage = R.drawable.pr_image,
            name = "친구5",
            self_description = "상태창5",
        ),
        Friend(
            profileImage = R.drawable.pr_image,
            name = "친구6",
            self_description = "상태창6",
        ),
        Friend(
            profileImage = R.drawable.pr_image,
            name = "친구7",
            self_description = "상태창7",
        ),
        Friend(
            profileImage = R.drawable.pr_image,
            name = "친구8",
            self_description = "상태창8",
        ),
        Friend(
            profileImage = R.drawable.pr_image,
            name = "친구9",
            self_description = "상태창9",
        ),
        Friend(
            profileImage = R.drawable.pr_image,
            name = "친구10",
            self_description = "상태창10",
        ),
    )

}

