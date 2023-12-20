package org.sopt.dosopttemplate.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.RecyclerView
import org.sopt.dosopttemplate.MyApplication
import org.sopt.dosopttemplate.R
import org.sopt.dosopttemplate.data.dataclass.User
import org.sopt.dosopttemplate.presentation.mypage.UserAdapter
import org.sopt.dosopttemplate.databinding.FragmentHomeBinding
import org.sopt.dosopttemplate.presentation.mainhome.MainHomeViewModel


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = requireNotNull(_binding) { "바인딩 객체가 생성되지 않음" }

    //viewModel 생성
    private val viewModel by viewModels<MainHomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //viewModel에서 친구 리스트 가져와서 생성
        val friendAdapter = FriendAdapter(requireContext())
        friendAdapter.setFriendList(viewModel.mockFriendList)

        //유저 리스트 생성
        var userData = getUserInfoToUser()
        val userAdapter = UserAdapter(requireContext())
        userAdapter.setUserList(listOf(userData))

        //concatAdapter로 두 리스트 concat
        val concatAdapter = ConcatAdapter(userAdapter, friendAdapter)
        //concat된 list를 fragment영역에 적용
        binding.homeRvFriends.adapter = concatAdapter

        //fab 상단 스크롤 지원
        upScrollListener(binding.homeRvFriends)
    }

    fun upScrollListener(view: RecyclerView) =with(binding) {
        //fab 클릭시 스크롤 상단으로 이동
        homeFabToTop.setOnClickListener {
            homeRvFriends.smoothScrollToPosition(0)
        }

    }

    //userAdapter로 넘길 User 객체에 기존 유저정보 이식
    private fun getUserInfoToUser(): User {
        var userData = User(
            R.drawable.pr_image,
            MyApplication.prefs.getString("nick", ""),
            "",
            MyApplication.prefs.getString("id", ""),
            MyApplication.prefs.getString("pw", ""),
            MyApplication.prefs.getString("mbti", ""),
        )
        return userData
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}