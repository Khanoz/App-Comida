package com.example.appcomida

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView
import com.squareup.picasso.Picasso

class MenuItemFragment : Fragment() {
    var quantity: Int = 1
    lateinit var quantityText: MaterialTextView
    lateinit var specialInstructionsText: TextInputEditText
    lateinit var addCartButton: MaterialButton

    companion object {
        fun newInstance() = MenuItemFragment()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        quantityText = requireView().findViewById(R.id.quantity)!!
        specialInstructionsText = requireView().findViewById(R.id.special_instructions)!!
        addCartButton = requireView().findViewById(R.id.add_to_cart_btn)
        setMenuItemValues()
        getView()?.findViewById<ImageButton>(R.id.back_btn)?.setOnClickListener {
            closeFragment()
        }
        getView()?.findViewById<ImageButton>(R.id.plus_one_btn)?.setOnClickListener {
            quantity+=1
            updateQuantityText()
        }
        getView()?.findViewById<ImageButton>(R.id.minus_one_btn)?.setOnClickListener {
            if(quantity>1.0){
                quantity-=1
                updateQuantityText()
            }
        }
        addCartButton.setOnClickListener {
            val instructions = specialInstructionsText.text.toString()
            Utilities.userCart.items.add(cartItem(Utilities.selectedMenuItem, quantity, instructions))
            closeFragment()
        }
    }

    fun closeFragment(){
        activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
    }

    fun updateQuantityText(){
        quantityText.text = getString(R.string.text, quantity.toString())
        addCartButton.text = getString(R.string.add_to_cart, quantity.toString(), (quantity*Utilities.selectedMenuItem.price!!).toString())
    }

    fun setMenuItemValues(){
        val menuItem = Utilities.selectedMenuItem

        if(menuItem.image != ""){
            Picasso.get().load(menuItem.image).into(view?.findViewById(R.id.item_image))
        }
        view?.findViewById<MaterialTextView>(R.id.item_name)!!.text = getString(R.string.text, menuItem.name)
        view?.findViewById<MaterialTextView>(R.id.item_price)!!.text = getString(R.string.price, menuItem.price.toString())
        view?.findViewById<MaterialTextView>(R.id.item_description)!!.text = getString(R.string.text, menuItem.description)
        updateQuantityText()
    }

}