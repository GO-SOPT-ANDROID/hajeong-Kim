package org.android.go.sopt.week1.presentation.profile

import android.os.Bundle
import org.android.go.sopt.R
import org.android.go.sopt.databinding.ActivityProfileBinding
import org.android.go.sopt.week1.utill.BindingActivity

class ProfileActivity : BindingActivity<ActivityProfileBinding>(R.layout.activity_profile) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
