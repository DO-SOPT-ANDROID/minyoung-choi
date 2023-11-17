package org.sopt.dosopttemplate

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.sopt.dosopttemplate.databinding.FragmentMypageBinding

class MyPageFragment : Fragment() {
    private var _binding: FragmentMypageBinding? = null
    private val binding: FragmentMypageBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        _binding = FragmentMypageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.getSharedPreferences("data", Context.MODE_PRIVATE)

        getUserInfo()
    }

    private fun getUserInfo() {
        //sharedPreferenced 로 유저 정보 받기
        binding.mypageTvMyNick.text = MyApplication.prefs.getString("nick", "")
        binding.mypageTvMyMbti.text = MyApplication.prefs.getString("username", "")
        binding.mypageTvMyID.text = MyApplication.prefs.getString("id", "")
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}