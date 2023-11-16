package org.sopt.dosopttemplate

import retrofit2.Call
import org.sopt.dosopttemplate.retrofit2data.RequestLoginDto
import org.sopt.dosopttemplate.retrofit2data.RequestSignUpDto
import org.sopt.dosopttemplate.retrofit2data.ResponseLoginDto
import org.sopt.dosopttemplate.retrofit2data.ResponseSignUpDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("api/v1/members/sign-in")
    fun login(
        @Body request: RequestLoginDto,
    ): Call<ResponseLoginDto>

    fun signUp(
        @Body request: RequestSignUpDto,
    ):Call<ResponseSignUpDto>
}