package com.example.androidlearning.apiResponse

import com.google.gson.annotations.SerializedName

data class ProductRating(
    @SerializedName("rate")
    val rate: Double,

    @SerializedName("count")
    val count: Int
)
