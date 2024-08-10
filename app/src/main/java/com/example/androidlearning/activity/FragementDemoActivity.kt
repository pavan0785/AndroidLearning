package com.example.androidlearning.activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import com.example.androidlearning.R
import com.example.androidlearning.activity.fragments.Fragment2
import com.example.androidlearning.activity.fragments.Fragment_1
import com.example.androidlearning.databinding.ActivityFragementDemoBinding

class FragementDemoActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityFragementDemoBinding
    lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragementDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragmentManager = supportFragmentManager

        binding.btnAdd.setOnClickListener(this)
        binding.btnRemove.setOnClickListener(this)
        binding.btnReplace.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when(view!!.id){
            R.id.btn_add ->{
                val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.setReorderingAllowed(true)
                fragmentTransaction.add(R.id.fragContainView, Fragment_1())
                fragmentTransaction.commit()
            }

            R.id.btn_remove ->{
                val fragTransaction = fragmentManager.beginTransaction()
                if (fragmentManager.fragments.size > 0){
                    for (fragment in fragmentManager.fragments){
                        fragTransaction.remove(fragment)
                        fragTransaction.commit()
                    }
                }
            }

            R.id.btn_replace ->{
                val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.setReorderingAllowed(true)
                fragmentTransaction.replace(R.id.fragContainView, Fragment2())
                fragmentTransaction.commit()
            }
        }
    }
}