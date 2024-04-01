package com.example.qoachandroid.User.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.qoachandroid.User.Fragment.OnboardFragment1
import com.example.qoachandroid.User.Fragment.OnboardFragment2
import com.example.qoachandroid.User.Fragment.OnboardFragment3

class ViewPagerAdapter(fragmentManager : FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    private val fragments = listOf(
        OnboardFragment1(), OnboardFragment2(), OnboardFragment3()
    )

    override fun getCount(): Int {
      return fragments.size
    }

    override fun getItem(position: Int): Fragment {
       return fragments[position]
    }
}