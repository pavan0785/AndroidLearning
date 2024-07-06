package com.example.androidlearning.activity

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.Images.Media
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidlearning.R

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
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
        return super.onOptionsItemSelected(item)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1){
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivity(intent)
            }
        }else{
            Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
        }
    }


}