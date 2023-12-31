package org.sopt.dosopttemplate.module

import org.sopt.dosopttemplate.data.dto.request.RequestLoginDto
import org.sopt.dosopttemplate.data.dto.request.RequestSignUpDto
import org.sopt.dosopttemplate.data.dto.request.RequestUserDataDto
import org.sopt.dosopttemplate.data.dto.response.ResponseLoginDto
import retrofit2.Call
import org.sopt.dosopttemplate.data.dto.response.ResponseUserDataDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AuthService {

    @POST("api/v1/members/sign-in")
    fun postLogin(
        @Body request: RequestLoginDto,
    ): Call<ResponseLoginDto>

    @POST("api/v1/members")
    fun signUp(
        @Body request: RequestSignUpDto,
    ): Call<Unit>

    @GET("api/v1/members/{memberId}")
    fun getUserInfo(
        @Path("memberId") memberId: Int
    ): Call<ResponseUserDataDto>
}