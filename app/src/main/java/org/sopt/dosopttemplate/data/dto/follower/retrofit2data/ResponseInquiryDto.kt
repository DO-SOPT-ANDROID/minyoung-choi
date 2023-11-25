package org.sopt.dosopttemplate.data.dto.follower.retrofit2data

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable

data class ResponseInquiryDto(
    @SerializedName("username")
    val username: String,

    @SerializedName("nickname")
    val nickname: String,
)