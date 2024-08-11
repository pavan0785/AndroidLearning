package com.example.androidlearning.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.androidlearning.activity.fragments.Fragment2
import com.example.androidlearning.activity.fragments.Fragment_1
import com.example.androidlearning.activity.fragments.Fragment_3

class ViewpagerAdapter(private val fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> Fragment_1()
            1 -> Fragment2()
            else -> Fragment_3()
        }
    }
}