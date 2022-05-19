package com.example.appcomida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.widget.*
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import com.squareup.picasso.Picasso


class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = Firebase.auth
        findViewById<Button>(R.id.register_btn).setOnClickListener {
            registerUser()
        }
        findViewById<ImageButton>(R.id.back_btn).setOnClickListener {
            this.finish()
        }
    }
    private fun registerUser(){
        val email = findViewById<TextView>(R.id.email).text.toString()
        val password = findViewById<TextView>(R.id.password).text.toString()
        val isInfoValid: Boolean = validLoginInfo(email, password)

        if(isInfoValid) {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        auth.signInWithEmailAndPassword(email, password)
                        val name = findViewById<TextInputEditText>(R.id.name)
                        val phone_number = findViewById<TextInputEditText>(R.id.phone_number)
                        val user = User(name.text.toString(), phone_number.text.toString())
                        Utilities.usersRef.document(auth.currentUser!!.uid).set(user)
                        this.finish()
                    } else {
                        Utilities.displayShortToast("Email is already registered", baseContext)
                    }
                }
        }
    }
    private fun validLoginInfo(email: CharSequence?, password: CharSequence?): Boolean{
        val isEmailCorrect = email!!.contains("@")
        val isPasswordCorrect = password!!.length>8

        if(!isEmailCorrect){
            val email_text_layout = findViewById<TextInputLayout>(R.id.email_text_layout)
            email_text_layout.error = "Incorrect email format"
        }
        if(!isPasswordCorrect){
            val password_text_layout = findViewById<TextInputLayout>(R.id.password_text_layout)
            password_text_layout.error = "Password must contain at least 8 characters"
        }
        return isEmailCorrect && isPasswordCorrect
    }
    data class User(
        val name:String?,
        val phone_number: String?){
        @Exclude
        @set:Exclude
        @get:Exclude
        var uid: String? = null
        constructor(): this(null,null)
    }
}