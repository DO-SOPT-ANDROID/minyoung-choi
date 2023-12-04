package org.sopt.dosopttemplate.module

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.sopt.dosopttemplate.BuildConfig
import retrofit2.Retrofit

object ApiFactory {
    private const val BASE_URL = BuildConfig.AUTH_BASE_URL

    private fun getLogOkHttpClient(): Interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(getLogOkHttpClient())
        .build()
    val retrofit: Retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    val reqresFollower: Retrofit by lazy{
        Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }
    inline fun <reified T> create(): T = retrofit.create<T>(T::class.java)
    inline fun <reified T> createFollower(): T = reqresFollower.create<T>(T::class.java)

}
object ServicePool {
    val authService = ApiFactory.create<AuthService>()
    val followerService= ApiFactory.createFollower<FollowerService>()
}