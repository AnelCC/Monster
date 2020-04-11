package com.anelcc.monster

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.anelcc.monster.utilities.FileHelper


class MainViewModel(app: Application) : AndroidViewModel(app) {
    // TODO: Implement the ViewModel
    init {
        val text = FileHelper.getTextFromResources(app, R.raw.monster_data)
        Log.i(LOG_TAG, text)
    }
}
