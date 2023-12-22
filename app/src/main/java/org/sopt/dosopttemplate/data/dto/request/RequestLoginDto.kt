package org.sopt.dosopttemplate.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestLoginDto (
    @SerialName("username")
    var username: String,

    @SerialName("password")
    var password: String,
)