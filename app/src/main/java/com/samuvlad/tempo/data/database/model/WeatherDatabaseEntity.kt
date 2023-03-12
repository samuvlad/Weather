package com.samuvlad.tempo.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WeatherDatabaseEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    var idCity: Long,
    var name: String,
    var cod: Int,
    var timezone: Long,
    var country: String,
    var sunset: Long,
    var sunrise: Long,
    var dt: Long,
    var clouds: Int,
    var windSpeed: Float,
    var visibility: Int,
    var temp: Float,
    var feelsLike: Float,
    var tempMin: Float,
    var tempMax: Float,
    var pressure: Int,
    var humidity: Int,
    var seaLeve: Int,
    var grndLevel: Int,
    var base: String,
    var main: String,
    var description: String,
    var lat: Long,
    var lon: Long
)