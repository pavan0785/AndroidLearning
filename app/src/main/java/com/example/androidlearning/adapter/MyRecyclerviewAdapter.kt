package com.example.androidlearning.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidlearning.R
import com.example.androidlearning.model.Employee
import com.google.android.material.textview.MaterialTextView

class MyRecyclerviewAdapter(private val empList: List<Employee>): RecyclerView.Adapter<MyRecyclerviewAdapter.MyRecyclerviewHolder>() {

    inner class MyRecyclerviewHolder(val view: View): RecyclerView.ViewHolder(view) {
        var tvName = view.findViewById<MaterialTextView>(R.id.tv_name)
        var tvMobile = view.findViewById<MaterialTextView>(R.id.tv_mobile)
        var imageView = view.findViewById<ImageView>(R.id.item_iv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecyclerviewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_custom_list_item, parent, false)
        val myRecyclerViewHolder = MyRecyclerviewHolder(view)
        return myRecyclerViewHolder

    }

    override fun getItemCount(): Int {
        return empList.size
    }

    override fun onBindViewHolder(holder: MyRecyclerviewHolder, position: Int) {
        val employee = empList[position]
        holder.tvName.text = employee.name
        holder.tvMobile.text = employee.mobile.toString()
        holder.imageView.setImageDrawable(employee.image)

    }
}