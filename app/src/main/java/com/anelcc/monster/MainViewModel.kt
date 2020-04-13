package com.anelcc.monster

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.anelcc.monster.data.Monster
import com.anelcc.monster.utilities.FileHelper
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory


class MainViewModel(app: Application) : AndroidViewModel(app) {

    private val listType = Types.newParameterizedType(
        List::class.java, Monster::class.java
    )

    init {
        val resourcesText = FileHelper.getTextFromResources(app, R.raw.monster_data)
        Log.i(LOG_TAG, "Resources: $resourcesText")


        val assetsText = FileHelper.getTextFromAssets(app, "monster_data.json")
        Log.i(LOG_TAG, "Assets: $assetsText")

        parseText(assetsText)
    }

    fun parseText(text: String) {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val adapter: JsonAdapter<List<Monster>> = moshi.adapter(listType)
        //This is parsing the data
        val monsterData = adapter.fromJson(text)

        for (monster in monsterData ?: emptyList()) {
            Log.i(LOG_TAG,"parseText: ${monster.name} (\$${monster.price})")
        }
    }
}
