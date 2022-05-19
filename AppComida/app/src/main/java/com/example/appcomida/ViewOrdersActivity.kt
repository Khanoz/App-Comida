package com.example.appcomida

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appcomida.adapters.CartAdapter
import com.example.appcomida.adapters.MenuItemAdapter
import com.example.appcomida.adapters.OrderAdapter
import org.w3c.dom.Text

class ViewOrdersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_orders)

        val recyclerView: RecyclerView? = findViewById(R.id.recyclerView)
        recyclerView!!.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        Utilities.usersRef.document(Utilities.userID).collection("orders").get()
            .addOnSuccessListener {
                val order = it!!.toObjects(Order::class.java)
                order.forEachIndexed { index, post ->
                    post.uid = it.documents[index].id
                }
                val adapter = OrderAdapter(order, this)
                recyclerView.adapter = adapter
            }
            .addOnFailureListener {
                findViewById<LinearLayout>(R.id.parent).gravity = Gravity.CENTER
                findViewById<LinearLayout>(R.id.rv_container).visibility = View.GONE
                val tv = findViewById<TextView>(R.id.status)
                tv.visibility = View.VISIBLE
                tv.text = getString(R.string.unavailable_orders)
            }

    }
}