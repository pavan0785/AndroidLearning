package com.example.androidlearning.activity

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidlearning.R

class SpinnerActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    val listItems = mutableListOf<String>("January", "February", "March", "April", "May", "June", "July", "August", "September",
        "October", "November", "December", "A", "B", "V0", "D", "AA", "BB", "VB", "WE")
    lateinit var mySpinner: Spinner
    lateinit var autoCompleteTv: AutoCompleteTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)
        mySpinner = findViewById(R.id.spinner)
        autoCompleteTv = findViewById(R.id.autocomplete_tv)

        var myAdapater = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems)

        mySpinner.adapter = myAdapater
        autoCompleteTv.setAdapter(myAdapater)

        mySpinner.onItemSelectedListener = this


    }

    override fun onItemSelected(adapterView: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        val selectedItem = adapterView!!.getItemAtPosition(position).toString()
        Toast.makeText(this, selectedItem, Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}