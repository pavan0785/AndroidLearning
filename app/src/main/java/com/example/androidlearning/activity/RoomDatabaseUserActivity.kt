package com.example.androidlearning.activity

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutParams
import com.example.androidlearning.R
import com.example.androidlearning.adapter.RecyclerViewUserListAdapter
import com.example.androidlearning.databinding.ActivityRoomDatabaseUserBinding
import com.example.androidlearning.databinding.LayoutAddUserBinding
import com.example.androidlearning.databinding.LayoutUpdateUserBinding
import com.example.androidlearning.factory.UserActivityViewmodelFactory
import com.example.androidlearning.interfaces.OnMenuItemClickListener
import com.example.androidlearning.repository.UserRepository
import com.example.androidlearning.roomDb.User
import com.example.androidlearning.roomDb.UserDao
import com.example.androidlearning.roomDb.UserDatabase
import com.example.androidlearning.viewModel.UserActivityViewmodel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RoomDatabaseUserActivity : AppCompatActivity(), OnMenuItemClickListener {
    private lateinit var binding: ActivityRoomDatabaseUserBinding
    private lateinit var userActivityViewmodelFactory: UserActivityViewmodelFactory
    private lateinit var userActivityViewmodel: UserActivityViewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomDatabaseUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val userDao = UserDatabase.getInstance(this).userDao
        val userRepository = UserRepository(userDao)
        userActivityViewmodelFactory = UserActivityViewmodelFactory(userRepository)
        userActivityViewmodel = ViewModelProvider(this, userActivityViewmodelFactory)[UserActivityViewmodel::class.java]

        binding.rvUserList.layoutManager = LinearLayoutManager(this)
        userActivityViewmodel.getAllUsers.observe(this, Observer {
            val myAdapter = RecyclerViewUserListAdapter(it)
            binding.rvUserList.adapter = myAdapter

            myAdapter.setOnItemClickListener(this)
        })
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
                    CoroutineScope(Dispatchers.Main).launch {
                        userActivityViewmodel.insertUser(User(0, lBinding.etFname.text.toString(),
                            lBinding.etLname.text.toString(), lBinding.etEmail.text.toString()))
                    }

                    dialog.dismiss()
                }

                dialog.show()
                dialog.window!!.setLayout(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            }

            R.id.item_delete_all_users ->{
                CoroutineScope(Dispatchers.Main).launch {
                    userActivityViewmodel.deleteAllUser()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onMenuItemClick(position: Int, menuItem: MenuItem, user: List<User>) {
        if (menuItem.itemId == 1) {
            CoroutineScope(Dispatchers.Main).launch {
                userActivityViewmodel.deleteUser(user[position])
            }
        } else if (menuItem.itemId == 2) {
            Log.d("onMenuItemClick", "onMenuItemClick: $user")
            val lBinding = LayoutUpdateUserBinding.inflate(layoutInflater)
            val dialog = Dialog(this)
            dialog.setContentView(lBinding.root)
            dialog.setCancelable(false)
            lBinding.etFname.setText(user[position].fName)

            lBinding.etLname.setText(user[position].lName)
            lBinding.etEmail.setText(user[position].email)

            lBinding.btnUpdateUser.setOnClickListener {
                CoroutineScope(Dispatchers.Main).launch {
                    userActivityViewmodel.updateUser(
                        User(
                            user[position].id,
                            lBinding.etFname.text.toString(),
                            lBinding.etLname.text.toString(),
                            lBinding.etEmail.text.toString()
                        )
                    )
                    dialog.dismiss()
                }
            }

            dialog.show()
            dialog.window!!.setLayout(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        }
    }


}