package com.example.appcomida.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.appcomida.R
import com.example.appcomida.dataClasses.UserLocation
import com.example.appcomida.Utilities
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.firestore.GeoPoint

class RegisterLocationActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    //private lateinit var binding: RegisterLocationActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //binding = ActivityMapsBinding.inflate(layoutInflater)
        //setContentView(binding.root)

        setContentView(R.layout.activity_register_location)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        findViewById<ImageButton>(R.id.back_btn).setOnClickListener {
            this.finish()
        }
        findViewById<Button>(R.id.reg_location_btn).setOnClickListener {
            val addressName = findViewById<TextInputEditText>(R.id.address_name).text
            val address = findViewById<TextInputEditText>(R.id.address).text
            val addressNumber = findViewById<TextInputEditText>(R.id.address_number).text
            val zipcode = findViewById<TextInputEditText>(R.id.zipcode).text
            val location = UserLocation(addressName.toString(), address.toString(), addressNumber.toString(), zipcode.toString(), GeoPoint(21.142503688063204, -86.83152044994684))
            Utilities.usersRef.document(Utilities.userID).collection("locations").document().set(location)
            this.finish()
        }
    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val home = LatLng(21.140964727973017, -86.84556582515465)
        mMap.addMarker(MarkerOptions().position(home).title("Marker"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(home))
    }

}