package com.example.androidlearning.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidlearning.R
import com.example.androidlearning.model.UserInfo

class ExpIntentActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var btnSubmit: Button
    lateinit var etFname: EditText
    lateinit var etLname: EditText
    lateinit var etMobile: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exp_intent_activty)
        btnSubmit = findViewById(R.id.btn_submit)
        etFname = findViewById(R.id.et_fname)
        etLname = findViewById(R.id.et_lname)
        etMobile = findViewById(R.id.et_mob)
        btnSubmit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent(this@ExpIntentActivity, SecondActivity::class.java)
//        intent.putExtra("fname", etFname.text.toString())
//        intent.putExtra("lname", etLname.text.toString())

//        val userInfo = UserInfo(etFname.text.toString(), etLname.text.toString())
//        intent.putExtra("userInfo", userInfo)

        val bundle = Bundle()
        bundle.putString("fname", etFname.text.toString())
        bundle.putString("lname", etLname.text.toString())
        bundle.putLong("mob", etMobile.text.toString().toLong())
        intent.putExtra("myBundle", bundle)

        startActivity(intent)

    }
}