package org.android.go.sopt.week1.presentation.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar
import org.android.go.sopt.R
import org.android.go.sopt.databinding.ActivityLoginBinding
import org.android.go.sopt.week1.data.UserInfo
import org.android.go.sopt.week1.presentation.signUp.SignUpActivity
import org.android.go.sopt.week1.utill.BindingActivity
import org.android.go.sopt.week1.utill.getParcelable

class LoginActivity : BindingActivity<ActivityLoginBinding>(R.layout.activity_login) {
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private var id: String? = null
    private var pw: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initLoginBtnClickListener()
        initSignUpBtnClickListener()
    }

    private fun initLoginBtnClickListener() {
        binding.btnMainLogin.setOnClickListener {
            if (binding.etMainId.text.toString() == id && binding.etMainId.text.toString() == pw) {
                Snackbar.make(binding.root, "로그인에 성공했습니다.", Snackbar.LENGTH_SHORT).show()
                finish()
            } else {
                Snackbar.make(binding.root, "다시 확인해주세요.", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    private fun initSignUpBtnClickListener() {
        startActivity(Intent(this, SignUpActivity::class.java))
    }

    private fun setSignUpResult() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode != Activity.RESULT_OK) return@registerForActivityResult
                val data = result.data ?: return@registerForActivityResult

                val userInfo = data.getParcelable(USER_INFO, UserInfo::class.java)
            }
    }

    companion object {
        const val USER_INFO = "userInfo"
    }
}
