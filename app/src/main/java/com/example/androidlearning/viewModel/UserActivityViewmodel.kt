package com.example.androidlearning.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.androidlearning.roomDb.User
import com.example.androidlearning.repository.UserRepository

class UserActivityViewmodel(private val userRepository: UserRepository): ViewModel() {
    suspend fun insertUser(user: User){
        userRepository.insertUser(user)
    }

    suspend fun updateUser(user: User){
        userRepository.updateUser(user)
    }

    suspend fun deleteUser(user: User){
        userRepository.deleteUser(user)
    }

    suspend fun deleteAllUser(){
        userRepository.deleteAllUser()
    }

    val getAllUsers: LiveData<List<User>> = userRepository.getAllUsers()
}