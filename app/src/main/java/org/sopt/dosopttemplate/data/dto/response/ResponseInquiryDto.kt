package org.sopt.dosopttemplate.data.dto.response

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable

data class ResponseInquiryDto(
    @SerializedName("username")
    val username: String,

    @SerializedName("nickname")
    val nickname: String,
)