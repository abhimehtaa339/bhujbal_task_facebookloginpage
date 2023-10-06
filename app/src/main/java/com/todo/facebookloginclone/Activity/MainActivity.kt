package com.todo.facebookloginclone.Activity

import android.content.Intent
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.todo.facebookloginclone.R
import com.todo.facebookloginclone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var email : String


    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this , R.layout.activity_main)

        val color = ContextCompat.getColor(this , R.color.white)
        binding.loading.indeterminateDrawable.colorFilter = BlendModeColorFilter(color , BlendMode.SRC_IN)


        binding.apply {
           submitbtn.setOnClickListener{
               submitbtn.text = " "
               loading.isVisible = true
               email = mail.text.toString()
               val passwd = pass.text.toString()
               val isValid = isPasswordValid(passwd)
                Log.d("pass" , isPasswordValid(passwd).toString())

               if (isValid){
                   Toast.makeText(applicationContext , "Login successful" , Toast.LENGTH_SHORT).show()
                   startActivity(Intent(
                       applicationContext , Logoutpage::class.java
                   ))
                   finish()
                   submitbtn.text = "Login"
                   loading.isVisible = false
               }else{
                   Toast.makeText(applicationContext , "Enter a valid password \n Contains 1cap 1 samll 1 symbol 1 number" , Toast.LENGTH_SHORT).show()
               }

           }
        }
    }

    private fun isPasswordValid(password: String): Boolean {
        val capitalLetterPattern = "[A-Z]+"

        val smallLetterPattern = "[a-z]+"

        val symbolPattern = "[!@#$%^&*()-_=+{};:,.<>?~]+"

        val numberPattern = "[0-9]+"

        return password.contains(capitalLetterPattern.toRegex()) &&
                password.contains(smallLetterPattern.toRegex()) &&
                password.contains(symbolPattern.toRegex()) &&
                password.contains(numberPattern.toRegex())
    }
}