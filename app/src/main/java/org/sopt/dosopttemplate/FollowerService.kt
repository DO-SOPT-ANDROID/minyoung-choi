package org.sopt.dosopttemplate


import org.sopt.dosopttemplate.follower.FollowerDto
import retrofit2.Call
import retrofit2.http.GET

interface FollowerService {
    @GET("api/users?page=2")
    fun request(): Call<FollowerDto>

}