package org.android.go.sopt.week1.presentation.sign

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import org.android.go.sopt.R
import org.android.go.sopt.data.Request.SignUpRequest
import org.android.go.sopt.data.SignUpResponse
import org.android.go.sopt.data.User
import org.android.go.sopt.databinding.ActivitySignUpBinding
import org.android.go.sopt.service.ApiFactory
import org.android.go.sopt.week1.utill.binding.BindingActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class SignUpActivity : BindingActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initCompleteBtnClickListener()
    }

    private fun isCheck(): Boolean {
        return binding.etSignUpId.text.length in 6..10 && binding.etSignUpPw.text.length in 8..12
    }

    private fun isComplete() {
        val id = binding.etSignUpId.text.toString()
        val password = binding.etSignUpPw.text.toString()
        val name = binding.etSignUpName.text.toString()
        val talent = binding.etSignUpTalent.text.toString()

        val signUpRequest = SignUpRequest(id, password, name, talent) // SignInRequest 인스턴스 생성

        val signupService: Call<SignUpResponse> = ApiFactory.signService.postSignUp(signUpRequest)

        signupService.enqueue(object : Callback<SignUpResponse> {
            override fun onResponse(
                call: Call<SignUpResponse>,
                response: Response<SignUpResponse>
            ) {
                if (isCheck()) {
                    setUser()
                    Snackbar.make(
                        binding.root,
                        getString(R.string.signup_complete),
                        Snackbar.LENGTH_SHORT
                    ).show()
                } else {
                    Snackbar.make(
                        binding.root,
                        getString(R.string.signup_failure),
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                // 서버통신 오류
                Timber.d("$t")
                Toast.makeText(this@SignUpActivity, "에러 발생", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun initCompleteBtnClickListener() {
        binding.btnSignUpComplete.setOnClickListener {
        }
        isComplete()
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
