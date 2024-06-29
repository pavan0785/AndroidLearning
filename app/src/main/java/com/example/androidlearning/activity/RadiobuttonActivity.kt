package com.example.androidlearning.activity

import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidlearning.R
import com.google.android.material.textview.MaterialTextView

class RadiobuttonActivity : AppCompatActivity(), RadioGroup.OnCheckedChangeListener {
    lateinit var rgGender: RadioGroup
    lateinit var tvDisplay: MaterialTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radiobutton)

        rgGender = findViewById(R.id.rg_gender)
        tvDisplay = findViewById(R.id.tv_display_gender)

        rgGender.setOnCheckedChangeListener(this)
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        var rbGender = findViewById<RadioButton>(checkedId)
        tvDisplay.text = rbGender.text.toString()
    }
}