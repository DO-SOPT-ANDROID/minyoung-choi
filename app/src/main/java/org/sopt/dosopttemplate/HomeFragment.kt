package org.sopt.dosopttemplate

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
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

        //id 데이터 변형되서 넘어옴
        //토스트, 스낵바 둘다 손상된 data 내용은 동일
        Snackbar.make(
            binding.root,
            "id : $id  "+id,
            Snackbar.LENGTH_SHORT
        ).setAction("확인"){}.show()
        Toast.makeText(requireContext(), "id"+id, Toast.LENGTH_SHORT).show()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}