package org.sopt.dosopttemplate.retrofit2data

import kotlinx.serialization.SerialName

class ResponseLoginDto(
    @SerialName("id")
    val id: Int,
    @SerialName("username")
    val username: String,
    @SerialName("password")
    val password: String,

    )