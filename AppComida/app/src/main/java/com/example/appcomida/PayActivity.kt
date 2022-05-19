package com.example.appcomida

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appcomida.adapters.CartAdapter
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.firestore.Exclude

class PayActivity : AppCompatActivity(), OnMapReadyCallback {
    val fees: Int = 25
    val tips: Int = 20
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val recyclerView: RecyclerView? = findViewById(R.id.recyclerView)
        recyclerView!!.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val adapter = CartAdapter(Utilities.userCart.items, this)
        recyclerView.adapter = adapter

        findViewById<TextView>(R.id.fees).text = getString(R.string.price, fees.toString())
        findViewById<TextView>(R.id.tips).text = getString(R.string.price, tips.toString())
        val subtotal = Utilities.Subtotal()
        findViewById<TextView>(R.id.order).text = getString(R.string.price, subtotal.toString())

        findViewById<TextView>(R.id.subtotal).text = getString(R.string.price, (subtotal+(fees+tips)).toString())
        val pay_btn = findViewById<Button>(R.id.pay_btn)
        pay_btn.text = getString(R.string.price, (subtotal+(fees+tips)).toString())
        pay_btn.setOnClickListener {
            AddUserOrder()
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val home = LatLng(21.140964727973017, -86.84556582515465)
        mMap.addMarker(MarkerOptions().position(home).title("Marker"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(home))

    }

    private fun AddUserOrder(){
        val order = Order(Utilities.selectedRestaurant.name)
        Utilities.userCart.items.forEach {
            order.names.add(it.item!!.name)
            order.prices.add(it.item.price)
            order.quantities.add(it.quantity)
            order.specialInstructions.add(it.specialInstructions)
        }
        Utilities.usersRef.document(Utilities.userID).collection("orders").add(order)
    }


}