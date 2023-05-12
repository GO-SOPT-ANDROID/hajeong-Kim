package org.android.go.sopt.data.Request

import kotlinx.serialization.Serializable

@Serializable
data class SignInRequest(
    val id: String,
    val password: String
)
