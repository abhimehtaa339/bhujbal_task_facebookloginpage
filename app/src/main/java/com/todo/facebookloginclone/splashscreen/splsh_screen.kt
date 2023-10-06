package com.todo.facebookloginclone.splashscreen

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.PersistableBundle
import com.todo.facebookloginclone.Activity.Logoutpage
import com.todo.facebookloginclone.Activity.MainActivity
import com.todo.facebookloginclone.R
import com.todo.facebookloginclone.sharedPrefrence.SharedPref

class splsh_screen : AppCompatActivity() {

   private val splashTimeOut: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splsh_screen)

        Handler(Looper.getMainLooper()).postDelayed({

            startActivity(Intent(this, MainActivity::class.java))

            finish()
        }, splashTimeOut)


    }
}