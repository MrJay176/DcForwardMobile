package com.example.weatherid.Models

class Sys {
    var country: String? = null
    var sunrise = 0.0
        private set
    var sunset = 0.0
        private set
    var id = 0.0
        private set
    var type = 0.0
        private set

    fun setSunrise(sunrise: Int) {
        this.sunrise = sunrise.toDouble()
    }

    fun setSunset(sunset: Int) {
        this.sunset = sunset.toDouble()
    }

    fun setId(id: Int) {
        this.id = id.toDouble()
    }

    fun setType(type: Int) {
        this.type = type.toDouble()
    }

    override fun toString(): String {
        return "Sys{" +
                "country = '" + country + '\'' +
                ",sunrise = '" + sunrise + '\'' +
                ",sunset = '" + sunset + '\'' +
                ",id = '" + id + '\'' +
                ",type = '" + type + '\'' +
                "}"
    }
}
