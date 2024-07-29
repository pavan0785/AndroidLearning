package com.example.androidlearning.repository

import com.example.androidlearning.roomDb.User
import com.example.androidlearning.roomDb.UserDao

class UserRepository(private val userDao: UserDao) {
    suspend fun insertUser(user: User){
        userDao.insertUser(user)
    }
}