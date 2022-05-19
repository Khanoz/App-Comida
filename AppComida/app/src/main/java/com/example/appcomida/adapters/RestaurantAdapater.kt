package com.example.appcomida.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appcomida.*
import com.example.appcomida.activities.RestaurantMenuActivity
import com.example.appcomida.dataClasses.Restaurant
import com.squareup.picasso.Picasso

class RestaurantAdapater(val restaurants: List<Restaurant>, val cont : Context) : RecyclerView.Adapter<RestaurantAdapater.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.restaurant, parent, false)
        return ViewHolder(view, cont)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(restaurants[position])
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }


    class ViewHolder(itemView: View, val cont: Context?): RecyclerView.ViewHolder(itemView){
        fun bindItems(restaurant: Restaurant){
            val nombre = itemView.findViewById<TextView>(R.id.name)
            val image = itemView.findViewById<ImageView>(R.id.image)
            val rating = itemView.findViewById<TextView>(R.id.rating)
            nombre.text = restaurant.name
            Picasso.get().load(restaurant.image).resize(250,250).centerCrop().into(image)
            rating.text = restaurant.rating.toString()
            itemView.setOnClickListener {
                Utilities.selectedRestaurant = restaurant
                val intent = Intent(cont, RestaurantMenuActivity::class.java)
                intent.putExtra("uid", restaurant.uid)
                cont!!.startActivity(intent)
            }
        }
    }
}