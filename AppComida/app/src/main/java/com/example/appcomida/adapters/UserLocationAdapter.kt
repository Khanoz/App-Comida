package com.example.appcomida.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appcomida.R
import com.example.appcomida.dataClasses.UserLocation
import com.google.android.material.textview.MaterialTextView

class UserLocationAdapter(val location: List<UserLocation>, val cont : Context) : RecyclerView.Adapter<UserLocationAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_location, parent, false)
        return ViewHolder(view, cont)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(location[position])
    }

    override fun getItemCount(): Int {
        return location.size
    }


    class ViewHolder(itemView: View, val cont: Context?): RecyclerView.ViewHolder(itemView){
        fun bindItems(location: UserLocation){
            val nombre = itemView.findViewById<MaterialTextView>(R.id.name)
            val address = itemView.findViewById<MaterialTextView>(R.id.address)
            val address_number = itemView.findViewById<MaterialTextView>(R.id.address_number)
            nombre.text = location.name
            address.text = location.address
            address_number.text = location.addressNumberInfo
        }
    }
}