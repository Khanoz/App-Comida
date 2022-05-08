package com.example.appcomida

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class RecoverPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recover_password)

        findViewById<Button>(R.id.recover_password_btn).setOnClickListener {
            this.finish()
        }
        findViewById<ImageButton>(R.id.back_btn).setOnClickListener {
            this.finish()
        }
    }
}