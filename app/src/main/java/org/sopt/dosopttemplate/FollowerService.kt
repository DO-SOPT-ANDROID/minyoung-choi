package org.sopt.dosopttemplate


import org.sopt.dosopttemplate.follower.FollowerListDto
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FollowerService {
    @GET("api/user?page=2")
    fun request(): Response<FollowerListDto>

}