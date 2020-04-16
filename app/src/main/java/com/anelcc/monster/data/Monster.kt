package com.anelcc.monster.data

import com.anelcc.monster.IMAGE_BASE_URL
import com.google.gson.annotations.SerializedName

data class Monster (
    @SerializedName("monsterName")
    val name: String,
    val imageFile: String,
    val caption: String,
    val description: String,
    val price: Double,
    val scariness: Int
){
    val imageUrl
        get() = "$IMAGE_BASE_URL/$imageFile.webp"
    val thumbnailUrl
        get() = "$IMAGE_BASE_URL/${imageFile}_tn.webp"
}
