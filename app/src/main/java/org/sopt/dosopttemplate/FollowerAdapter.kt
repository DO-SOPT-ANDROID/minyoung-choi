package org.sopt.dosopttemplate

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.dosopttemplate.databinding.ItemFollowerBinding
import org.sopt.dosopttemplate.follower.FollowerDto

class FollowerAdapter(context: Context) : RecyclerView.Adapter<FollowerViewHolder>() {
    private val inflater by lazy {
        LayoutInflater.from(context)
    }

    //로그인한 유저의 프로필 담을 곳 생성
    private var FollowerInfo: List<FollowerDto> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerViewHolder {
        val binding = ItemFollowerBinding.inflate(inflater, parent, false)
        return FollowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
        holder.onBind(FollowerInfo[position])
    }

    override fun getItemCount(): Int = FollowerInfo.size

    fun setFollowerList(followerDtoInfo: List<FollowerDto>) {
        this.FollowerInfo = followerDtoInfo.toList()
        notifyDataSetChanged()
    }

}