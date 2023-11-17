package org.sopt.dosopttemplate

import org.sopt.dosopttemplate.retrofit2data.RequestInquiryDto
import retrofit2.Call
import org.sopt.dosopttemplate.retrofit2data.RequestLoginDto
import org.sopt.dosopttemplate.retrofit2data.RequestSignUpDto
import org.sopt.dosopttemplate.retrofit2data.ResponseInquiryDto
import org.sopt.dosopttemplate.retrofit2data.ResponseLoginDto
import org.sopt.dosopttemplate.retrofit2data.ResponseSignUpDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("api/v1/members/sign-in")
    fun login(
        @Body request: RequestLoginDto,
    ): Call<ResponseLoginDto>

    @POST("api/v1/members")

    fun signUp(
        @Body request: RequestSignUpDto,
    ): Call<ResponseSignUpDto>

    @POST("api/v1/members/{memberId}")

    fun inquiry(
        @Body request: RequestInquiryDto,
    ): Call<ResponseInquiryDto>
}