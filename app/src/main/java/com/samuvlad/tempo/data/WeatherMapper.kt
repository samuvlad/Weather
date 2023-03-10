package com.samuvlad.tempo.data

import com.samuvlad.tempo.data.api.model.WeatherApi
import com.samuvlad.tempo.data.base.Mapper
import com.samuvlad.tempo.domain.model.Weather

class WeatherMapper: Mapper<WeatherApi, Weather> {
    override fun map(mode: WeatherApi): Weather {
        return Weather()
    }
}