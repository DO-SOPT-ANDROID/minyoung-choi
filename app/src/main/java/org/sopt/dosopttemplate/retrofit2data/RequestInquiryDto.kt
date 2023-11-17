package org.sopt.dosopttemplate.retrofit2data

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable

data class RequestInquiryDto (
    @SerializedName("id")
    val id:Int,
)