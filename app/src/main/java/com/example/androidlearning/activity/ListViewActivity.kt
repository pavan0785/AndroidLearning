package com.example.androidlearning.activity

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

class ListViewActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    lateinit var listView: ListView
//    val listItem = ArrayList<String>()
    val listItems = mutableListOf<String>("January", "February", "March", "April", "May", "June", "July", "August", "September",
        "October", "November", "December", "A", "B", "V0", "D", "AA", "BB", "VB", "WE")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view)
        listView = findViewById(R.id.list_view)

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        listView.adapter = arrayAdapter

        listView.setOnItemClickListener(this)
    }

    override fun onItemClick(adapter: AdapterView<*>?, view: View?, position: Int, rowId: Long) {
        val itemName = adapter!!.getItemAtPosition(position).toString()
        Toast.makeText(this@ListViewActivity, itemName, Toast.LENGTH_SHORT).show()
    }
}