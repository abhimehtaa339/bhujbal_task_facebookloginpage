package com.todo.facebookloginclone.sharedPrefrence

import android.content.Context
import android.content.SharedPreferences

class SharedPref(private var sharedpred : SharedPreferences){

    fun saveCredtinals(email : String , password : String , context: Context ){
        val editor = sharedpred.edit()
        editor.putString("email" , email)
        editor.putString("pswd" , password)
        editor.apply()

    }

    fun isLoggedIn(context: Context): Boolean {
        val sharedPreferences = context.getSharedPreferences("User", Context.MODE_PRIVATE)
        return sharedPreferences.getString("email", null) != null
    }
}