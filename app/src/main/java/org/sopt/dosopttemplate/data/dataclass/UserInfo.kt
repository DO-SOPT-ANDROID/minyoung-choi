package org.sopt.dosopttemplate.data.dataclass

object UserInfo {
    var userInfoList = User(
        nick = "",
        self_description = "",
        id = "",
        pw = "",
        mbti = "",
    )

    fun toUser(inId: String, inPw: String) {
        userInfoList.id = inId
        userInfoList.pw = inPw
    }
}