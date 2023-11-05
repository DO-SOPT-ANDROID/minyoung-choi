package org.sopt.dosopttemplate

import androidx.lifecycle.ViewModel

class MainHomeViewModel : ViewModel() {
    //viewModel에 친구 리스트 저장
    val mockFriendList = listOf<Friend>(
        Friend(
            profileImage = R.drawable.pr_image,
            name = "친구1",
            self_description = "상태창1",
        ),
        Friend(
            profileImage = R.drawable.pr_image,
            name = "친구2",
            self_description = "상태창2",
        ),
        Friend(
            profileImage = R.drawable.pr_image,
            name = "친구3",
            self_description = "상태창3",
        ),
        Friend(
            profileImage = R.drawable.pr_image,
            name = "친구4",
            self_description = "상태창4",
        ),
        Friend(
            profileImage = R.drawable.pr_image,
            name = "친구5",
            self_description = "상태창5",
        ),
        Friend(
            profileImage = R.drawable.pr_image,
            name = "친구6",
            self_description = "상태창6",
        ),
        Friend(
            profileImage = R.drawable.pr_image,
            name = "친구7",
            self_description = "상태창7",
        ),
        Friend(
            profileImage = R.drawable.pr_image,
            name = "친구8",
            self_description = "상태창8",
        ),
        Friend(
            profileImage = R.drawable.pr_image,
            name = "친구9",
            self_description = "상태창9",
        ),
        Friend(
            profileImage = R.drawable.pr_image,
            name = "친구10",
            self_description = "상태창10",
        ),
    )

}