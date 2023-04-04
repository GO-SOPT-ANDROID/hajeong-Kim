package org.android.go.sopt.week1.presentation.sign

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar
import org.android.go.sopt.R
import org.android.go.sopt.databinding.ActivitySignInBinding
import org.android.go.sopt.week1.data.User
import org.android.go.sopt.week1.presentation.profile.ProfileActivity
import org.android.go.sopt.week1.utill.BindingActivity
import org.android.go.sopt.week1.utill.getParcelable

class SignInActivity : BindingActivity<ActivitySignInBinding>(R.layout.activity_sign_in) {
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initLoginBtnClickListener()
        initSignUpBtnClickListener()
        setSignUp()
    }

    private fun initLoginBtnClickListener() {
        binding.btnSignInLogin.setOnClickListener {
            if (isSuccessSignIn()) {
                goToProfile()
            } else {
                Snackbar.make(
                    binding.root,
                    "로그인 실패했습니다.",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun initSignUpBtnClickListener() {
        binding.btnSignInSignUp.setOnClickListener {
            val signUpIntent = Intent(this, SignUpActivity::class.java)
            resultLauncher.launch(signUpIntent)
        }
    }

    private fun goToProfile() {
        startActivity(Intent(this, ProfileActivity::class.java))
        finish()
    }

    private fun setSignUp() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    if (result.data?.hasExtra("user") == true) {
                        Snackbar.make(
                            binding.root,
                            "회원가입에 성공했습니다.",
                            Snackbar.LENGTH_SHORT
                        ).show()
                        user = result.data?.getParcelable(USER, User::class.java)
                    }
                    with(binding) {
                        etSignInId.setText(user?.id)
                        etSignInPw.setText(user?.pw)
                    }
                }
            }
    }

    private fun isSuccessSignIn(): Boolean {
        return binding.etSignInId.text.toString() == user?.id && binding.etSignInPw.text.toString() == user?.pw
    }

    companion object {
        const val USER = "user"
    }
}
