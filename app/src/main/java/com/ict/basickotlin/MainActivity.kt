package com.ict.basickotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val greeting = getString(R.string.welcome)
        val name = getString(R.string.app_name)
        val fullText = "$greeting $name"

        val hello = findViewById<TextView>(R.id.hello)
        hello.text = fullText

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }

            R.id.btn_move_activity_data -> {
                val moveWithDataIntent = Intent(this@MainActivity, DataActivity::class.java)
                moveWithDataIntent.putExtra(DataActivity.EXTRA_NAME, "Diva Ariani")
                moveWithDataIntent.putExtra(DataActivity.EXTRA_AGE, 23)
                startActivity(moveWithDataIntent)
            }
        }
    }
}