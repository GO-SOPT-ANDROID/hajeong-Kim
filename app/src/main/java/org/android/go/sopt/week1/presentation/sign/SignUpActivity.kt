package org.android.go.sopt.week1.presentation.sign

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import com.google.android.material.snackbar.Snackbar
import org.android.go.sopt.R
import org.android.go.sopt.databinding.ActivitySignUpBinding
import org.android.go.sopt.week1.data.User
import org.android.go.sopt.week1.utill.BindingActivity

class SignUpActivity : BindingActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initCompleteBtnClickListener()
    }

    private fun isComplete() {
        if (isCheck()) {
            setUser()
            Snackbar.make(binding.root, getString(R.string.signup_complete),Snackbar.LENGTH_SHORT
            ).show()
        } else {
            Snackbar.make(binding.root, getString(R.string.signup_failure),Snackbar.LENGTH_SHORT
            ).show()
        }
    }

    private fun isCheck(): Boolean {
        return binding.etSignUpId.text.length in 6..10 && binding.etSignUpPw.text.length in 8..12
    }

    private fun initCompleteBtnClickListener() {
        binding.btnSignUpComplete.setOnClickListener {
            isComplete()
        }
    }

    private fun setUser() {
        val user = User(
            binding.etSignUpId.text.toString(),
            binding.etSignUpPw.text.toString(),
            binding.etSignUpName.text.toString(),
            binding.etSignUpTalent.text.toString()
        )
        val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
        intent.putExtra(USER, user)
        setResult(RESULT_OK, intent)
        finish()
    }

    companion object {
        const val USER = "user"
    }
}
