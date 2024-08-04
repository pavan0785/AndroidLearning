package com.example.androidlearning.retrofit

import com.example.androidlearning.interfaces.ApiInterface
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val retrofitClient: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
    }

    val apiInterface: ApiInterface by lazy {
        retrofitClient.build().create(ApiInterface::class.java)
    }
}