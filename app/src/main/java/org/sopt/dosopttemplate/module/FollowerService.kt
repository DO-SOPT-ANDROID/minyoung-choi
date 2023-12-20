package org.sopt.dosopttemplate.module


import org.sopt.dosopttemplate.data.dataclass.FollowerDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FollowerService {
    @GET("api/users")
    fun request(
        @Query("page") page: Int
    ): Call<FollowerDto>
}