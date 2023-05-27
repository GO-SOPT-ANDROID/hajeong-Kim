package org.android.go.sopt.service

import org.android.go.sopt.data.Request.SignInRequest
import org.android.go.sopt.data.Request.SignUpRequest
import org.android.go.sopt.data.SignInResponse
import org.android.go.sopt.data.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignService {
    @POST("sign-in")
    fun postSignIn(@Body body: SignInRequest): Call<SignInResponse>

    @POST("sign-up")
    fun postSignUp(@Body body: SignUpRequest): Call<SignUpResponse>
}
