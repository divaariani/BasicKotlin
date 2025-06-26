package com.ict.basickotlin.activity

import User
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ict.basickotlin.R

class ObjectActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object)

        val tvObject: TextView = findViewById(R.id.tv_object_received)
        val user = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<User>(EXTRA_PERSON, User::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<User>(EXTRA_PERSON)
        }

        if (user != null) {
            val text = "Name : ${user.name.toString()},\nEmail : ${user.email},\nAge : ${user.age},\nLocation : ${user.city}"
            tvObject.text = text
        }
    }
}