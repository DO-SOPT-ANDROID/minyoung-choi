package org.sopt.dosopttemplate.presentation.follower

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.sopt.dosopttemplate.module.ServicePool.followerService
import org.sopt.dosopttemplate.databinding.FragmentFollowerBinding
import org.sopt.dosopttemplate.data.dataclass.FollowerDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FollowerFragment : Fragment() {
    private var _binding: FragmentFollowerBinding? = null
    private val binding: FragmentFollowerBinding get() = requireNotNull(_binding){"아직 바인딩 객체 생성되지 않음"}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        saveInstanceState: Bundle?
    ): View {
        _binding = FragmentFollowerBinding.inflate(layoutInflater, container, false)
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
        followerService.request(2)
            .enqueue(object : Callback<FollowerDto> {
            override fun onResponse(
                call: Call<FollowerDto>,
                response: Response<FollowerDto>,
            ) {
                Log.e("서버직전", "서버 : ")

                if (response.isSuccessful) {
                    Log.d("서버", "success")

                    //follower 리스트 생성
                    val data: FollowerDto = response.body()!!
                    val followerAdapter = FollowerAdapter(requireContext())
                    followerAdapter.setFollowerList(data.data)

                    binding.homeRvFollower.adapter = followerAdapter
                }else{
                    Log.d("서버", response.code().toString())
                }

            }

            override fun onFailure(call: Call<FollowerDto>, t: Throwable) {
                Log.d("서버", "fail ${t}" )
            }
        })
    }
}