package com.example.appcomida.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appcomida.activities.BrowseRestaurantsActivity
import com.example.appcomida.dataClasses.Category
import com.example.appcomida.R
import com.squareup.picasso.Picasso

class CategoryAdapter(val categories: List<Category>, val cont : Context) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category, parent, false)
        return ViewHolder(view, cont)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(categories[position])
    }

    override fun getItemCount(): Int {
        return categories.size
    }


    class ViewHolder(itemView: View, val cont: Context?): RecyclerView.ViewHolder(itemView){
        fun bindItems(category: Category){
            val nombre = itemView.findViewById<TextView>(R.id.name)
            val image = itemView.findViewById<ImageView>(R.id.image)
            nombre.text = category.name
            Picasso.get().load(category.image).resize(250,250).centerCrop().into(image)
            itemView.setOnClickListener {
                val intent = Intent(cont, BrowseRestaurantsActivity::class.java)
                intent.putExtra("searchInput", category.name)
                cont!!.startActivity(intent)
            }
        }
    }
}