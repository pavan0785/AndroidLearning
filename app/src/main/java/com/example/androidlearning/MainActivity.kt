package com.example.androidlearning

import android.os.Bundle
import android.telephony.TelephonyCallback.UserMobileDataStateListener
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity: AppCompatActivity(), View.OnClickListener {
    lateinit var btnClick: Button
    var initValue: Int = 0
    lateinit var etFname: EditText
    lateinit var etMname: EditText
    lateinit var etLname: EditText
    lateinit var etEmailid: EditText
    lateinit var etMobile: EditText
    lateinit var tvDisplay1: TextView
    lateinit var tvDisplay2: TextView
    lateinit var tvDisplay3: TextView
    lateinit var tvDisplay4: TextView
    lateinit var tvDisplay5: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnClick = findViewById(R.id.btn_click)
        etFname = findViewById(R.id.et_input1)
        etMname = findViewById(R.id.et_input2)
        etLname = findViewById(R.id.et_input3)
        etEmailid = findViewById(R.id.et_input4)
        etMobile = findViewById(R.id.et_input5)
        tvDisplay1 = findViewById(R.id.tv_display1)
        tvDisplay2 = findViewById(R.id.tv_display2)
        tvDisplay3 = findViewById(R.id.tv_display3)
        tvDisplay4 = findViewById(R.id.tv_display4)
        tvDisplay5 = findViewById(R.id.tv_display5)


        //   tvDisplay.text = initValue.toString()

        btnClick.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
//        Log.d("TAG", "Youo have clicked me")
//        Toast.makeText(this@MainActivity, "You clicked me", Toast.LENGTH_SHORT).show()
//        initValue = initValue + 1
//        initValue++
//        tvDisplay.text = "You have clicked me"
//        tvDisplay.text = initValue.toString()
          tvDisplay1.text = etFname.text.toString()
          tvDisplay2.text = etMname.text.toString()
          tvDisplay3.text = etLname.text.toString()
          tvDisplay4.text = etEmailid.text.toString()
          tvDisplay5.text = etMobile.text.toString()    }
}