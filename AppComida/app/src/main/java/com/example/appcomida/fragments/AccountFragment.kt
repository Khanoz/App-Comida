package com.example.appcomida.fragments

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.appcomida.*
import com.example.appcomida.activities.LocationsActivity
import com.example.appcomida.activities.ViewOrdersActivity
import com.example.appcomida.models.AccountViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AccountFragment : Fragment() {

    companion object {
        fun newInstance() = AccountFragment()
    }

    private lateinit var viewModel: AccountViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getView()?.findViewById<LinearLayout>(R.id.locations)?.setOnClickListener {
            val intent = Intent(activity, LocationsActivity::class.java)
            startActivity(intent)
        }
        getView()?.findViewById<LinearLayout>(R.id.orders)?.setOnClickListener {
            val intent = Intent(activity, ViewOrdersActivity::class.java)
            startActivity(intent)
        }
        requireView().findViewById<LinearLayout>(R.id.logout).setOnClickListener {
            val auth = Firebase.auth
            auth.signOut()
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AccountViewModel::class.java)
        // TODO: Use the ViewModel
    }

}