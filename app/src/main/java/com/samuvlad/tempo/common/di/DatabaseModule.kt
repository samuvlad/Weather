package com.samuvlad.tempo.common.di

import android.content.Context
import androidx.room.Room
import com.samuvlad.tempo.data.database.AppDatabase
import com.samuvlad.tempo.data.database.dao.WeatherDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun providerDatabase(@ApplicationContext appContext: Context): AppDatabase{
        return Room.databaseBuilder(
                appContext,
        AppDatabase::class.java, "database"
        ).build()
    }

    @Singleton
    @Provides
    fun providerWeatherDao(appDatabase: AppDatabase): WeatherDao{
        return appDatabase.weatherDao()
    }


}