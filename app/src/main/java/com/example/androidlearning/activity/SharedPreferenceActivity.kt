package com.example.androidlearning.activity

import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidlearning.R
import com.example.androidlearning.databinding.ActivitySharedPreferenceBinding

class SharedPreferenceActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivitySharedPreferenceBinding
    lateinit var mySharedPreference: SharedPreferences
    lateinit var myEditor: Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedPreferenceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mySharedPreference = getSharedPreferences("_prefs", MODE_PRIVATE)
        myEditor = mySharedPreference.edit()

        binding.btnSubmit.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        myEditor.putString("fName", binding.etFname.text.toString())
        myEditor.putString("lName", binding.etLname.text.toString())
        myEditor.commit()
    }

    override fun onResume() {
        super.onResume()
        var fName = mySharedPreference.getString("fName", "")
        var lName = mySharedPreference.getString("lName", "")

        if (fName!!.isNotEmpty() && lName!!.isNotEmpty()){
            val intent = Intent(this, WelComeActivity::class.java)
            intent.putExtra("p1", fName)
            intent.putExtra("p2", lName)
            startActivity(intent)
        }else{
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show()
        }
    }
}