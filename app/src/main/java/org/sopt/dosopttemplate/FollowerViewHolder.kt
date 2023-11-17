package org.sopt.dosopttemplate

import androidx.recyclerview.widget.RecyclerView
import org.sopt.dosopttemplate.databinding.ItemFollowerBinding
import org.sopt.dosopttemplate.follower.FollowerDto

class FollowerViewHolder (private val binding: ItemFollowerBinding) : RecyclerView.ViewHolder(binding.root){

        fun onBind(FollowerData: FollowerDto) =with(binding){
//프사 이미지 로딩 손봐야됨
            homeFollowerIvProfile.load(item.avatar) {
            homeFollowerIvProfile.setImageResource(FollowerData.avatar)
                ///
            homeFollowerTvName.text = FollowerData.first_name+FollowerData.last_name
            homeFollowerTvUserMail.text=FollowerData.email
        }
}