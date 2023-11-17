package org.sopt.dosopttemplate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import org.sopt.dosopttemplate.ServicePool.followerService
import org.sopt.dosopttemplate.databinding.FragmentFollowerBinding
import org.sopt.dosopttemplate.follower.FollowerListDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FollowerFragment : Fragment() {
    private var _binding: FragmentFollowerBinding? = null
    private val binding: FragmentFollowerBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        saveInstanceState: Bundle?
    ): View {
        _binding = FragmentFollowerBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //서버 통신
        getFollower()

            }
    override fun onDestroyView() {
        super.onDestroyView()
    }




    private fun getFollower() {
        /*
        val call: Call<FollowerListDto> = followerService.request()
        call.enqueue(object : Callback<FollowerListDto> {
*/
        followerService.request()
            .enqueue(object : Callback<FollowerListDto> {
            override fun onResponse(
                call: Call<FollowerListDto>,
                response: Response<FollowerListDto>,
            ) {
                if (response.isSuccessful) {
                    //follower 리스트 생성
                    val data: FollowerListDto = response.body()!!
                    val followerAdapter = FollowerAdapter(requireContext())
                    followerAdapter.setFollowerList(data.data)

                    binding.homeRvFollower.adapter = followerAdapter
                }
            }

            override fun onFailure(call: Call<FollowerListDto>, t: Throwable) {
                // 실패 시 처리
            }
        })
    }
}