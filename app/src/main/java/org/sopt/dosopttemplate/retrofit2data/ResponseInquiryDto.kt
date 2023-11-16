package org.sopt.dosopttemplate.retrofit2data

import com.google.gson.annotations.SerializedName

class ResponseInquiryDto(
    @SerializedName("username")
    val username: String,

    @SerializedName("nickname")
    val nickname: String,
)