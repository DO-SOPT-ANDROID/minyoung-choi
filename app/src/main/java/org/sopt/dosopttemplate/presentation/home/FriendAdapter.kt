package org.sopt.dosopttemplate.presentation.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.dosopttemplate.Friend
import org.sopt.dosopttemplate.FriendViewHolder
import org.sopt.dosopttemplate.databinding.ItemFriendBinding

class FriendAdapter(context: Context) : RecyclerView.Adapter<FriendViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }

    // 임시의 빈 리스트
    private var FriendList: List<Friend> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val binding = ItemFriendBinding.inflate(inflater, parent, false)
        return FriendViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        holder.onBind(FriendList[position])
    }

    override fun getItemCount() = FriendList.size

    fun setFriendList(friendList: List<Friend>) {
        this.FriendList = friendList.toList()
        notifyDataSetChanged()
    }
}