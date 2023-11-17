package org.sopt.dosopttemplate.follower

data class followerListDto(
    val `data`: List<Data>,
    val page: Int,
    val per_page: Int,
    val support: SupportX,
    val total: Int,
    val total_pages: Int
)