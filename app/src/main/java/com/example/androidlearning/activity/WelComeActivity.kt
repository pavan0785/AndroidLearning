package com.example.androidlearning.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidlearning.R
import com.example.androidlearning.databinding.ActivityWelComeBinding

class WelComeActivity : AppCompatActivity() {
    lateinit var binding: ActivityWelComeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelComeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val myIntent = intent
        var fName = myIntent.getStringExtra("p1")
        var lName = myIntent.getStringExtra("p2")
        binding.tvName.text = "Hello, $fName $lName"
    }
}