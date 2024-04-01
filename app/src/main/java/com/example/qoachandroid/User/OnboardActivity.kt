package com.example.qoachandroid.User

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.example.qoachandroid.R
import com.example.qoachandroid.User.Adapter.ViewPagerAdapter
import com.example.qoachandroid.User.UserActivity.UserHomeActivity
import com.example.qoachandroid.User.UserActivity.UserLoginActivity
import com.example.qoachandroid.Utils.FullScreen
import com.example.qoachandroid.databinding.ActivityOnboardBinding
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class OnboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardBinding
    var viewPagerPosition: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_onboard)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_onboard)
        FullScreen.make(window)


        val dotsIndicator = findViewById<DotsIndicator>(R.id.dots_indicator)
        val viewPager = findViewById<ViewPager>(R.id.viewpager2)
        val adapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapter
        dotsIndicator.attachTo(viewPager)


        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                viewPagerPosition = position
                if (viewPagerPosition < 2) {
//                    binding.tvNext.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.solid_rounded_corner_30dp);
                    binding.tvNext.text = "Next"
                    binding.layoutGetStarted.visibility = View.INVISIBLE
                    binding.layoutNext.visibility = View.VISIBLE
                } else {
//                    binding.tvNext.text = "Get Started"
                    binding.layoutGetStarted.visibility = View.VISIBLE
                    binding.layoutNext.visibility = View.INVISIBLE
                    binding.layoutGetStarted.setOnClickListener{
                        startActivity(Intent(this@OnboardActivity, UserLoginActivity::class.java))
                    }
                }
            }

            override fun onPageSelected(position: Int) {

            }

        })

        Log.d("current", "" + binding.viewpager2.currentItem)
        onClick()
    }

    fun onClick() {

        binding.layoutNext.setOnClickListener {
            if (viewPagerPosition < 2) {
                binding.tvNext.text = "Next"
                binding.viewpager2.currentItem += 1
            } else {

                Log.d("current", "" + viewPagerPosition)
//                binding.tvNext.text = "Get Started"
                if (viewPagerPosition == 2) {
                    binding.layoutGetStarted.visibility = View.VISIBLE
                    binding.layoutNext.visibility = View.INVISIBLE
                    binding.layoutGetStarted.setOnClickListener{
                        startActivity(Intent(this, UserHomeActivity::class.java))
                    }
                }
            }
        }

    }
}