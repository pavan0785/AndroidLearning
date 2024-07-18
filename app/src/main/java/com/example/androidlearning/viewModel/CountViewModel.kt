package com.example.androidlearning.viewModel

import androidx.lifecycle.ViewModel

class CountViewModel: ViewModel() {
    var count = 0

    fun countInc(): Int{
        count = count + 1
        return count
    }
}