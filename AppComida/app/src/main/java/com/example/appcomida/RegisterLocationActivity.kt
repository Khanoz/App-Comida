package com.example.appcomida

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class RegisterLocationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_location)

        findViewById<ImageButton>(R.id.back_btn).setOnClickListener {
            this.finish()
        }
        findViewById<Button>(R.id.reg_location_btn).setOnClickListener {
            this.finish()
        }
    }
}