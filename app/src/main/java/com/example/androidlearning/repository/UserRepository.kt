package com.example.androidlearning.repository

import androidx.lifecycle.LiveData
import com.example.androidlearning.roomDb.User
import com.example.androidlearning.roomDb.UserDao

class UserRepository(private val userDao: UserDao) {
    suspend fun insertUser(user: User){
        userDao.insertUser(user)
    }

    fun getAllUsers(): LiveData<List<User>> {
        return userDao.getAllUsers()
    }
}