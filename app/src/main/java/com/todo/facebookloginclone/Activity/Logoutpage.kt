package com.todo.facebookloginclone.Activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.todo.facebookloginclone.R
import com.todo.facebookloginclone.databinding.ActivityLogoutpageBinding

class Logoutpage : AppCompatActivity() {
   private lateinit var binding: ActivityLogoutpageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this , R.layout.activity_logoutpage)


        binding.logoutbtn.setOnClickListener{
            Toast.makeText(applicationContext , "Logout successfully" , Toast.LENGTH_SHORT).show()
            startActivity(Intent(this , MainActivity::class.java))
            logout(applicationContext)
            finish()
        }
    }

    fun logout(context: Context) {
        val sharedPreferences = context.getSharedPreferences("User", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }
}