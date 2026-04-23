package com.jnetai.patentmonitor.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jnetai.patentmonitor.model.*

@Database(entities = [Patent::class, Trademark::class, Reminder::class], version = 1, exportSchema = false)
abstract class PatentMonitorDatabase : RoomDatabase() {
    abstract fun dao(): PatentMonitorDao
    companion object {
        @Volatile private var INSTANCE: PatentMonitorDatabase? = null
        fun getInstance(context: Context): PatentMonitorDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: Room.databaseBuilder(context, PatentMonitorDatabase::class.java, "patentmonitor.db")
                .fallbackToDestructiveMigration().build().also { INSTANCE = it }
        }
    }
}