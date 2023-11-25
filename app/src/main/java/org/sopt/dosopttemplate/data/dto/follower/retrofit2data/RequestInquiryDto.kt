package org.sopt.dosopttemplate.data.dto.follower.retrofit2data

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable

data class RequestInquiryDto (
    @SerializedName("id")
    val id:Int,
)