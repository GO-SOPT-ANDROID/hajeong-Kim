package org.android.go.sopt.week1.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import org.android.go.sopt.R
import org.android.go.sopt.databinding.ActivityMainBinding
import org.android.go.sopt.week1.presentation.gallery.GalleryFragment
import org.android.go.sopt.week1.presentation.home.HomeFragment
import org.android.go.sopt.week1.presentation.search.SearchFragment
import org.android.go.sopt.week1.utill.binding.BindingActivity

class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initTransactionEvent()
    }

    private fun initTransactionEvent() {
        binding.bnvMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    changeFragment(HomeFragment.newInstance())
                }
                R.id.menu_gallery -> {
                    changeFragment(GalleryFragment.newInstance())
                }
                R.id.menu_search -> {
                    changeFragment(SearchFragment.newInstance())
                }
            }
            true
        }
        binding.bnvMain.selectedItemId = R.id.menu_home
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fcv_main, fragment)
            .commit()
    }
}
