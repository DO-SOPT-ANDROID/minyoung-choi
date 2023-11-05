package org.sopt.dosopttemplate

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import org.sopt.dosopttemplate.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private lateinit var viewBinding: ActivityResultLauncher<Intent>

    private val binding: FragmentHomeBinding
        get() = requireNotNull(_binding) { "바인딩 객체가 생성되지 않았다." }

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

        //viewModel로 친구 리스트 가져오기
        val friendAdapter = FriendAdapter(requireContext())
        binding.rvFriends.adapter = friendAdapter
        friendAdapter.setFriendList(viewModel.mockFriendList)

        //id 데이터 변형되서 넘어옴
        //토스트, 스낵바 둘다 손상된 data 내용은 동일
        //     Snackbar.make(
        //        binding.root,
        //        "id : $id  "+id,
        //        Snackbar.LENGTH_SHORT
        //    ).setAction("확인"){}.show()
        Toast.makeText(requireContext(), "id" + id, Toast.LENGTH_SHORT).show()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}