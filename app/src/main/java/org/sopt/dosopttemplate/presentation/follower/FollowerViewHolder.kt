package org.sopt.dosopttemplate.presentation.follower

import androidx.recyclerview.widget.RecyclerView
import org.sopt.dosopttemplate.databinding.ItemFollowerBinding
import coil.load
import coil.transform.RoundedCornersTransformation
import org.sopt.dosopttemplate.data.dataclass.Data

class FollowerViewHolder (private val binding: ItemFollowerBinding) : RecyclerView.ViewHolder(binding.root){

        fun onBind(FollowerData: Data) =with(binding){
//프사 이미지 로딩 손봐야됨
            homeFollowerIvProfile.load(FollowerData.avatar) {
                transformations(RoundedCornersTransformation(10.0F))}
            homeFollowerTvName.text = FollowerData.first_name+FollowerData.last_name
            homeFollowerTvUserMail.text=FollowerData.email
        }
}