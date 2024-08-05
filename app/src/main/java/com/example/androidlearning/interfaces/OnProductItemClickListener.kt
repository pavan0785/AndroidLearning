package com.example.androidlearning.interfaces

import com.example.androidlearning.apiResponse.ProductItem

interface OnProductItemClickListener {
    fun onClickProduct(position: Int, item: ProductItem)
}