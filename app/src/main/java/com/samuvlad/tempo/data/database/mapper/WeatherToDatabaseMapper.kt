package com.samuvlad.tempo.data.database.mapper

import com.samuvlad.tempo.data.base.Mapper
import com.samuvlad.tempo.data.database.model.WeatherDatabaseEntity
import com.samuvlad.tempo.domain.model.Weather

class WeatherToDatabaseMapper: Mapper<Weather, WeatherDatabaseEntity> {
    override fun map(mode: Weather): WeatherDatabaseEntity {
        return WeatherDatabaseEntity(
            id = 0,
            idCity = mode.id,
            name = mode.name,
            cod = mode.cod,
            timezone = mode.timezone,
            country = mode.country,
            sunset = mode.sunset,
            sunrise = mode.sunrise,
            dt = mode.dt,
            clouds = mode.clouds,
            windSpeed = mode.windSpeed,
            visibility = mode.visibility,
            temp = mode.temp,
            tempMax = mode.tempMax,
            tempMin = mode.tempMin,
            pressure = mode.pressure,
            humidity = mode.humidity,
            seaLeve = mode.seaLeve,
            grndLevel = mode.grndLevel,
            base = mode.base,
            main = mode.main,
            feelsLike = mode.feelsLike,
            description = mode.description,
            lat = mode.lat,
            lon = mode.lon
        )
    }
}