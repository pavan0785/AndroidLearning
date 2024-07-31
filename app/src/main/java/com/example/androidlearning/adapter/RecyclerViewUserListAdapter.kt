package com.example.androidlearning.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidlearning.R
import com.example.androidlearning.databinding.LayoutItemUserBinding
import com.example.androidlearning.interfaces.OnItemClickListener
import com.example.androidlearning.model.Employee
import com.example.androidlearning.roomDb.User
import com.google.android.material.textview.MaterialTextView

class RecyclerViewUserListAdapter(private val userList: List<User>): RecyclerView.Adapter<RecyclerViewUserListAdapter.MyRecyclerviewHolder>() {
    inner class MyRecyclerviewHolder(val binding: LayoutItemUserBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecyclerviewHolder {
       val binding = LayoutItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyRecyclerviewHolder(binding)

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyRecyclerviewHolder, position: Int) {
        val user = userList[position]
        holder.binding.tvName.text = user.fName+" "+user.lName
        holder.binding.tvEmail.text = user.email

    }
}