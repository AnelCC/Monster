package com.anelcc.monster.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.anelcc.monster.IMAGE_BASE_URL
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

@Entity(tableName = "monsters")
data class Monster (
    @PrimaryKey(autoGenerate = true)
    val monsterId: Int,
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
