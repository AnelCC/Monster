package com.anelcc.monster

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.anelcc.monster.data.MonsterRepository

class MainViewModel(app: Application) : AndroidViewModel(app) {

    init {
        val monsterData = MonsterRepository().getMonsterData(app)
        for (monster in monsterData ?: emptyList()) {
            Log.i(LOG_TAG, "parseText: ${monster.name} (\$${monster.price})")
        }
    }
}
