package com.example.appcomida

import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.GeoPoint


data class UserLocation(
    val name:String?,
    val address: String?,
    val addressNumberInfo: String?,
    val zipCode: String?,
    val geoPoint: GeoPoint?){
    @Exclude
    @set:Exclude
    @get:Exclude
    var uid: String? = null
    constructor(): this(null,null, null, null, null)
}