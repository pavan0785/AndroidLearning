package com.example.androidlearning.activity

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidlearning.R

class ContextMenuActivity : AppCompatActivity(), View.OnClickListener,
    PopupMenu.OnMenuItemClickListener {
    lateinit var btnLongPress: Button
    lateinit var btnClick: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context_menu)
        btnLongPress = findViewById(R.id.btn_long_press)
        btnClick = findViewById(R.id.btn_click)

        registerForContextMenu(btnLongPress)

        btnClick.setOnClickListener(this)


    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.options_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item_1 ->{
                Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
            }
            R.id.item_2 ->{
                val intent = Intent(this, ExpIntentActivity::class.java)
                startActivity(intent)
            }
            R.id.item_3 ->{

            }

            R.id.item_4 ->{

            }

            R.id.item_camera ->{

                if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivity(intent)
                }else{
                    ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), 1)
                }

            }
        }
        return super.onContextItemSelected(item)
    }

    override fun onClick(view: View?) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.menuInflater.inflate(R.menu.options_menu,popupMenu.menu)
        popupMenu.show()

        popupMenu.setOnMenuItemClickListener(this)
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when(item!!.itemId){
            R.id.item_1 ->{
                Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
            }
            R.id.item_2 ->{
                val intent = Intent(this, ExpIntentActivity::class.java)
                startActivity(intent)
            }
            R.id.item_3 ->{

            }

            R.id.item_4 ->{

            }

            R.id.item_camera ->{

                if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivity(intent)
                }else{
                    ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), 1)
                }

            }
        }
        return true
    }
}