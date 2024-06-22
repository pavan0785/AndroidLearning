package com.example.androidlearning

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity: AppCompatActivity(), View.OnClickListener {
    lateinit var btnClick: Button
    lateinit var tvDisplay: TextView
    var initValue: Int = 0
    lateinit var etInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnClick = findViewById(R.id.btn_click)
        tvDisplay = findViewById(R.id.tv_display)
        etInput = findViewById(R.id.et_input)

//        tvDisplay.text = initValue.toString()

        btnClick.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
//        Log.d("TAG", "Youo have clicked me")
//        Toast.makeText(this@MainActivity, "You clicked me", Toast.LENGTH_SHORT).show()
//        initValue = initValue + 1
//        initValue++
//        tvDisplay.text = "You have clicked me"
//        tvDisplay.text = initValue.toString()
        tvDisplay.text = etInput.text.toString()
    }
}