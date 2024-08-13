package com.example.androidlearning.retrofit

import com.example.androidlearning.interfaces.ApiInterface
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private val retrofitClient: Retrofit.Builder by lazy {
        val LOGGING = HttpLoggingInterceptor()
        LOGGING.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.addInterceptor(LOGGING)
        okHttpClient.connectTimeout(20, TimeUnit.SECONDS)
        okHttpClient.readTimeout(20, TimeUnit.SECONDS)
        okHttpClient.writeTimeout(20, TimeUnit.SECONDS)

        Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com")
            .client(okHttpClient.build())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
    }

    val apiInterface: ApiInterface by lazy {
        retrofitClient.build().create(ApiInterface::class.java)
    }
}