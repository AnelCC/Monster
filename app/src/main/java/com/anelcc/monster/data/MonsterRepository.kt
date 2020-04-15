package com.anelcc.monster.data

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.anelcc.monster.LOG_TAG
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
        Log.i(LOG_TAG, "Anel Network available: ${networkAvailable()}")

    }

    fun getMonsterData() {
        val assetsText = FileHelper.getTextFromAssets(app, "monster_data.json" )
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val adapter: JsonAdapter<List<Monster>> = moshi.adapter(listType)
        monsterData.value = adapter.fromJson(assetsText) ?: emptyList()
    }

    @Suppress("DEPRECATION")
    private fun networkAvailable(): Boolean {
        val connectivityManager = app.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo?.isConnectedOrConnecting ?: false
    }
}