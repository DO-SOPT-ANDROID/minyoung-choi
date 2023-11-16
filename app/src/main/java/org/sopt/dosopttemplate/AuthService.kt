package org.sopt.dosopttemplate

import retrofit2.Call
import org.sopt.dosopttemplate.retrofit2data.RequestLoginDto
import org.sopt.dosopttemplate.retrofit2data.ResponseLoginDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("api/v1/members/sign-in")
    fun login(
        @Body request: RequestLoginDto,
    ): Call<ResponseLoginDto>
}