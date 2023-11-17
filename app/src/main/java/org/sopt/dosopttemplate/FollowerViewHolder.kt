package org.sopt.dosopttemplate

import androidx.recyclerview.widget.RecyclerView
import org.sopt.dosopttemplate.databinding.ItemFollowerBinding
import org.sopt.dosopttemplate.retrofit2data.ResponseLoginDto

class FollowerViewHolder (private val binding: ItemFollowerBinding) : RecyclerView.ViewHolder(binding.root){

        fun onBind(FollowerData: Follower) =with(binding){
            //여기다가 무슨값 어디에 넣어주는 그거
            homeFollowerIvProfile.setImageResource(FollowerData.profileImage)
            homeFollowerTvName.text = FollowerData.name
            homeFollowerTvUserMail.text=FollowerData.email
        }
}