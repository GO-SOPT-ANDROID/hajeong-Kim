package org.android.go.sopt.data

import kotlinx.serialization.Serializable

@Serializable
data class SignInResponse(
    val status: Int,
    val message: String,
    val data: Data
) {
    @Serializable
    data class Data(
        val id: String,
        val name: String,
        val skill: String
    )
}
