package com.example.appcomida.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.appcomida.R
import com.example.appcomida.cartItem
import com.google.android.material.textview.MaterialTextView
import com.squareup.picasso.Picasso

class PayAdapter(val cart: List<cartItem>, val cont : Context) : RecyclerView.Adapter<PayAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_item, parent, false)
        return ViewHolder(view, cont)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(cart[position])
    }

    override fun getItemCount(): Int {
        return cart.size
    }


    class ViewHolder(itemView: View, val cont: Context?): RecyclerView.ViewHolder(itemView){
        fun bindItems(item: cartItem){
            val nombre = itemView.findViewById<MaterialTextView>(R.id.name)
            val price = itemView.findViewById<MaterialTextView>(R.id.price)
            val spInstructions = itemView.findViewById<MaterialTextView>(R.id.special_instructions)
            nombre.text = cont!!.getString(R.string.cart_item_name, item.item!!.name, item.quantity.toString())
            price.text = cont.getString(R.string.price, (item.item.price!! * item.quantity!!).toString())
            spInstructions.text = item.specialInstructions
        }
    }
}