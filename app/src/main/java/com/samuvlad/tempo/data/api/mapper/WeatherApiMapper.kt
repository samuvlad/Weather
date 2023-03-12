package com.samuvlad.tempo.data.api.mapper

import com.samuvlad.tempo.data.api.model.weather.WeatherApi
import com.samuvlad.tempo.data.base.Mapper
import com.samuvlad.tempo.domain.model.Weather

class WeatherApiMapper : Mapper<WeatherApi, Weather> {
    override fun map(mode: WeatherApi): Weather {
        return Weather(
            id = mode.id,
            name = mode.name,
            cod = mode.cod,
            timezone = mode.timezone,
            country = mode.sys.country,
            sunset = mode.sys.sunset,
            sunrise = mode.sys.sunrise,
            dt = mode.dt,
            clouds = mode.clouds.all,
            windSpeed = mode.wind.speed,
            visibility = mode.visibility,
            temp = mode.main.temp,
            feelsLike = mode.main.feels_like,
            tempMin = mode.main.temp_min,
            tempMax = mode.main.temp_max,
            pressure = mode.main.pressure,
            humidity = mode.main.humidity,
            seaLeve = mode.main.sea_leve,
            grndLevel = mode.main.grnd_level,
            base = mode.base,
            main = mode.weather.main,
            description = mode.weather.description,
            lat = mode.coord.lat,
            lon = mode.coord.lon
        )
    }
}