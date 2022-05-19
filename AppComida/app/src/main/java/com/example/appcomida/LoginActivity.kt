package com.example.appcomida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.actionCodeSettings
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

private lateinit var auth: FirebaseAuth

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Utilities.initReferences()
        /*Utilities.populateMenu()
        Utilities.buildRestaurant()*/


        auth = Firebase.auth

        if(auth.currentUser != null){
            Log.d("Login:", "user is logged in")
        }

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

    override fun onResume() {
        super.onResume()

        if(auth.currentUser != null){
            loginSuccessful()
        }
    }
    private fun loginSuccessful(){
        Utilities.userID = auth.currentUser!!.uid
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        this.finish()
    }
}