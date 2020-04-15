package com.anelcc.monster

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.anelcc.monster.data.Monster
import com.anelcc.monster.data.MonsterRepository
import com.anelcc.monster.utilities.FileHelper
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class MainViewModel(app: Application) : AndroidViewModel(app) {

    init {
        val monsterData = MonsterRepository().getMonsterData(app)
        for (monster in monsterData ?: emptyList()) {
            Log.i(LOG_TAG,"parseText: ${monster.name} (\$${monster.price})")
        }
    }
}
