package com.example.androidlearning.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidlearning.R
import com.example.androidlearning.adapter.RVProductAdapterRetrofit
import com.example.androidlearning.databinding.ActivityProductBinding
import com.example.androidlearning.viewModel.ProductViewModel
import okhttp3.internal.format

class ProductActivity : AppCompatActivity() {
    lateinit var viewModel: ProductViewModel
    private lateinit var binding: ActivityProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvProductList.layoutManager = LinearLayoutManager(this)

        viewModel = ViewModelProvider(this)[ProductViewModel::class.java]
        viewModel.getProduct().observe(this, Observer {
            for (product in it){
                Log.d("PRODUCT_TITLE:", "${product.title}")
            }
            val rvProductAdapter = RVProductAdapterRetrofit(it)
            Log.d("TAGTAG", "onCreate: ${rvProductAdapter.itemCount}")
            binding.rvProductList.adapter = rvProductAdapter
        })


    }
}