package com.ict.basickotlin.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ict.basickotlin.R

class DataActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        val tvDataReceived: TextView = findViewById(R.id.tv_data_received)

        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE, 0)
        val text = "Name: $name, Age: $age"
        tvDataReceived.text = text
    }
}