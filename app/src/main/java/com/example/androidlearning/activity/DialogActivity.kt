package com.example.androidlearning.activity

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.ProgressDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutParams
import com.example.androidlearning.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialDialogs
import com.google.android.material.textview.MaterialTextView
import java.util.Calendar

class DialogActivity : AppCompatActivity(), View.OnClickListener,
    NumberPicker.OnValueChangeListener {
    lateinit var btnAlertDialog: MaterialButton
    lateinit var btnProgressDialog: MaterialButton
    lateinit var btnCustomDialog: MaterialButton
    lateinit var btnDatePicker: MaterialButton
    lateinit var calender: Calendar
    var mDay: Int = 0
    var mMonth: Int = 0
    var mYear: Int = 0
    lateinit var tvDate: MaterialTextView
    lateinit var numberPicker: NumberPicker


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dialog)
        btnAlertDialog = findViewById(R.id.btn_alert_dialog)
        btnProgressDialog = findViewById(R.id.btn_progress_dialog)
        btnCustomDialog = findViewById(R.id.btn_custom_dialog)
        btnDatePicker = findViewById(R.id.btn_datepicker_dialog)
        tvDate = findViewById(R.id.tv_date)
        numberPicker = findViewById(R.id.number_picker)

        btnAlertDialog.setOnClickListener(this)
        btnProgressDialog.setOnClickListener(this)
        btnCustomDialog.setOnClickListener(this)
        btnDatePicker.setOnClickListener(this)

        calender = Calendar.getInstance()
        mDay = calender.get(Calendar.DAY_OF_MONTH)
        mMonth = calender.get(Calendar.MONTH)
        mYear = calender.get(Calendar.YEAR)
        tvDate.text = ""+mDay+"/"+(mMonth + 1)+"/"+mYear

        numberPicker.minValue = 1
        numberPicker.maxValue = 1000

        numberPicker.setOnValueChangedListener(this)


    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.btn_alert_dialog ->
                val builder = AlertDialog.Builder(this)
                builder.setIcon(R.drawable.ic_alert)
                builder.setTitle("Alert")
                builder.setMessage("Do you want to exit?")
                builder.setCancelable(false)

                builder.setPositiveButton("Ok", object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        finish()
                    }

                })

                builder.setNegativeButton("Cancel", object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {

                    }

                })

//        builder.show()
                val alertDialog = builder.create()
                alertDialog.show()
                alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).isAllCaps = false
                alertDialog.getButton(AlertDialog.BUTTON_POSITIVE)
                    .setTextColor(getColor(R.color.dialog_pos_btn_color))
            }

            R.id.btn_progress_dialog -> {
                val progDialog = ProgressDialog(this)
//                progDialog.setTitle("Progress")
                progDialog.setMessage("Please wait...")
                progDialog.setCancelable(false)
                progDialog.show()
            }

            R.id.btn_custom_dialog -> {
                val dialog = Dialog(this)
                dialog.setContentView(R.layout.layout_custom_dialog)
                dialog.setCancelable(false)
                dialog.show()

                dialog.window!!.setLayout(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

                val etFname = dialog.findViewById<EditText>(R.id.et_fname)
                val etLname = dialog.findViewById<EditText>(R.id.et_lname)
                val btnSubmit = dialog.findViewById<Button>(R.id.btn_submit)

                btnSubmit.setOnClickListener {
                    val fname = etFname.text.toString()
                    val lName = etLname.text.toString()
                    Toast.makeText(this, "${fname} ${lName}", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
            }

            R.id.btn_datepicker_dialog -> {
                val mDatePicker = DatePickerDialog(this)
                mDatePicker.setOnDateSetListener(object: DatePickerDialog.OnDateSetListener{
                    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, date: Int) {
                        tvDate.text = ""+date+"/"+(month + 1)+"/"+year
                    }

                })
                mDatePicker.show()

            }
        }

    }

    override fun onValueChange(p0: NumberPicker?, oldValue: Int, newValue: Int) {
        tvDate.text = newValue.toString()
    }
}