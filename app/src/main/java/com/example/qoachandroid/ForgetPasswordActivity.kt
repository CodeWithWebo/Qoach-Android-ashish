package com.example.qoachandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import androidx.databinding.DataBindingUtil
import com.example.qoachandroid.databinding.ActivityForgetPasswordBinding
import com.example.qoachandroid.databinding.ActivityUserLoginBinding

class ForgetPasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityForgetPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_forget_password)

        onClick()


    }
    fun onClick(){


    }
}