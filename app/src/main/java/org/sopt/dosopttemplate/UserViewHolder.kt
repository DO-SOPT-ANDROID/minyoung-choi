package org.sopt.dosopttemplate

import androidx.recyclerview.widget.RecyclerView
import org.sopt.dosopttemplate.databinding.ItemUserBinding

class UserViewHolder(private val binding: ItemUserBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(userData: User) {
        binding.ivProfile.setImageResource(userData.profileImage)
        binding.tvUsername.text = userData.nick
    }
}