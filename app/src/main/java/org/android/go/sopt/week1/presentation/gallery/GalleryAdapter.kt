package org.android.go.sopt.week1.presentation.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.android.go.sopt.data.Friend
import org.android.go.sopt.databinding.ItemGalleryListBinding
import org.android.go.sopt.week1.utill.extensions.ItemDiffCallback

class GalleryAdapter :
    ListAdapter<Friend.FriendInfo, GalleryAdapter.GalleryFriendViewHolder>(
        galleryDiffUtil
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GalleryFriendViewHolder {
        val itemGalleryListBinding =
            ItemGalleryListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return GalleryFriendViewHolder(
            itemGalleryListBinding
        )
    }

    override fun onBindViewHolder(holder: GalleryFriendViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class GalleryFriendViewHolder(private val binding: ItemGalleryListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(friendList: Friend.FriendInfo) {
            binding.data = friendList
        }
    }

    companion object {
        private val galleryDiffUtil = ItemDiffCallback<Friend.FriendInfo>(
            onItemsTheSame = { old, new -> old.id == new.id },
            onContentsTheSame = { old, new -> old == new }
        )
    }
}
