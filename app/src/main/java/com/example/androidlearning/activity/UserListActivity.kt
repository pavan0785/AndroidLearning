package com.example.androidlearning.activity

import android.app.Dialog
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView.LayoutParams
import com.example.androidlearning.R
import com.example.androidlearning.databinding.ActivityUserListBinding
import com.example.androidlearning.databinding.LayoutAddUserBinding
import com.example.androidlearning.factory.SqliteDbViewModelFactory
import com.example.androidlearning.repository.SqliteDbRepository
import com.example.androidlearning.viewModel.SqliteViewModel

class UserListActivity : AppCompatActivity() {
    lateinit var sqliteDbViewModelFactory: SqliteDbViewModelFactory
    lateinit var sqliteViewModel: SqliteViewModel
    lateinit var binding: ActivityUserListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sqlRepository = SqliteDbRepository(this)
        sqliteDbViewModelFactory = SqliteDbViewModelFactory(sqlRepository)
        sqliteViewModel = ViewModelProvider(this, sqliteDbViewModelFactory)[SqliteViewModel::class.java]
        sqliteViewModel.openDataBase()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item_add_user ->{
                val lBinding = LayoutAddUserBinding.inflate(layoutInflater)
                val dialog = Dialog(this)
                dialog.setContentView(lBinding.root)
                dialog.setCancelable(false)

                lBinding.btnAddUser.setOnClickListener {
                    sqliteViewModel.addUser(lBinding.etFname.text.toString(), lBinding.etLname.text.toString(), lBinding.etEmail.text.toString())
                    dialog.dismiss()
                }

                dialog.show()
                dialog.window!!.setLayout(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            }

            R.id.item_delete_all_users ->{

            }
        }
        return super.onOptionsItemSelected(item)
    }




}