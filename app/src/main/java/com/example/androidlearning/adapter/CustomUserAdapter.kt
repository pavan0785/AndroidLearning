package com.example.androidlearning.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.example.androidlearning.R
import com.example.androidlearning.databinding.LayoutUserItemBinding
import com.example.androidlearning.model.Employee
import com.example.androidlearning.model.User
import com.google.android.material.textview.MaterialTextView

class CustomUserAdapter (private val context: Context, private val userList: ArrayList<User>): BaseAdapter() {
    override fun getCount(): Int {
        return userList.size
    }

    override fun getItem(position: Int): User {
        return userList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(postion: Int, view: View?, viewGroup: ViewGroup?): View {
        val lBinding = LayoutUserItemBinding.inflate(LayoutInflater.from(viewGroup!!.context), viewGroup, false)
        val user = userList[postion]
        lBinding.tvName.text = "${user.fName} ${user.lName}"
        lBinding.tvEmail.text = user.email
        return lBinding.root
    }
}