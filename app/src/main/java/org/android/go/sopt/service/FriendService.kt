package org.android.go.sopt.service

import org.android.go.sopt.data.Friend
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FriendService {
    @GET("api/users")
    fun getFriendList(@Query("page") page: Int): Call<Friend>
}
