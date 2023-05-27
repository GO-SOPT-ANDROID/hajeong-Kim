package org.android.go.sopt.data.Request

import kotlinx.serialization.Serializable

@Serializable
data class SignUpRequest(
    val id: String,
    val pw: String,
    val name: String,
    val talent: String
)
