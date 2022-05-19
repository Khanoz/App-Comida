package com.example.appcomida.dataClasses

import com.google.firebase.firestore.Exclude
import java.util.*

data class Category(
    val name:String?,
    val image: String? = null){
    @Exclude
    @set:Exclude
    @get:Exclude
    var uid: String? = null
    constructor(): this(null,null)
}