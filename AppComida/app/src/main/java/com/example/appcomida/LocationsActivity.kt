package com.example.appcomida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class LocationsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_locations)

        findViewById<Button>(R.id.reg_location_btn).setOnClickListener {
            val intent = Intent(this, RegisterLocationActivity::class.java)
            startActivity(intent)
        }
        findViewById<ImageButton>(R.id.back_btn).setOnClickListener {
            this.finish()
        }
    }
}