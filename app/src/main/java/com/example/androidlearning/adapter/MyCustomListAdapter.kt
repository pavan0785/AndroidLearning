package com.example.androidlearning.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.example.androidlearning.R
import com.example.androidlearning.model.Employee
import com.google.android.material.textview.MaterialTextView

class MyCustomListAdapter(private val context: Context, private val empList: MutableList<Employee>): BaseAdapter() {
    override fun getCount(): Int {
        return empList.size
    }

    override fun getItem(position: Int): Employee {
        return empList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(postion: Int, view: View?, viewGroup: ViewGroup?): View {
        var myView = LayoutInflater.from(context).inflate(R.layout.layout_custom_list_item, viewGroup, false)
        val employee = empList[postion]
        var imageView = myView.findViewById<ImageView>(R.id.item_iv)
        var tvName = myView.findViewById<MaterialTextView>(R.id.tv_name)
        var tvMobile = myView.findViewById<MaterialTextView>(R.id.tv_mobile)
        imageView.setImageDrawable(employee.image)
        tvName.setText(employee.name)
        tvMobile.setText(employee.mobile.toString())
        return myView
    }
}