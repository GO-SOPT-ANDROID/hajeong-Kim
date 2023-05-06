package org.android.go.sopt.week1.utill.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("setImage")
    fun ImageView.setImage(imgUrl: String?) {
        this.let {
            Glide.with(context)
                .load(imgUrl)
                .into(this)
        }
    }

    @JvmStatic
    @BindingAdapter("setCircleImage")
    fun ImageView.setCircleImage(imgUrl: String?) {
        this.let {
            Glide.with(context)
                .load(imgUrl)
                .circleCrop()
                .into(this)
        }
    }

    @JvmStatic
    @BindingAdapter("setImageResource")
    fun ImageView.setImageResource(resId: Int) {
        setImageResource(resId)
    }
}
