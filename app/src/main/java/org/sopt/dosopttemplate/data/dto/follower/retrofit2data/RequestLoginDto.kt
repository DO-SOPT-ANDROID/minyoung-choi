package org.sopt.dosopttemplate.data.dto.follower.retrofit2data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestLoginDto (
    @SerialName("username")
    val username: String,

    @SerialName("password")
    val password: String,
)