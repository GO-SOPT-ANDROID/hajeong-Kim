package org.android.go.sopt.service

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object ApiFactory {
    private val soptRetrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://52.78.152.187:8080/")
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }
    private val reqresRetrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    val signService: SignService = soptRetrofit.create(SignService::class.java)
    val friendService: FriendService = reqresRetrofit.create(FriendService::class.java)
}
