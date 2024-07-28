    package com.example.androidlearning.coroutine

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidlearning.R
import com.example.androidlearning.activity.A
import com.example.androidlearning.databinding.ActivityCoroutineDemoBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

    class CoroutineDemoActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityCoroutineDemoBinding
    var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutineDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvCountDisplay.text = count.toString()

//        var aa = com.example.androidlearning.activity.AA()
//        var a = A()

        binding.btnDownload.setOnClickListener(this)
        binding.btnCount.setOnClickListener(this)
    }

        override fun onClick(view: View?) {
           when(view!!.id){
               R.id.btn_count ->{
                   count = count + 1
                   binding.tvCountDisplay.text = count.toString()

               }

               R.id.btn_download ->{
                   CoroutineScope(Dispatchers.IO).launch {
                       for (i in 1..100000){
//                           CoroutineScope(Dispatchers.Main).launch {
//                               binding.tvDownloadingDisplay.text = i.toString()
//                           }
                           withContext(Dispatchers.Main){
                               binding.tvDownloadingDisplay.text = i.toString()
                           }

                       }
                   }
               }
           }
        }
    }