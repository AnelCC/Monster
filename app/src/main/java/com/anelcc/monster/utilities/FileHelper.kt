package com.anelcc.monster.utilities

import android.content.Context

class FileHelper {
    //In java you create Static methods in Kotlin you function member of the companions
    companion object {
        fun getTextFromResources(context: Context, resourceId: Int): String {
            return context.resources.openRawResource(resourceId).use {
                it.bufferedReader().use {
                    it.readText()
                }
            }
        }
    }
}