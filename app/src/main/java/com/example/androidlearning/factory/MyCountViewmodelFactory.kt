package com.example.androidlearning.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidlearning.viewModel.CountViewModel

class MyCountViewmodelFactory(private var i: Int): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CountViewModel::class.java)){
            return CountViewModel(i) as T
        }
        throw IllegalArgumentException("Unknown class")

    }
}