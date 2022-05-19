package com.example.appcomida.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appcomida.*
import com.example.appcomida.activities.BrowseRestaurantsActivity
import com.example.appcomida.adapters.CategoryAdapter
import com.example.appcomida.dataClasses.Category
import com.example.appcomida.databinding.FragmentBrowseBinding
import com.example.appcomida.models.BrowseViewModel
import com.google.android.material.textfield.TextInputEditText

class BrowseFragment : Fragment() {

    private var _binding: FragmentBrowseBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(BrowseViewModel::class.java)

        _binding = FragmentBrowseBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireView().findViewById<TextInputEditText>(R.id.search_input).setOnEditorActionListener { v, actionId, event ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_SEARCH -> {
                    val intent = Intent(context, BrowseRestaurantsActivity::class.java)
                    intent.putExtra("searchInput", v.text.toString())
                    startActivity(intent)

                    true
                }
                else -> false
            }
        }
        val recyclerView: RecyclerView? = requireView().findViewById(R.id.recyclerView)
        recyclerView!!.layoutManager = GridLayoutManager(requireContext(),2)
        Utilities.categoriesRef.get().addOnSuccessListener {

            val category = it!!.toObjects(Category::class.java)

            category.forEachIndexed { index, post ->
                post.uid = it.documents[index].id
            }
            val adapter = CategoryAdapter(category, requireContext())
            recyclerView.adapter = adapter
        }
    }
}