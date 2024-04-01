package com.example.qoachandroid.User.UserActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import androidx.databinding.DataBindingUtil
import com.example.qoachandroid.ForgetPasswordActivity
import com.example.qoachandroid.R
import com.example.qoachandroid.SignUpActivity
import com.example.qoachandroid.databinding.ActivityUserLoginBinding

class UserLoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserLoginBinding

    private var isPasswordHide: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_login)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_login)

        onClick()


    }
    fun onClick(){
        binding.imgEye.setOnClickListener{
            if (isPasswordHide) {
                isPasswordHide = false
                binding.editPassword.setInputType(InputType.TYPE_CLASS_TEXT)
                binding.editPassword.setSelection(binding.editPassword.getText()!!.length)
            } else {
                isPasswordHide = true
                binding.editPassword.setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
                binding.editPassword.setSelection(binding.editPassword.getText()!!.length)
            }
        }

        binding.txtSignup.setOnClickListener{
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        binding.txtForgetPassword.setOnClickListener{
            startActivity(Intent(this, ForgetPasswordActivity::class.java))
        }

        binding.btnLogin.setOnClickListener{
            startActivity(Intent(this, UserHomeActivity::class.java))
        }



    }

}