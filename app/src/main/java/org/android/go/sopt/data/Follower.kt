package org.android.go.sopt.data

data class Follower(
    val followers: List<FollowerInfo>,
    val header: Header
) {
    data class FollowerInfo(
        val id: Int,
        val repo: String? = "No Repository",
        val nickname: String,
        val profileImage: String
    )

    data class Header(
        val header: String = "hajeong's repository"
    )
}
