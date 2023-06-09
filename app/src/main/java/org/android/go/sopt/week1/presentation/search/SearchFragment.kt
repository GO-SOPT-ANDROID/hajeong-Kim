package org.android.go.sopt.week1.presentation.search

import android.os.Bundle
import android.view.View
import org.android.go.sopt.R
import org.android.go.sopt.databinding.FragmentSearchBinding
import org.android.go.sopt.week1.utill.binding.BindingFragment

class SearchFragment : BindingFragment<FragmentSearchBinding>(R.layout.fragment_search) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        private const val TAG = "SearchFragment"

        fun newInstance(): SearchFragment {
            return SearchFragment()
        }
    }
}
