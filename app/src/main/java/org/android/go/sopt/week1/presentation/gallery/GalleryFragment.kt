package org.android.go.sopt.week1.presentation.gallery

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import org.android.go.sopt.R
import org.android.go.sopt.databinding.FragmentGalleryBinding
import org.android.go.sopt.week1.utill.binding.BindingFragment

class GalleryFragment : BindingFragment<FragmentGalleryBinding>(R.layout.fragment_gallery) {
    private val galleryViewModel: GalleryViewModel by viewModels()
    private lateinit var galleryAdapter: GalleryAdapter

    override fun onResume() {
        super.onResume()
        galleryViewModel.getFriendList(1)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = galleryViewModel
        initAdapter()
        initFriendListObserve()
    }

    private fun initAdapter() {
        galleryAdapter = GalleryAdapter()
        binding.rvGallery.adapter = galleryAdapter
    }

    private fun initFriendListObserve() {
        galleryViewModel.friendList.observe(viewLifecycleOwner) { friend ->
            galleryAdapter.submitList(friend)
        }
    }

    companion object {
        private const val TAG = "GalleryFragment"

        fun newInstance(): GalleryFragment {
            return GalleryFragment()
        }
    }
}
