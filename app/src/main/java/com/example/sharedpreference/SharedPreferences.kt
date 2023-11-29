package com.example.sharedpreference

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class SharedPreferences(val context:Context) {
    private val   PREFS_NAME="User"
    val sharedPreferences: SharedPreferences? = context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE)

    fun save (KEY_NAME:String,text:String){
        val editor : SharedPreferences.Editor? = sharedPreferences?.edit()
        editor?.putString(KEY_NAME,text)
        editor!!.commit()
    }

    fun save (KEY_NAME:String,value:Int){
        val editor : SharedPreferences.Editor? = sharedPreferences?.edit()
        editor?.putInt(KEY_NAME,value)
        editor?.commit()
    }

    fun save (KEY_NAME:String,status:Boolean){
        val editor : SharedPreferences.Editor? = sharedPreferences?.edit()
        editor?.putBoolean(KEY_NAME,status!!)
        editor?.commit()
    }

    fun getValueString(KEY_NAME:String):String?{
        return sharedPreferences?.getString(KEY_NAME,null)
    }

    fun getValueInt(KEY_NAME:String):Int?{
        return sharedPreferences?.getInt(KEY_NAME,0)
    }

    fun clearShared(){
        val editor : SharedPreferences.Editor? = sharedPreferences?.edit()
        editor?.clear()
        editor?.commit()
    }
}