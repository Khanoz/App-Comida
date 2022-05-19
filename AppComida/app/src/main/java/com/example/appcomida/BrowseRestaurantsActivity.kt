package com.example.appcomida

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appcomida.adapters.RestaurantAdapater
import com.google.firebase.firestore.Query

class BrowseRestaurantsActivity : AppCompatActivity() {
    private lateinit var query: Query
    private lateinit var searchInput: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browse_restaurants)

        searchInput = intent.extras!!.getString("searchInput")!!
        findViewById<TextView>(R.id.search_title).text = searchInput
        val searchInputQuery = Utilities.restaurantsRef.whereArrayContains("categories", searchInput).get()
        searchInputQuery.addOnSuccessListener {
            if(it.isEmpty)
                nameQuery()
            else
                categoryQuery()
        }
    }

    private fun categoryQuery(){
        val recyclerView: RecyclerView? = findViewById(R.id.recyclerView)
        recyclerView!!.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        query = Utilities.restaurantsRef.whereArrayContains("categories", searchInput)
        query.addSnapshotListener { value, error ->
            val restaurants = value!!.toObjects(Restaurant::class.java)

            restaurants.forEachIndexed { index, post ->
                post.uid = value.documents[index].id
            }
            val adapter = RestaurantAdapater(restaurants, this)
            recyclerView.adapter = adapter
        }




    }

    private fun nameQuery(){
        val recyclerView: RecyclerView? = findViewById(R.id.recyclerView)
        recyclerView!!.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        query = Utilities.restaurantsRef.whereEqualTo("name", searchInput)
        query.addSnapshotListener { value, error ->
            val restaurants = value!!.toObjects(Restaurant::class.java)

            restaurants.forEachIndexed { index, post ->
                post.uid = value.documents[index].id
            }
            val adapter = RestaurantAdapater(restaurants, this)
            recyclerView.adapter = adapter
        }
    }
}