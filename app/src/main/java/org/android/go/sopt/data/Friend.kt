package org.android.go.sopt.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Friend(
    val page: Int,
    val perPage: Int,
    val total: Int,
    val totalPages: Int,
    @SerialName("data")
    val data: List<FriendInfo>
) {
    @Serializable
    data class FriendInfo(
        val id: Int,
        val email: String,
        val firstName: String,
        val lastName: String,
        val avatar: String
    )
}
