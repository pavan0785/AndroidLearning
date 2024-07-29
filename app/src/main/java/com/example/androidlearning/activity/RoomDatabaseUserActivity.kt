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
import com.example.androidlearning.databinding.ActivityRoomDatabaseUserBinding
import com.example.androidlearning.databinding.LayoutAddUserBinding
import com.example.androidlearning.factory.UserActivityViewmodelFactory
import com.example.androidlearning.repository.UserRepository
import com.example.androidlearning.roomDb.User
import com.example.androidlearning.roomDb.UserDao
import com.example.androidlearning.roomDb.UserDatabase
import com.example.androidlearning.viewModel.UserActivityViewmodel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RoomDatabaseUserActivity : AppCompatActivity() {
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

            }
        }
        return super.onOptionsItemSelected(item)
    }
}