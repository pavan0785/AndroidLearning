package com.example.androidlearning.interfaces

import com.example.androidlearning.apiResponse.ProductItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/products")
    fun getProduct(): Call<List<ProductItem>>
}