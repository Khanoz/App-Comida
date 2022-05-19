package com.example.appcomida.dataClasses

import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.GeoPoint

data class Restaurant(
    val name:String?,
    val image: String? = null,
    val openTime: String?,
    val closeTime: String?,
    val rating: Double?,
    val location: GeoPoint?,
    val categories: MutableList<String>?){
    @Exclude
    @set:Exclude
    @get:Exclude
    var uid: String? = null
    constructor(): this(null,null,null,null,null,null, null)
}