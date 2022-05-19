package com.example.appcomida.dataClasses

import com.google.firebase.firestore.Exclude

data class Order(
    val restaurant_name: String?,
    val names: MutableList<String?> = arrayListOf(),
    val prices: MutableList<Int?> = arrayListOf(),
    val quantities: MutableList<Int?> = arrayListOf(),
    val specialInstructions: MutableList<String?> = arrayListOf()){
    @Exclude
    @set:Exclude
    @get:Exclude
    var uid: String? = null
    constructor(): this(null, arrayListOf(),arrayListOf(), arrayListOf(), arrayListOf())
}