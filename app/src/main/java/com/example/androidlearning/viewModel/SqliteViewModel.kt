package com.example.androidlearning.viewModel

import androidx.lifecycle.ViewModel
import com.example.androidlearning.repository.SqliteDbRepository

class SqliteViewModel(private val repository: SqliteDbRepository): ViewModel() {
    fun openDataBase(){
        repository.sqliteDb.isOpen
    }

    fun addUser(fName: String, lName: String, email: String){
        repository.addUser(fName, lName, email)
    }
}