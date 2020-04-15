package com.anelcc.monster.data

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.anelcc.monster.utilities.FileHelper
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

//I want an application reference.
class MonsterRepository(val app: Application) {

    //instance of the class MutableLiveData
    val monsterData = MutableLiveData<List<Monster>>()

    private val listType = Types.newParameterizedType(
        List::class.java, Monster::class.java
    )

    init {
        getMonsterData()
    }

    fun getMonsterData() {
        val assetsText = FileHelper.getTextFromAssets(app, "monster_data.json" )
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val adapter: JsonAdapter<List<Monster>> = moshi.adapter(listType)
        monsterData.value = adapter.fromJson(assetsText) ?: emptyList()
    }
}