package com.example.androidlearning.interfaces

import com.example.androidlearning.model.Cryptocurrency

interface CryptocurrencyRepository {
    fun getCryptoCurrency(): List<Cryptocurrency>
}