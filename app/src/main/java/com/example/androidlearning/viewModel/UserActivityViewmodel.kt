package com.example.androidlearning.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.androidlearning.roomDb.User
import com.example.androidlearning.repository.UserRepository

class UserActivityViewmodel(private val userRepository: UserRepository): ViewModel() {
    suspend fun insertUser(user: User){
        userRepository.insertUser(user)
    }

    val getAllUsers: LiveData<List<User>> = userRepository.getAllUsers()
}