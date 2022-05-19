package com.example.appcomida.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appcomida.dataClasses.Order
import com.example.appcomida.R
import com.google.android.material.textview.MaterialTextView

class OrderAdapter(val cart: List<Order>, val cont : Context) : RecyclerView.Adapter<OrderAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.order, parent, false)
        return ViewHolder(view, cont)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(cart[position])
    }

    override fun getItemCount(): Int {
        return cart.size
    }


    class ViewHolder(itemView: View, val cont: Context?): RecyclerView.ViewHolder(itemView){
        fun bindItems(order: Order){
            val nombre = itemView.findViewById<MaterialTextView>(R.id.name)
            val subtotalTV = itemView.findViewById<MaterialTextView>(R.id.subtotal)
            val itemsTV = itemView.findViewById<MaterialTextView>(R.id.items)
            nombre.text = order.restaurant_name
            var items: String? = ""
            var subtotal: Int? = 0
            order.names.forEachIndexed { index, name ->
                items += name+" - "
                subtotal = subtotal!! + (order.prices[index]!! * order.quantities[index]!!)
            }
            subtotalTV.text = cont!!.getString(R.string.price, subtotal.toString())
            itemsTV.text = items
        }
    }
}