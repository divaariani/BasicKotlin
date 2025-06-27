package com.ict.basickotlin.activity

import Phone
import User
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.ict.basickotlin.R

class MainActivity : AppCompatActivity(), View.OnClickListener  {
    private lateinit var tvResult: TextView
    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == ResultActivity.RESULT_CODE && result.data != null) {
            val selectedValue =
                result.data?.getIntExtra(ResultActivity.EXTRA_SELECTED_VALUE, 0)
            tvResult.text = "Hasil : $selectedValue"
        }
    }

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

        val btnMoveWithObject:Button = findViewById(R.id.btn_move_activity_object)
        btnMoveWithObject.setOnClickListener(this)

        val btnDialPhone:Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

        val btnMoveForResult:Button = findViewById(R.id.btn_move_for_result)
        btnMoveForResult.setOnClickListener(this)
        tvResult = findViewById(R.id.tv_result)

        val btnMoveWithObjectLayout:Button = findViewById(R.id.btn_move_activity_object_layout)
        btnMoveWithObjectLayout.setOnClickListener(this)
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

            R.id.btn_move_activity_object -> {
                val person = User(
                    "Diva Ariani",
                    23,
                    "divaariani@gmail.com",
                    "Seoul"
                )
                val moveWithObjectIntent = Intent(this@MainActivity, ObjectActivity::class.java)
                moveWithObjectIntent.putExtra(ObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)
            }

            R.id.btn_dial_number -> {
                val phoneNumber = "088844442222"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }

            R.id.btn_move_for_result -> {
                val moveForResultIntent = Intent(this@MainActivity, ResultActivity::class.java)
                resultLauncher.launch(moveForResultIntent)
            }

            R.id.btn_move_activity_object_layout -> {
                val data = Phone(
                    "Google Pixel 9 Pro",
                    "5.0 inches\n" +
                            "FHD AMOLED at 441ppi\n" +
                            "2.5D Corning® Gorilla® Glass 4",
                    "5.6 x 2.7 x 0.2 ~ 0.3 inches 143.8 x 69.5 x 7.3 ~ 8.5 mm",
                    "2,770 mAh battery\n" +
                            "Standby time (LTE): up to 19 days\n" +
                            "Talk time (3g/WCDMA): up to 26 hours\n" +
                            "Internet use time (Wi-Fi): up to 13 hours\n" +
                            "Internet use time (LTE): up to 13 hours\n" +
                            "Video playback: up to 13 hours\n" +
                            "Audio playback (via headset): up to 110 hours\n" +
                            "Fast charging: up to 7 hours of use from only 15 minutes of charging",
                    "Sundar Pichai",
                    800,
                    "Google officially announced its much-anticipated Pixel phones; the Pixel and Pixel XL, on October 4. We attended Google’s London UK event, mirroring the main one taking place in San Francisco, US, where the firm unwrapped the new Android 7.1 Nougat devices which will apparently usurp Google’s long-standing Nexus series.",
                )
                val moveWithObjectIntent = Intent(this@MainActivity, ScrollActivity::class.java)
                moveWithObjectIntent.putExtra(ScrollActivity.EXTRA_DATA, data)
                startActivity(moveWithObjectIntent)
            }
        }
    }
}