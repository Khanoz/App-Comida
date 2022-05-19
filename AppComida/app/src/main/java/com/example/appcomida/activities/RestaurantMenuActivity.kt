package com.example.appcomida.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appcomida.dataClasses.MenuItem
import com.example.appcomida.fragments.MenuItemFragment
import com.example.appcomida.R
import com.example.appcomida.Utilities
import com.example.appcomida.adapters.MenuItemAdapter
import com.google.android.material.textview.MaterialTextView
import com.squareup.picasso.Picasso

class RestaurantMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_menu)
        val restaurant = Utilities.selectedRestaurant
        val name = findViewById<MaterialTextView>(R.id.name)
        val image = findViewById<ImageView>(R.id.image)
        val rating = findViewById<MaterialTextView>(R.id.rating)
        val category = findViewById<MaterialTextView>(R.id.category)
        val schedule = findViewById<MaterialTextView>(R.id.schedule)
        val tap_info_layout = findViewById<LinearLayout>(R.id.tap_for_address)
        name.text = restaurant.name
        Picasso.get().load(restaurant.image).resize(1000,1000).centerCrop().into(image)
        rating.text = restaurant.rating.toString()
        category.text = restaurant.categories!![0]
        schedule.text = getString(R.string.schedule, restaurant.openTime, restaurant.closeTime)
        /*tap_info_layout.setOnClickListener {

        }*/
        findViewById<ImageButton>(R.id.back_btn).setOnClickListener{
            this.finish()
        }

        val uid = intent.extras!!.getString("uid")
        val recyclerView: RecyclerView? = findViewById(R.id.recyclerView)
        recyclerView!!.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        Utilities.restaurantsRef.document(uid!!).collection("menu").get()
            .addOnSuccessListener {
                val item = it!!.toObjects(MenuItem::class.java)
                item.forEachIndexed { index, post ->
                    post.uid = it.documents[index].id
                }
                val adapter = MenuItemAdapter(item, this)
                recyclerView.adapter = adapter
            }
    }

    fun setupMenuItemFragment(){
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, MenuItemFragment()).commit()
    }
}