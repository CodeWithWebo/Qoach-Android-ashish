package com.example.qoachandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.qoachandroid.User.OnboardActivity
import com.example.qoachandroid.Utils.FullScreen
import java.util.Timer
import java.util.TimerTask

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        FullScreen.make(window)

//        task will performed after 2 sec
        Timer().schedule(object : TimerTask(){
            override fun run() {

                startActivity(Intent(this@SplashActivity, OnboardActivity::class.java))
                finishAffinity()

//                val token: String? = AppController(this@SplashActivity).getToken()
//
//                if (token != null){
//                    startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
//                }
//                else{
//                    startActivity(Intent(this@SplashActivity, OnboardingActivity::class.java))
//                }

            }

        }, 2000)
    }
}