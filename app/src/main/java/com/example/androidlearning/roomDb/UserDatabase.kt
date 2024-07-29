package com.example.androidlearning.roomDb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [User::class], version = 1)
abstract class UserDatabase: RoomDatabase() {
    abstract val userDao: UserDao
    companion object{
        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getInstance(context: Context): UserDatabase{
            var instance = INSTANCE
            synchronized(this){
                if (instance == null){
                    instance = Room
                        .databaseBuilder(context, UserDatabase::class.java, "User")
                        .build()
                    INSTANCE = instance
                }

            }
            return instance!!
        }

    }

}