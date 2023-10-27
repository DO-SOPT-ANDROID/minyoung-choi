package org.sopt.dosopttemplate

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.fragment.app.Fragment
import org.sopt.dosopttemplate.databinding.FragmentHomeBinding


class HomeFragment :Fragment(){
    private var _binding: FragmentHomeBinding? = null
    private lateinit var viewBinding: ActivityResultLauncher<Intent>

    private val binding: FragmentHomeBinding
    get() = requireNotNull(_binding) { "바인딩 객체가 생성되지 않았다." }
    private val mockFriendList =listOf <Friend>(
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
    )
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
        val friendAdapter = FriendAdapter(requireContext())
        binding.rvFriends.adapter= friendAdapter
        friendAdapter.setFriendList(mockFriendList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}