package com.example.weatherid.Models

class Main {
    var temp: Any? = null
    var tempMin = 0.0
    var humidity = 0.0
    var pressure = 0.0
    var feelsLike: Any? = null
    var tempMax: Any? = null
    override fun toString(): String {
        return "Main{" +
                "temp = '" + temp + '\'' +
                ",temp_min = '" + tempMin + '\'' +
                ",humidity = '" + humidity + '\'' +
                ",pressure = '" + pressure + '\'' +
                ",feels_like = '" + feelsLike + '\'' +
                ",temp_max = '" + tempMax + '\'' +
                "}"
    }
}
