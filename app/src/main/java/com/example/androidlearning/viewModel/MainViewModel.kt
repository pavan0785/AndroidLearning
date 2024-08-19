package com.example.androidlearning.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidlearning.interfaces.CryptocurrencyRepository
import com.example.androidlearning.model.Cryptocurrency
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val cryptocurrencyRepository: CryptocurrencyRepository): ViewModel() {
    private val cryptocurrencyEmitter = MutableLiveData<List<Cryptocurrency>>()
    val cryptoCurrency: LiveData<List<Cryptocurrency>> = cryptocurrencyEmitter

    init {
        loadCryptocurrency()
    }

    private fun loadCryptocurrency() {

    }
}