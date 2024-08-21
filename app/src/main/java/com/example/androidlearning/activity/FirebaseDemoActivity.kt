package com.example.androidlearning.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidlearning.R
import com.example.androidlearning.databinding.ActivityFirebaseDemoBinding
import com.example.androidlearning.model.EmployeeInfo
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FirebaseDemoActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityFirebaseDemoBinding
//    lateinit var firebaseDb: FirebaseDatabase
    lateinit var databaseRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirebaseDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        firebaseDb = FirebaseDatabase.getInstance()
//        databaseRef = firebaseDb.getReference("EmployeeInfo")
        databaseRef = Firebase.database.reference

        binding.btnSaveUser.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
//        databaseRef.addValueEventListener(object : ValueEventListener{
//            override fun onDataChange(snapshot: DataSnapshot) {
//                databaseRef.child("employee").push().setValue(EmployeeInfo(binding.etFname.text.toString(), binding.etLname.text.toString(), binding.etEmail.text.toString()))
//                Toast.makeText(this@FirebaseDemoActivity, "Data successfully saved.", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                Toast.makeText(this@FirebaseDemoActivity, "Something error", Toast.LENGTH_SHORT).show()
//            }
//
//        })

        databaseRef.child("employee_1")
            .push()
            .setValue(EmployeeInfo(binding.etFname.text.toString(), binding.etLname.text.toString(), binding.etEmail.text.toString()))
            .addOnSuccessListener {
                Toast.makeText(this@FirebaseDemoActivity, "Data successfully saved.", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this@FirebaseDemoActivity, "Something error", Toast.LENGTH_SHORT).show()
            }
    }
}