package com.example.androidlearning.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidlearning.repository.UserRepository
import com.example.androidlearning.viewModel.UserActivityViewmodel

class UserActivityViewmodelFactory(private val userRepository: UserRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserActivityViewmodel::class.java)){
            return UserActivityViewmodel(userRepository) as T
        }
        throw IllegalArgumentException("Unknown class")

    }
}