package com.example.appcomida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<Button>(R.id.login_btn).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            this.finish()
        }
        findViewById<TextView>(R.id.register_btn).setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        findViewById<TextView>(R.id.recover_password_btn).setOnClickListener {
            val intent = Intent(this, RecoverPasswordActivity::class.java)
            startActivity(intent)
        }
    }
}