package org.android.go.sopt.week1.presentation.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.android.go.sopt.data.Friend
import org.android.go.sopt.service.ApiFactory
import org.android.go.sopt.service.FriendService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class GalleryViewModel : ViewModel() {
    private val friendService: FriendService = ApiFactory.friendService

    private val _friendList = MutableLiveData<List<Friend.FriendInfo>>()
    val friendList: LiveData<List<Friend.FriendInfo>> = _friendList

    fun getFriendList(page: Int) {
        friendService.getFriendList(page).enqueue(object : Callback<Friend> {
            override fun onResponse(
                call: Call<Friend>,
                response: Response<Friend>
            ) {
                // get 성공
                if (response.isSuccessful) {
                    Timber.d("서버통신 성공")
                    _friendList.value = response.body()?.data
                }
            }

            override fun onFailure(call: Call<Friend>, t: Throwable) {
                // get 실패(서버통신 오류)
                Timber.d("서버통신 오류")
            }
        })
    }
}
