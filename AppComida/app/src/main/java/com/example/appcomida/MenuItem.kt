package com.example.appcomida

import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.GeoPoint

data class MenuItem(
    val name:String?,
    val image: String? = null,
    val description: String?,
    val price: Int?){
    @Exclude
    @set:Exclude
    @get:Exclude
    var uid: String? = null
    constructor(): this(null,null,null,null)
}