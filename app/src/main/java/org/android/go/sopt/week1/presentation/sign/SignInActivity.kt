package org.android.go.sopt.week1.presentation.sign

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar
import org.android.go.sopt.R
import org.android.go.sopt.data.Request.SignInRequest
import org.android.go.sopt.data.SignInResponse
import org.android.go.sopt.data.User
import org.android.go.sopt.databinding.ActivitySignInBinding
import org.android.go.sopt.service.ApiFactory
import org.android.go.sopt.week1.presentation.MainActivity
import org.android.go.sopt.week1.presentation.profile.ProfileActivity
import org.android.go.sopt.week1.utill.binding.BindingActivity
import org.android.go.sopt.week1.utill.getParcelable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

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
                postSignIn()
                goToProfile()
            } else {
                Snackbar.make(
                    binding.root,
                    getString(R.string.signin_failure),
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
                    if (result.data?.hasExtra(USER) == true) {
                        Snackbar.make(
                            binding.root,
                            getString(R.string.signin_complete),
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

    private fun postSignIn() {
        val id = binding.etSignInId.text.toString()
        val password = binding.etSignInPw.text.toString()

        val signInRequest = SignInRequest(id, password)
        val signInService: Call<SignInResponse> = ApiFactory.signService.postSignIn(signInRequest)

        signInService.enqueue(object : Callback<SignInResponse> {
            override fun onResponse(
                call: Call<SignInResponse>,
                response: Response<SignInResponse>
            ) {
                if (response.isSuccessful) {
                    Toast.makeText(this@SignInActivity, "로그인 성공", Toast.LENGTH_SHORT)
                        .show()

                    val intent = Intent(this@SignInActivity, MainActivity::class.java).apply {
                        putExtra("id", response.body()?.data?.id)
                    }
                    startActivity(intent) // 화면전환
                    finish()
                }
                // 로그인 실패
                else {
                    Toast.makeText(this@SignInActivity, "로그인 실패", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<SignInResponse>, t: Throwable) {
                // 서버통신 오류
                Timber.d("$t")
                Toast.makeText(this@SignInActivity, "에러 발생", Toast.LENGTH_SHORT).show()
            }
        })
    }

    companion object {
        const val USER = "user"
    }
}
