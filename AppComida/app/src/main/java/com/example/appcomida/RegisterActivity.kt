package com.example.appcomida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        findViewById<Button>(R.id.register_btn).setOnClickListener {
            this.finish()
        }
        findViewById<ImageButton>(R.id.back_btn).setOnClickListener {
            this.finish()
        }
    }
}