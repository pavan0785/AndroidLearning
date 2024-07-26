package com.example.androidlearning.activity

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView.LayoutParams
import com.example.androidlearning.R
import com.example.androidlearning.adapter.CustomUserAdapter
import com.example.androidlearning.databinding.ActivityUserListBinding
import com.example.androidlearning.databinding.LayoutAddUserBinding
import com.example.androidlearning.databinding.LayoutUpdateUserBinding
import com.example.androidlearning.factory.SqliteDbViewModelFactory
import com.example.androidlearning.model.User
import com.example.androidlearning.repository.SqliteDbRepository
import com.example.androidlearning.viewModel.SqliteViewModel

class UserListActivity : AppCompatActivity(), AdapterView.OnItemLongClickListener {
    lateinit var sqliteDbViewModelFactory: SqliteDbViewModelFactory
    lateinit var sqliteViewModel: SqliteViewModel
    lateinit var binding: ActivityUserListBinding
    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sqlRepository = SqliteDbRepository(this)
        sqliteDbViewModelFactory = SqliteDbViewModelFactory(sqlRepository)
        sqliteViewModel = ViewModelProvider(this, sqliteDbViewModelFactory)[SqliteViewModel::class.java]
        sqliteViewModel.openDataBase()

        updateView()

        binding.listView.setOnItemLongClickListener(this)
        registerForContextMenu(binding.listView)
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

                    updateView()

                }

                dialog.show()
                dialog.window!!.setLayout(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            }

            R.id.item_delete_all_users ->{
                sqliteViewModel.deleteAllUser()
                updateView()
            }
        }
        return super.onOptionsItemSelected(item)
    }


    fun updateView(){
        val userAdapter = CustomUserAdapter(this, sqliteViewModel.getAllUsers())
        binding.listView.adapter = userAdapter
    }

    override fun onItemLongClick(adapterView: AdapterView<*>?, view: View?, position: Int, rawId: Long): Boolean {
        Log.d("LongPressed", "onItemLongClick: "+position)
        user = adapterView?.getItemAtPosition(position) as User

        return false

    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu_context, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item_update_user ->{
                val lBinding = LayoutUpdateUserBinding.inflate(layoutInflater)
                val dialog = Dialog(this)
                dialog.setContentView(lBinding.root)
                dialog.setCancelable(false)

                lBinding.etFname.setText(user.fName)
                lBinding.etLname.setText(user.lName)
                lBinding.etEmail.setText(user.email)

                lBinding.btnUpdateUser.setOnClickListener {
                    sqliteViewModel.updateUser(lBinding.etFname.text.toString(), lBinding.etLname.text.toString(), lBinding.etEmail.text.toString(), user.srNo)
                    dialog.dismiss()
                    updateView()

                }

                dialog.show()
                dialog.window!!.setLayout(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            }

            R.id.item_delete_users ->{
               sqliteViewModel.deleteUser(user.srNo)
                updateView()
            }
        }
        return super.onContextItemSelected(item)
    }

}