package com.example.androidlearning.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidlearning.apiResponse.ProductItem
import com.example.androidlearning.databinding.LayoutProductItemBinding
import com.squareup.picasso.Picasso

class RVProductAdapterRetrofit(private val productList: List<ProductItem>): RecyclerView.Adapter<RVProductAdapterRetrofit.MyRecyclerviewHolder>() {

    inner class MyRecyclerviewHolder(val binding: LayoutProductItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecyclerviewHolder {
        val binding = LayoutProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyRecyclerviewHolder(binding)

    }

    override fun getItemCount(): Int {
        Log.d("PRODUCT_SIZE", "getItemCount: ${productList.size}")
        return productList.size
    }

    override fun onBindViewHolder(holder: MyRecyclerviewHolder, position: Int) {
        val product = productList[position]
        Log.d("TAG_PRODUCT", "onBindViewHolder: $product")
        holder.binding.tvProductItem.text = product.title
        Picasso.get().load(product.image).into(holder.binding.ivProduct)

    }
}