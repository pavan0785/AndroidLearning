package com.example.androidlearning.activity

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidlearning.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialDialogs

class DialogActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var btnAlertDialog: MaterialButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dialog)
        btnAlertDialog = findViewById(R.id.btn_alert_dialog)

        btnAlertDialog.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setIcon(R.drawable.ic_alert)
        alertDialog.setTitle("Alert")
        alertDialog.setMessage("Do you want to exit?")

        alertDialog.setPositiveButton("Ok", object: DialogInterface.OnClickListener{
            override fun onClick(p0: DialogInterface?, p1: Int) {
                    finish()
            }

        })

        alertDialog.setNegativeButton("Cancel", object: DialogInterface.OnClickListener{
            override fun onClick(p0: DialogInterface?, p1: Int) {

            }

        })

        alertDialog.show()
    }
}