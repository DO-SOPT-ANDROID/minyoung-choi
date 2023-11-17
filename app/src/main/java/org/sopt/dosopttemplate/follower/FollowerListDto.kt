package org.sopt.dosopttemplate.follower

import com.google.gson.annotations.SerializedName

data class FollowerListDto(
    @SerializedName("data")
    val `data`: List<FollowerDto>,
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val per_page: Int,
    @SerializedName("support")
    val support: SupportX,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_pages")
    val total_pages: Int
)