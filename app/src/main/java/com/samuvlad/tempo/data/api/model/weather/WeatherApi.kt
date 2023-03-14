package com.samuvlad.tempo.data.api.model.weather

data class WeatherApi(
    val coord: Coord, val weather: List<WeatherIn>, val base: String,
    val main: Main, val visibility: Int, val wind: Wind, val clouds: Clouds, val dt: Long,
    val sys: Sys, val timezone: Long, val id: Long, val name: String, val cod: Int
)