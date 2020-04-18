package com.anelcc.monster.ui.share

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.anelcc.monster.data.Monster
import com.anelcc.monster.data.MonsterRepository

class ShareViewModel(app: Application) : AndroidViewModel(app) {
   private val dataRepo = MonsterRepository(app)
    val monsterData = dataRepo.monsterData

    val selectedMonster = MutableLiveData<Monster>()

    fun refreshData() {
        dataRepo.refreshData()
    }

}