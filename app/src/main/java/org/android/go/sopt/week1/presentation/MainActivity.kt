package org.android.go.sopt.week1.presentation

import android.os.Bundle
import org.android.go.sopt.R
import org.android.go.sopt.databinding.ActivityMainBinding
import org.android.go.sopt.week1.presentation.gallery.GalleryFragment
import org.android.go.sopt.week1.presentation.home.HomeFragment
import org.android.go.sopt.week1.presentation.search.SearchFragment
import org.android.go.sopt.week1.utill.BindingActivity

class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
        initTransactionEvent()
    }

    private fun initView() {
        supportFragmentManager.beginTransaction()
            .add(R.id.cv_main_home, HomeFragment())
            .commit()
    }

    private fun initTransactionEvent() {
        binding.bnvHome.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    changeFragment(homeFragment)
                }
                R.id.menu_gallery -> {
                    changeFragment(galleryFragment)
                }
                R.id.menu_search -> {
                    changeFragment(searchFragment)
                }
            }
            true
        }
        binding.bnvHome.selectedItemId = R.id.menu_home
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.home_container, fragment)
            .commit()
    }
}
