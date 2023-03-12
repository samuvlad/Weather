package com.samuvlad.tempo.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.samuvlad.tempo.data.database.model.WeatherDatabaseEntity
import com.samuvlad.tempo.data.database.dao.WeatherDao

@Database(entities = [WeatherDatabaseEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}