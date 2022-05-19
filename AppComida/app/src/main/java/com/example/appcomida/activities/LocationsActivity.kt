package com.example.appcomida.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appcomida.R
import com.example.appcomida.dataClasses.UserLocation
import com.example.appcomida.Utilities
import com.example.appcomida.adapters.UserLocationAdapter

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
        val recyclerView: RecyclerView? = findViewById(R.id.recyclerView)
        recyclerView!!.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        Utilities.usersRef.document(Utilities.userID).collection("locations").get()
            .addOnSuccessListener {
                val location = it!!.toObjects(UserLocation::class.java)
                location.forEachIndexed { index, post ->
                    post.uid = it.documents[index].id
                }
                val adapter = UserLocationAdapter(location, this)
                recyclerView.adapter = adapter
            }
    }
}