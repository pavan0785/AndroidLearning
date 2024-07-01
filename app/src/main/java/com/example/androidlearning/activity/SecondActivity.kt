package com.example.androidlearning.activity

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidlearning.R

class SecondActivity : AppCompatActivity() {
    lateinit var tvDisplay: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        tvDisplay = findViewById(R.id.tv_display)
        val myIntent = intent
        val fName = myIntent.getStringExtra("fname")
        val lName = myIntent.getStringExtra("lname")

        tvDisplay.text = fName+" "+lName

    }
}