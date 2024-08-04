package com.example.androidlearning.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidlearning.apiResponse.ProductItem
import com.example.androidlearning.retrofit.RetrofitClient
import okhttp3.Callback
import retrofit2.Call
import retrofit2.Response

object ProductRepository {
    val product = MutableLiveData<List<ProductItem>>()

    fun getProduct(): LiveData<List<ProductItem>>{
        val call = RetrofitClient.apiInterface.getProduct()
        call.enqueue(object: retrofit2.Callback<List<ProductItem>>{
            override fun onResponse(call: Call<List<ProductItem>>, response: Response<List<ProductItem>>) {
                if (response.isSuccessful){
                    val productList = response.body()
                    product.postValue(productList!!)
                    Log.d("TAG", "onResponse: ${response.body()}")
                }
            }

            override fun onFailure(call: Call<List<ProductItem>>, throwable: Throwable) {
                Log.d("TAG", "onFailure: $throwable")
            }

        })
        return product
    }
}