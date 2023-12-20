package org.sopt.dosopttemplate.data.dataclass

import org.sopt.dosopttemplate.R

data class User(
    val profileImage: Int= R.drawable.pr_image,
    var nick: String="",
    val self_description: String="",
    var id: String="",
    var pw: String="",
    var mbti: String="",

    )
