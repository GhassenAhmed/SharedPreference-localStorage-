package com.example.sharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edtname = findViewById<EditText>(R.id.name)
        val edtemail = findViewById<EditText>(R.id.email)
        val save = findViewById<Button>(R.id.save)
        val retrieve = findViewById<Button>(R.id.retrieve)
        val clear = findViewById<Button>(R.id.clear)

        val sharedPreferences:SharedPreferences = SharedPreferences(this)

        save.setOnClickListener {
            val name = edtname.editableText.toString()
            val email = edtemail.editableText.toString()
            sharedPreferences.save("name",name)
            sharedPreferences.save("email",email)
            Toast.makeText(applicationContext,"data saved !",Toast.LENGTH_SHORT).show()
            edtname.hint="Name"
            edtemail.hint="Email"
        }

        retrieve.setOnClickListener {
            val nameRet = sharedPreferences.getValueString("name")
            val emailRet  = sharedPreferences.getValueString("email")
            if(nameRet!=null){
                edtname.hint=nameRet!!
                Toast.makeText(applicationContext,"name retrieved !",Toast.LENGTH_SHORT).show()
            }else{
                edtname.hint="No name found!"
            }

            if(emailRet!=null){
                edtemail.hint = emailRet
                Toast.makeText(applicationContext,"email retrieved !",Toast.LENGTH_SHORT).show()
            }else{
                edtemail.hint="No email found"
            }
        }

        clear.setOnClickListener {
            sharedPreferences.clearShared()
            edtname.hint="Name"
            edtemail.hint="Email"
            Toast.makeText(applicationContext,"data cleared !",Toast.LENGTH_SHORT).show()
        }
    }
}