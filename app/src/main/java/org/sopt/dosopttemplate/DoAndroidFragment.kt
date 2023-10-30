package org.sopt.dosopttemplate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import org.sopt.dosopttemplate.databinding.FragmentDoandroidBinding

class DoAndroidFragment : Fragment() {
    private var _binding: FragmentDoandroidBinding? = null
    private val binding: FragmentDoandroidBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDoandroidBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        var id: String? = arguments?.getString("id")
        var nick = arguments?.getString("nick")
        var mbti = arguments?.getString("mbti")
        var pw = arguments?.getString("pw")
        Toast.makeText(requireContext(), "sadfasd" + id+"/pw"+pw, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}