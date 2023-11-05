package org.sopt.dosopttemplate

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

        //fragment 안보였던 이슈 해결
        //아래 말고 return binding.root, _binding 추가
        // return super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.getSharedPreferences("data", Context.MODE_PRIVATE)

        binding.tvMainID.text = MyApplication.prefs.getString("id", "")
        binding.tvMainMbti.text = MyApplication.prefs.getString("nick", "")
        binding.tvMainNick.text = MyApplication.prefs.getString("mbti", "")

        if (id != null) {
            // 데이터가 null이 아닌 경우 처리
            Toast.makeText(requireContext(), "id: $id", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}