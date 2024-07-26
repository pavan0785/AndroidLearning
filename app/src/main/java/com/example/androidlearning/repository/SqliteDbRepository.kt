package com.example.androidlearning.repository

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.androidlearning.model.User
import com.example.androidlearning.model.UserInfo

private const val DB_NAME = "pawan"
private const val TABLE_NAME = "user"
private const val DB_VERSION = 1


private const val COL_SI_NO = "Sn"
private const val COL_FNAME = "Fname"
private const val COL_LNAME = "Lname"
private const val COL_EMAIL = "Email"

class SqliteDbRepository(private val context: Context) {

    val CREATE_TABLE = "CREATE TABLE $TABLE_NAME($COL_SI_NO INTEGER PRIMARY KEY AUTOINCREMENT, $COL_FNAME TEXT, $COL_LNAME TEXT, $COL_EMAIL TEXT)"

    val myOpenHelper = MyOpenHelper(context)
    val sqliteDb = myOpenHelper.writableDatabase


    fun addUser(fName: String, lName: String, email: String){
        val contentValue = ContentValues()
        contentValue.put(COL_FNAME, fName)
        contentValue.put(COL_LNAME, lName)
        contentValue.put(COL_EMAIL, email)
        val rowId = sqliteDb.insert(TABLE_NAME, null, contentValue)
        if (rowId>0){
            Toast.makeText(context, "User successfully added.", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context, "Something went wrong.", Toast.LENGTH_SHORT).show()
        }
    }

    fun getAllUsers(): ArrayList<User>{
        var userList = arrayListOf<User>()
        val COLUMNS = arrayOf(COL_SI_NO, COL_FNAME, COL_LNAME, COL_EMAIL)
        val cursor = sqliteDb.query(TABLE_NAME, COLUMNS, null, null, null, null, null)
        if (cursor.count > 0){
            cursor.moveToFirst()
            do {
              var srNo = cursor.getInt(0)
              var fName = cursor.getString(1)
              var lName = cursor.getString(2)
              var email = cursor.getString(3)
              var user = User(srNo, fName, lName, email)
              userList.add(user)
            }while (cursor.moveToNext())

        }
        return userList
    }


    fun updateUser(fName: String, lName: String, email: String, id: Int){
        val contentValue = ContentValues()
        contentValue.put(COL_FNAME, fName)
        contentValue.put(COL_LNAME, lName)
        contentValue.put(COL_EMAIL, email)
        val id = sqliteDb.update(TABLE_NAME, contentValue, COL_SI_NO+"="+id, null)
        if (id>0){
            Toast.makeText(context, "User successfully updated.", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context, "Something went wrong.", Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteUser(id: Int){
        val id = sqliteDb.delete(TABLE_NAME, COL_SI_NO+"="+id, null)
        if (id>0){
            Toast.makeText(context, "User successfully deleted.", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context, "Something went wrong.", Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteAllUsers(){
        val id = sqliteDb.delete(TABLE_NAME, null, null)
        if (id>0){
            Toast.makeText(context, "$id User successfully deleted.", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context, "Something went wrong.", Toast.LENGTH_SHORT).show()
        }
    }


    inner class MyOpenHelper(private val context: Context): SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION){
        override fun onCreate(sqlDb: SQLiteDatabase?) {
            sqlDb!!.execSQL(CREATE_TABLE)
        }

        override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        }

    }

}