package org.sopt.dosopttemplate

import androidx.annotation.DrawableRes

data class Friend(
    //(val type: Int, val text:String, val data:Int, val contentString: String?) {

//    companion object{
//        const val TEXT_TYPE=0
//        const val IMAGE_TYPE=1
//        const val IMAGE_TYPE_2=2
//    }
    val profileImage: Int,
    val name: String,
    val self_description: String,
)