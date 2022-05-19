package com.example.appcomida.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.appcomida.*
import com.example.appcomida.activities.RestaurantMenuActivity
import com.example.appcomida.dataClasses.MenuItem
import com.google.android.material.textview.MaterialTextView
import com.squareup.picasso.Picasso

class MenuItemAdapter(val item: List<MenuItem>, val owner : RestaurantMenuActivity) : RecyclerView.Adapter<MenuItemAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_item, parent, false)
        return ViewHolder(view, owner)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(item[position])
    }

    override fun getItemCount(): Int {
        return item.size
    }


    class ViewHolder(itemView: View, val owner: RestaurantMenuActivity?): RecyclerView.ViewHolder(itemView){
        fun bindItems(item: MenuItem){
            val nombre = itemView.findViewById<MaterialTextView>(R.id.menu_item_name)
            val image = itemView.findViewById<ImageView>(R.id.menu_item_image)
            val description = itemView.findViewById<MaterialTextView>(R.id.menu_item_description)
            val price = itemView.findViewById<MaterialTextView>(R.id.menu_item_price)
            nombre.text = item.name
            if(item.image != ""){
                Picasso.get().load(item.image).resize(250,250).centerCrop().into(image)
            }
            description.text = item.description
            price.text = owner!!.getString(R.string.price, item.price.toString())
            itemView.setOnClickListener {
                Utilities.selectedMenuItem = item
                Log.d("hola", "hola")
                owner.setupMenuItemFragment()
                /*val intent = Intent(cont, BrowseRestaurantsActivity::class.java)
                intent.putExtra("searchInput", item.name)
                cont!!.startActivity(intent)*/
            }
        }
    }
}