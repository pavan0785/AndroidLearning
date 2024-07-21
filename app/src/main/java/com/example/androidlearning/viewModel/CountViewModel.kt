package com.example.androidlearning.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel(private var i: Int): ViewModel() {
    var count: MutableLiveData<Int> = MutableLiveData(i)

    fun countInc(): Int{
        count.value = count.value?.plus(1)
        return count.value!!
    }
}