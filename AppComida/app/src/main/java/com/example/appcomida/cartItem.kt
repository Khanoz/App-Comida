package com.example.appcomida

import com.google.firebase.firestore.Exclude

data class cartItem(
    val item: MenuItem?,
    val quantity: Int?,
    val specialInstructions: String?){
    @Exclude
    @set:Exclude
    @get:Exclude
    var uid: String? = null
    constructor(): this(null,null, null)
}