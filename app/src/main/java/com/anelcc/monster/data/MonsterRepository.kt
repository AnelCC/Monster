package com.anelcc.monster.data

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import com.anelcc.monster.LOG_TAG
import com.anelcc.monster.WEB_SERVICE_URL
import com.google.gson.GsonBuilder
import com.squareup.moshi.Types
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class MonsterRepository(val app: Application) {

    //instance of the class MutableLiveData
    val monsterData = MutableLiveData<List<Monster>>()
    private val listType = Types.newParameterizedType(
        List::class.java, Monster::class.java
    )

    init {
        //Co-routine scope pass in a dispatcher.
        // There are a number of different dispatchers available in the co-routines library,
        // but for Android you can typically choose between two.
        // Dispatchers.io means do this on the background thread,
        // while dispatchers.main means do it in the foreground thread.
        CoroutineScope(Dispatchers.IO).launch {
            callWebService()
        }
    }

    /**
     * WorkerThreat annotation. Is an indicator that this function will be called in a background threat.
     */
    @WorkerThread
    suspend fun callWebService() {
        if (networkAvailable()) {
            val retrofit = Retrofit.Builder()
                .baseUrl(WEB_SERVICE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
                .build()
            val service = retrofit.create(MonsterService::class.java)
            val serviceData = service.getMonsterData().body() ?: emptyList()
            monsterData.postValue(serviceData)
        }
    }

    @Suppress("DEPRECATION")
    private fun networkAvailable(): Boolean {
        val connectivityManager = app.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo?.isConnectedOrConnecting ?: false
    }
}