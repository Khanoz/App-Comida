package com.example.appcomida

import com.google.firebase.firestore.Exclude

data class userCart(
    val items: MutableList<cartItem>){
    @Exclude
    @set:Exclude
    @get:Exclude
    var uid: String? = null
    constructor(): this(arrayListOf())
}