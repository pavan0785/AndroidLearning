package com.example.androidlearning.activity

import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidlearning.R

class CheckboxActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {
    lateinit var cb1: CheckBox
    lateinit var cb2: CheckBox
    lateinit var cb3: CheckBox
    lateinit var cb4: CheckBox
    lateinit var cb5: CheckBox
    lateinit var tvCheckbox: TextView
    lateinit var list: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkbox)

        cb1 = findViewById(R.id.cb_1)
        cb2 = findViewById(R.id.cb_2)
        cb3 = findViewById(R.id.cb_3)
        cb4 = findViewById(R.id.cb_4)
        cb5 = findViewById(R.id.cb_5)
        tvCheckbox = findViewById(R.id.tv_checkbox)

        cb1.setOnCheckedChangeListener(this)
        cb2.setOnCheckedChangeListener(this)
        cb3.setOnCheckedChangeListener(this)
        cb4.setOnCheckedChangeListener(this)
        cb5.setOnCheckedChangeListener(this)
        list = ArrayList()

    }

    override fun onCheckedChanged(compoundBtn: CompoundButton?, isCheck: Boolean) {
        when(compoundBtn?.id){
            R.id.cb_1 ->{
               if (cb1.isChecked){
                   list.add(cb1.text.toString())
               }else{
                   list.remove(cb1.text.toString())
               }
                tvCheckbox.text = ""+list.toString().replace("[", "").replace("]", "")

            }
            R.id.cb_2 ->{
                if (cb2.isChecked){
                    list.add(cb2.text.toString())
                }else{
                    list.remove(cb2.text.toString())
                }
                tvCheckbox.text = ""+list.toString().replace("[", "").replace("]", "")
            }

            R.id.cb_3 ->{
                if (cb3.isChecked){
                    list.add(cb3.text.toString())
                }else{
                    list.remove(cb3.text.toString())
                }
                tvCheckbox.text = ""+list.toString().replace("[", "").replace("]", "")
            }

            R.id.cb_4 ->{
                if (cb4.isChecked){
                    list.add(cb4.text.toString())
                }else{
                    list.remove(cb4.text.toString())
                }
                tvCheckbox.text = ""+list.toString().replace("[", "").replace("]", "")
            }

            R.id.cb_5 ->{
                if (cb5.isChecked){
                    list.add(cb5.text.toString())
                }else{
                    list.remove(cb5.text.toString())
                }
                tvCheckbox.text = ""+list.toString().replace("[", "").replace("]", "")
            }

//            if (compoundBtn!!.id == R.id.cb_1){
//
//            }else if (compoundBtn!!.id == R.id.cb_2){
//
//            }else if ()
        }
    }
}