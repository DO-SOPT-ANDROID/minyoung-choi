package org.sopt.dosopttemplate

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import org.sopt.dosopttemplate.databinding.ActivityMainBinding
import org.sopt.dosopttemplate.databinding.FragmentMypageBinding

class MyPageFragment : Fragment(){
    private var _binding: FragmentMypageBinding? =null
    private val binding: FragmentMypageBinding get()= _binding!!

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

        var id:String? = arguments?.getString("id")
        var nick = arguments?.getString("nick")
        var mbti = arguments?.getString("mbti")
        var pw = arguments?.getString("pw")

        //null 값으로 data 전달 x
        Toast.makeText(requireContext(), "sadfasd" + id+"/pw"+pw, Toast.LENGTH_SHORT).show()

        if (id != null) {
            // 데이터가 null이 아닌 경우 처리
            Toast.makeText(requireContext(), "id: $id", Toast.LENGTH_SHORT).show()
        }

        binding.tvMainID.text=id
        binding.tvMainNick.text=nick
        binding.tvMainMbti.text=mbti

        //토스트 띄우기
        Toast.makeText( requireContext(),"id."+id, Toast.LENGTH_SHORT).show()


    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}