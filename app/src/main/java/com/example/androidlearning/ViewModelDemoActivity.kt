package com.example.androidlearning

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidlearning.factory.MyCountViewmodelFactory
import com.example.androidlearning.viewModel.CountViewModel
import com.google.android.material.textview.MaterialTextView

class ViewModelDemoActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var btnCount: Button
    lateinit var tvCountDisplay: MaterialTextView
    lateinit var myViewModel: CountViewModel
    lateinit var myCountViewModelFactory: MyCountViewmodelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model_demo)
        btnCount = findViewById(R.id.btn_count)
        tvCountDisplay = findViewById(R.id.tv_count_display)
        myCountViewModelFactory = MyCountViewmodelFactory(10)
        myViewModel = ViewModelProvider(this, myCountViewModelFactory)[CountViewModel::class.java]
//        tvCountDisplay.text = myViewModel.count.toString()
        myViewModel.count.observe(this, Observer {
            tvCountDisplay.text = it.toString()
        })

        btnCount.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        myViewModel.countInc()
//        tvCountDisplay.text = myViewModel.count.toString()
    }
}