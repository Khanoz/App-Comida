package com.example.appcomida.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appcomida.activities.PayActivity
import com.example.appcomida.R
import com.example.appcomida.Utilities
import com.example.appcomida.adapters.CartAdapter
import com.example.appcomida.databinding.FragmentCartBinding
import com.example.appcomida.models.CartViewModel

class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val recyclerView: RecyclerView? = requireView().findViewById(R.id.recyclerView)
        recyclerView!!.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        val adapter = CartAdapter(Utilities.userCart.items, requireContext())
        recyclerView.adapter = adapter
        requireView().findViewById<TextView>(R.id.subtotal).text = requireContext().getString(R.string.price, Utilities.Subtotal().toString())
        getView()?.findViewById<Button>(R.id.go_to_pay_btn)?.setOnClickListener {
            val intent = Intent(activity, PayActivity::class.java)
            startActivity(intent)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(CartViewModel::class.java)

        _binding = FragmentCartBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}