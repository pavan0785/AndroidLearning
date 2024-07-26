package com.example.androidlearning.viewModel

import androidx.lifecycle.ViewModel
import com.example.androidlearning.model.User
import com.example.androidlearning.repository.SqliteDbRepository

class SqliteViewModel(private val repository: SqliteDbRepository): ViewModel() {
    fun openDataBase(){
        repository.sqliteDb.isOpen
    }

    fun addUser(fName: String, lName: String, email: String){
        repository.addUser(fName, lName, email)
    }

    fun getAllUsers(): ArrayList<User>{
        return repository.getAllUsers()
    }

    fun updateUser(fName: String, lName: String, email: String, id: Int){
        repository.updateUser(fName, lName, email, id)
    }

    fun deleteUser(id: Int){
        repository.deleteUser(id)
    }

    fun deleteAllUser(){
        repository.deleteAllUsers()
    }
}