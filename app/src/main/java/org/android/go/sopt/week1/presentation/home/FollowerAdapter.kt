package org.android.go.sopt.week1.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.android.go.sopt.data.Follower
import org.android.go.sopt.databinding.ItemHomeBodyBinding
import org.android.go.sopt.databinding.ItemHomeHeaderBinding
import org.android.go.sopt.week1.utill.extensions.ItemDiffCallback

private const val HEADER = 0
private const val BODY = 1

class FollowerAdapter(private val header: Follower.Header) :
    ListAdapter<Follower.FollowerInfo, FollowerAdapter.FollowerViewHolder>(
        followerDiffUtil
    ) {
    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            HEADER
        } else BODY
    }

    abstract class FollowerViewHolder(
        binding: ViewDataBinding
    ) : RecyclerView.ViewHolder(binding.root)

    class BodyViewHolder(private val binding: ItemHomeBodyBinding) :
        FollowerViewHolder(binding) {
        fun onBind(followerInfo: Follower.FollowerInfo) {
            binding.data = followerInfo
        }
    }

    class HeaderViewHolder(binding: ItemHomeHeaderBinding) :
        FollowerViewHolder(binding)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FollowerViewHolder {
        return when (viewType) {
            HEADER -> {
                val itemHomeHeaderBinding = ItemHomeHeaderBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                HeaderViewHolder(itemHomeHeaderBinding)
            }
            else -> {
                val itemHomeBodyBinding =
                    ItemHomeBodyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                BodyViewHolder(itemHomeBodyBinding)
            }
        }
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
        if (holder is BodyViewHolder) {
            holder.onBind(getItem(position))
        }
    }

    companion object {
        private val followerDiffUtil = ItemDiffCallback<Follower.FollowerInfo>(
            onItemsTheSame = { old, new -> old.id == new.id },
            onContentsTheSame = { old, new -> old == new }
        )
    }
}
