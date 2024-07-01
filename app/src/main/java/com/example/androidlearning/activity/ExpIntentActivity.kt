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

class ExpIntentActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var btnSubmit: Button
    lateinit var etFname: EditText
    lateinit var etLname: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exp_intent_activty)
        btnSubmit = findViewById(R.id.btn_submit)
        etFname = findViewById(R.id.et_fname)
        etLname = findViewById(R.id.et_lname)
        btnSubmit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent(this@ExpIntentActivity, SecondActivity::class.java)
        intent.putExtra("fname", etFname.text.toString())
        intent.putExtra("lname", etLname.text.toString())
        startActivity(intent)

    }
}