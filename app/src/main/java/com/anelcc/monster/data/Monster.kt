package com.anelcc.monster.data

import com.google.gson.annotations.SerializedName

data class Monster (
    @SerializedName("monsterName")
    val name: String,
    val imageFile: String,
    val caption: String,
    val description: String,
    val price: Double,
    val scariness: Int
)
