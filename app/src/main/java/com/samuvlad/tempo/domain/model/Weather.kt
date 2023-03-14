package com.samuvlad.tempo.domain.model

class Weather(
    var id: Long,
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
    var lat: Double,
    var lon: Double,
    var icon: String
)