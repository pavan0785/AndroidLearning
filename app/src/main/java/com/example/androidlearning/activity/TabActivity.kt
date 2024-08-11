package com.example.androidlearning.activity

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentActivity
import com.example.androidlearning.R
import com.example.androidlearning.adapter.ViewpagerAdapter
import com.example.androidlearning.databinding.ActivityTabBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TabActivity : AppCompatActivity(), TabLayout.OnTabSelectedListener {
    lateinit var binding: ActivityTabBinding
    var tabName = arrayOf("One", "Two", "Three")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPagerAdapter = ViewpagerAdapter(this@TabActivity)
        binding.viewPager.adapter = viewPagerAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager){tab, position ->
            when(position){
                0 -> {
                    tab.text = tabName[0]
                    tab.view.setBackgroundColor(Color.CYAN)
                }

                1 ->{
                    tab.text = tabName[1]
                }

                2 ->{
                    tab.text = tabName[2]
                }
            }

        }.attach()
        binding.tabLayout.addOnTabSelectedListener(this)
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        tab!!.view.setBackgroundColor(Color.CYAN)
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
        tab!!.view.setBackgroundColor(Color.WHITE)
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {

    }


}