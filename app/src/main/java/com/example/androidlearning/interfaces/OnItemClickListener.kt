package com.example.androidlearning.interfaces

import com.example.androidlearning.model.Employee

interface OnItemClickListener {
    fun onItemClick(position: Int, emp: Employee)
}