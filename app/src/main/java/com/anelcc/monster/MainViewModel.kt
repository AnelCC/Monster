package com.anelcc.monster

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.anelcc.monster.data.MonsterRepository

class MainViewModel(app: Application) : AndroidViewModel(app) {

   /*
   The ViewModel is simply passing that LiveData object back to the user interface.
   And the fragment, that is the user interface,
   is only responsible for managing the presentation.
    */
   private val dataRepo = MonsterRepository(app)
    val monsterData = dataRepo.monsterData
}
