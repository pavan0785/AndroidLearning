package com.example.androidlearning.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidlearning.R
import com.example.androidlearning.adapter.RVProductAdapterRetrofit
import com.example.androidlearning.apiResponse.ProductItem
import com.example.androidlearning.databinding.ActivityProductBinding
import com.example.androidlearning.interfaces.OnProductItemClickListener
import com.example.androidlearning.viewModel.ProductViewModel
import com.google.gson.Gson
import okhttp3.internal.format

class ProductActivity : AppCompatActivity(), OnProductItemClickListener {
    lateinit var viewModel: ProductViewModel
    private lateinit var binding: ActivityProductBinding
    private lateinit var alertDialog: AlertDialog.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        alertDialog = AlertDialog.Builder(this@ProductActivity)
        alertDialog.setCancelable(false)
        alertDialog.setMessage("Loading...")
        var dialog = alertDialog.create()

        binding.rvProductList.layoutManager = LinearLayoutManager(this)

        viewModel = ViewModelProvider(this)[ProductViewModel::class.java]

        viewModel.isLoading.observe(this, Observer {
            if (it){
                dialog.show()
            }else{
                dialog.dismiss()
            }
        })

        viewModel.getProduct().observe(this, Observer {
            for (product in it){
                Log.d("PRODUCT_TITLE:", "${product.title}")
            }
            val rvProductAdapter = RVProductAdapterRetrofit(it, this)
            Log.d("TAGTAG", "onCreate: ${rvProductAdapter.itemCount}")
            binding.rvProductList.adapter = rvProductAdapter
        })


    }

    override fun onClickProduct(position: Int, item: ProductItem) {
        val intent = Intent(this, ProductDetailsActivity::class.java)
        intent.putExtra("_product", Gson().toJson(item))
        startActivity(intent)
        Toast.makeText(this, "$position -- ${item.title}", Toast.LENGTH_SHORT).show()
    }
}