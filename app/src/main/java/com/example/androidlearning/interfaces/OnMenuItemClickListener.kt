package com.example.androidlearning.interfaces

import android.view.MenuItem
import com.example.androidlearning.roomDb.User

interface OnMenuItemClickListener {
    fun onMenuItemClick(position: Int, menuItem: MenuItem, user: List<User>)
}