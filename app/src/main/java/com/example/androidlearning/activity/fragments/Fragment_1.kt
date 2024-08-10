package com.example.androidlearning.activity.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidlearning.R
import com.example.androidlearning.databinding.Fragment1Binding

class Fragment_1 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = LayoutInflater.from(container!!.context).inflate(R.layout.fragment_1, container, false)

        return view

    }
}