package com.anelcc.monster.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Monster::class], version = 1, exportSchema = false)
abstract class MonsterDatabase : RoomDatabase() {
    abstract fun monsterDao(): MonsterDao

    companion object {
        @Volatile
        private var INSTANCE: MonsterDatabase? = null

        fun getDatabase(context: Context): MonsterDatabase {
            if (INSTANCE == null) {
                // Synchronized can only be called by one thread at a time.
                // Then I'll assign instance using this expression: room.databasebuilder.
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, MonsterDatabase::class.java, "monsters.db").build()
                }
            }
            return INSTANCE!!
        }
    }
}