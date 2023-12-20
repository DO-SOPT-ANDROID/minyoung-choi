package org.sopt.dosopttemplate.presentation.mypage

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.dosopttemplate.data.dataclass.User
import org.sopt.dosopttemplate.databinding.ItemUserBinding

class UserAdapter(context: Context) : RecyclerView.Adapter<UserViewHolder>() {
    private val inflater by lazy {
        LayoutInflater.from(context)
    }

    //로그인한 유저의 프로필 담을 곳 생성
    private var UserInfo: List<User> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(inflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.onBind(UserInfo[position])
    }

    override fun getItemCount(): Int = UserInfo.size

    fun setUserList(userInfo: List<User>) {
        this.UserInfo = userInfo.toList()
        notifyDataSetChanged()
    }
}