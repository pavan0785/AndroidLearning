package com.example.androidlearning.activity

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.androidlearning.apiResponse.ProductItem
import com.example.androidlearning.databinding.ActivityProductDetailsBinding
import com.example.androidlearning.repository.ProductRepository.product
import com.google.gson.Gson
import com.squareup.picasso.Picasso

class ProductDetailsActivity: AppCompatActivity() {
    lateinit var binding: ActivityProductDetailsBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myIntent = intent
        val productString = myIntent.getStringExtra("_product")
        val product = Gson().fromJson(productString, ProductItem::class.java)
        Picasso.get().load(product!!.image).into(binding.ivImage)
        binding.tvTitle.text = product.title
        binding.tvItemCost.text = "Rs. ${product.price}"

    }
}