package com.example.androidlearning.roomDb

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") val id: Int,
    @ColumnInfo("fname") val fName: String,
    @ColumnInfo("lname")val lName: String,
    @ColumnInfo("email")val email: String
)
