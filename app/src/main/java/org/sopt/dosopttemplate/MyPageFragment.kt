package org.sopt.dosopttemplate

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

class MyPageFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.getSharedPreferences("data", Context.MODE_PRIVATE)

        var id:String? = arguments?.getString("id")
        var nick = arguments?.getString("nick")
        var mbti = arguments?.getString("mbti")
        var pw = arguments?.getString("pw")

        if (id != null) {
            // 데이터가 null이 아닌 경우 처리
            Toast.makeText(requireContext(), "id: $id", Toast.LENGTH_SHORT).show()
        }

        //토스트 띄우기
        Toast.makeText(requireContext(), "id: "+id, Toast.LENGTH_SHORT).show()

        //var id= arguments?.getString("id")
        //토스트 띄우기
        Toast.makeText(requireContext(), "id: "+id, Toast.LENGTH_SHORT).show()




    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}