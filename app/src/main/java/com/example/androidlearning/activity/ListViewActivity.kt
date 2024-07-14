package com.example.androidlearning.activity

import android.R.drawable.ic_menu_camera
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidlearning.R
import com.example.androidlearning.adapter.MyCustomListAdapter
import com.example.androidlearning.model.Employee

class ListViewActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    lateinit var listView: ListView
//    val listItem = ArrayList<String>()
//    val listItems = mutableListOf<String>("January", "February", "March", "April", "May", "June", "July", "August", "September",
//        "October", "November", "December", "A", "B", "V0", "D", "AA", "BB", "VB", "WE")

    private lateinit var empList:MutableList<Employee>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view)
        listView = findViewById(R.id.list_view)

//        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
//        listView.adapter = arrayAdapter
//        listView.setOnItemClickListener(this)
        empList = mutableListOf<Employee>()
        empList.add(Employee(getDrawable(ic_menu_camera)!!, "AA BB", 1230456789))
        empList.add(Employee(getDrawable(ic_menu_camera)!!, "CC DD", 4567891230))
        empList.add(Employee(getDrawable(ic_menu_camera)!!, "EE FF", 1245789630))
        empList.add(Employee(getDrawable(ic_menu_camera)!!, "GG HH", 3698521470))
        empList.add(Employee(getDrawable(ic_menu_camera)!!, "AA BB", 1230456789))
        empList.add(Employee(getDrawable(ic_menu_camera)!!, "AA BB", 1230456789))
        empList.add(Employee(getDrawable(ic_menu_camera)!!, "AA BB", 1230456789))
        empList.add(Employee(getDrawable(ic_menu_camera)!!, "AA BB", 1230456789))
        empList.add(Employee(getDrawable(ic_menu_camera)!!, "AA BB", 1230456789))
        empList.add(Employee(getDrawable(ic_menu_camera)!!, "AA BB", 1230456789))
        empList.add(Employee(getDrawable(ic_menu_camera)!!, "AA BB", 1230456789))
        empList.add(Employee(getDrawable(ic_menu_camera)!!, "AA BB", 1230456789))
        empList.add(Employee(getDrawable(ic_menu_camera)!!, "AA BB", 1230456789))
        empList.add(Employee(getDrawable(ic_menu_camera)!!, "AA BB", 1230456789))
        empList.add(Employee(getDrawable(ic_menu_camera)!!, "AA BB", 1230456789))
        empList.add(Employee(getDrawable(ic_menu_camera)!!, "AA BB", 1230456789))
        empList.add(Employee(getDrawable(ic_menu_camera)!!, "AA BB", 1230456789))
        empList.add(Employee(getDrawable(ic_menu_camera)!!, "AA BB", 1230456789))
        empList.add(Employee(getDrawable(ic_menu_camera)!!, "AA BB", 1230456789))
        empList.add(Employee(getDrawable(ic_menu_camera)!!, "AA BB", 1230456789))
        empList.add(Employee(getDrawable(ic_menu_camera)!!, "AA BB", 1230456789))
        empList.add(Employee(getDrawable(ic_menu_camera)!!, "AA BB", 1230456789))
        var myCustomListAdapter = MyCustomListAdapter(this, empList)
        listView.adapter = myCustomListAdapter

        listView.setOnItemClickListener(this)



    }

    override fun onItemClick(adapter: AdapterView<*>?, view: View?, position: Int, rowId: Long) {
//        val itemName = adapter!!.getItemAtPosition(position).toString()
//        Toast.makeText(this@ListViewActivity, itemName, Toast.LENGTH_SHORT).show()
        val employee = adapter!!.getItemAtPosition(position) as Employee
        Toast.makeText(this, employee.name, Toast.LENGTH_SHORT).show()
    }
}