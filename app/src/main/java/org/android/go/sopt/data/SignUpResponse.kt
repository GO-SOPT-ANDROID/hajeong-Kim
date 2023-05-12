package org.android.go.sopt.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignUpResponse(
    val status: Int,
    val message: String,
    @SerialName("newUser")
    val data: Data
) {
    @Serializable
    data class Data(
        val name: String,
        val skill: String
    )
}
