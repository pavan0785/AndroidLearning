package com.example.androidlearning.activity

import android.R.drawable.ic_menu_camera
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.androidlearning.R
import com.example.androidlearning.adapter.MyRecyclerviewAdapter
import com.example.androidlearning.model.Employee

class RecyclerviewActivity : AppCompatActivity() {
    private lateinit var empList:MutableList<Employee>
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)
        recyclerView = findViewById(R.id.recycler_view)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = StaggeredGridLayoutManager(5, LinearLayoutManager.VERTICAL)
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

        val myRecyclerviewAdapter = MyRecyclerviewAdapter(empList)
        recyclerView.adapter = myRecyclerviewAdapter
        myRecyclerviewAdapter.notifyDataSetChanged()


    }
}