package com.anelcc.monster

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.anelcc.monster.data.MonsterRepository

class MainViewModel(app: Application) : AndroidViewModel(app) {
   private val dataRepo = MonsterRepository(app)
    val monsterData = dataRepo.monsterData

    fun refreshData() {
        dataRepo.refreshData()
    }

}
