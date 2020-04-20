package com.anelcc.monster.utilities

import android.app.Application
import android.content.Context
import java.io.File

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

        fun getTextFromAssets(context: Context, fileName: String): String {
            return context.assets.open(fileName).use {
                it.bufferedReader().use {
                    it.readText()
                }
            }
        }

        fun saveTextToFile(app: Application, json: String?) {
            val file = File(app.cacheDir, "monsters.json")
            file.writeText(json ?: "", Charsets.UTF_8)
        }
    }
}