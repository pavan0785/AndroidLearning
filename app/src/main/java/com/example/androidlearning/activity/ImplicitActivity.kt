package com.example.androidlearning.activity

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidlearning.R

class ImplicitActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var btnLoad: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit)
        btnLoad = findViewById(R.id.btn_load)

        btnLoad.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val intent = Intent(ACTION_VIEW, Uri.parse("https://developer.android.com/guide/components/intents-filters"))
        startActivity(intent)
    }
}