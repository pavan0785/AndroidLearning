package com.example.androidlearning.activity

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidlearning.R
import com.example.androidlearning.model.UserInfo

class SecondActivity : AppCompatActivity() {
    lateinit var tvDisplay: TextView
    lateinit var tvMob: TextView

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        tvDisplay = findViewById(R.id.tv_display)
        tvMob = findViewById(R.id.tv_mob)
        val myIntent = intent
//        val fName = myIntent.getStringExtra("fname")
//        val lName = myIntent.getStringExtra("lname")

//        try {
//            val userInfo = myIntent.getSerializableExtra("userInfo") as UserInfo
//            val fName = userInfo!!.userFname
//            val lName = userInfo!!.userLName
//            tvDisplay.text = fName+" "+lName
//        }catch (exp: Exception){
//            Toast.makeText(this, exp.toString(), Toast.LENGTH_SHORT).show()
//        }

        val bundle = myIntent.getBundleExtra("myBundle")
        val fName = bundle!!.getString("fname")
        val lName = bundle!!.getString("lname")
        val mobNo = bundle.getLong("mob")
        tvDisplay.text = fName+" "+lName
        tvMob.text = mobNo.toString()

//        Log.d("TAG", fName+" "+lName+"\n"+mobNo)


    }
}