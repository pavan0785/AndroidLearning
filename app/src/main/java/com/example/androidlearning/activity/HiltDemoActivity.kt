package com.example.androidlearning.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidlearning.R
import com.example.androidlearning.adapter.CryptocurrencyAdapter
import com.example.androidlearning.databinding.ActivityHiltDemoBinding
import com.example.androidlearning.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HiltDemoActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityHiltDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHiltDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rv.layoutManager = LinearLayoutManager(this)

        observeCryptoCurrency()
    }

    private fun observeCryptoCurrency() {
        viewModel.cryptoCurrency.observe(this) {
            binding.rv.adapter = CryptocurrencyAdapter(it)
        }
    }
}