package com.example.androidlearning.adapter

import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidlearning.R
import com.example.androidlearning.databinding.LayoutItemUserBinding
import com.example.androidlearning.interfaces.OnItemClickListener
import com.example.androidlearning.interfaces.OnMenuItemClickListener
import com.example.androidlearning.model.Employee
import com.example.androidlearning.roomDb.User
import com.google.android.material.textview.MaterialTextView

class RecyclerViewUserListAdapter(private val userList: List<User>): RecyclerView.Adapter<RecyclerViewUserListAdapter.MyRecyclerviewHolder>(), View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {
    inner class MyRecyclerviewHolder(val binding: LayoutItemUserBinding): RecyclerView.ViewHolder(binding.root)
    private lateinit var mOnMenuItemClickListener: OnMenuItemClickListener
    private var position: Int = 0
    private lateinit var user: User

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecyclerviewHolder {
       val binding = LayoutItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyRecyclerviewHolder(binding)

    }

    fun setOnItemClickListener(listener: OnMenuItemClickListener){
        mOnMenuItemClickListener = listener
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyRecyclerviewHolder, position: Int) {
        user = userList[position]
        holder.itemView.tag = position
        holder.binding.tvName.text = user.fName+" "+user.lName
        holder.binding.tvEmail.text = user.email

        holder.itemView.setOnCreateContextMenuListener(this)


    }

    override fun onCreateContextMenu(contextMenu: ContextMenu?, view: View?, contextMenuInfo: ContextMenu.ContextMenuInfo?) {
        val menuItemDelete = contextMenu!!.add(Menu.NONE, 1, 1, "Delete")
        val menuItemUpdate = contextMenu!!.add(Menu.NONE,2, 2,"Update")

        position = view!!.tag as Int

        menuItemUpdate.setOnMenuItemClickListener(this)
        menuItemDelete.setOnMenuItemClickListener(this)

    }

    override fun onMenuItemClick(menuItem: MenuItem): Boolean {
        mOnMenuItemClickListener.onMenuItemClick(position, menuItem, userList)
        return false
    }

}