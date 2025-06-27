package com.ict.basickotlin.activity

import Phone
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ict.basickotlin.R
import com.ict.basickotlin.activity.ObjectActivity.Companion.EXTRA_PERSON

class ScrollActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll)

        val tvValue: TextView = findViewById(R.id.tv_value)
        val tvContentText: TextView = findViewById(R.id.tv_content_text)
        val contentSpecsDisplay: TextView = findViewById(R.id.content_specs_display)
        val contentSpecsSize: TextView = findViewById(R.id.content_specs_size)
        val contentSpecsBattery: TextView = findViewById(R.id.content_specs_battery)
        val name: TextView = findViewById(R.id.name)

        val phone = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Phone>(EXTRA_DATA, Phone::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Phone>(EXTRA_DATA)
        }

        if (phone != null) {
            tvValue.text = phone.name
            val price = "$${phone.value}"
            tvContentText.text = price
            contentSpecsDisplay.text = phone.specsDisplay
            contentSpecsSize.text = phone.specsSize
            contentSpecsBattery.text = phone.specsBattery
            name.text = phone.seller
        }
    }
}