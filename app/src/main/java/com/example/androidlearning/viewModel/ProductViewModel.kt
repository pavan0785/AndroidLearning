package com.example.androidlearning.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidlearning.apiResponse.ProductItem
import com.example.androidlearning.repository.ProductRepository

class ProductViewModel: ViewModel() {
    var isLoading: MutableLiveData<Boolean> = ProductRepository.isLoading

    fun getProduct(): LiveData<List<ProductItem>> {
      return ProductRepository.getProduct()
    }
}