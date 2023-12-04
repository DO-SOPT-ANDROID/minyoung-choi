package org.sopt.dosopttemplate.data.dto.request

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable

data class RequestInquiryDto (
    @SerializedName("id")
    val id:Int,
)