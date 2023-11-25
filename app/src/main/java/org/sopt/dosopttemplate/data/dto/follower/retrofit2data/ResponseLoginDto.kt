package org.sopt.dosopttemplate.data.dto.follower.retrofit2data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable

data class ResponseLoginDto(
    @SerialName("id")
    val id: Int,
    @SerialName("username")
    val username: String,
    @SerialName("nickname")
    val nickname: String,

    )