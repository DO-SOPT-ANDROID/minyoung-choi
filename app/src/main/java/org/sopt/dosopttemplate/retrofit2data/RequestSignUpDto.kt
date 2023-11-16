package org.sopt.dosopttemplate.retrofit2data

import com.google.gson.annotations.SerializedName

class RequestSignUpDto(
    @SerializedName("username")
    val username: String,

    @SerializedName("password")
    val password: String,

    @SerializedName("nickname")
    val nickname: String,
)