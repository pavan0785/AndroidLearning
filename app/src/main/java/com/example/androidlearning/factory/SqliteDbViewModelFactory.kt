package com.example.androidlearning.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidlearning.repository.SqliteDbRepository
import com.example.androidlearning.viewModel.CountViewModel
import com.example.androidlearning.viewModel.SqliteViewModel

class SqliteDbViewModelFactory(private val repository: SqliteDbRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SqliteViewModel::class.java)){
            return SqliteViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown class")

    }
}