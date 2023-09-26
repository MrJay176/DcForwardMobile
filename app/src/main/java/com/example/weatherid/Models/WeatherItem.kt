package com.example.weatherid.Models

class WeatherItem {
    var icon: String? = null
    var description: String? = null
    var main: String? = null
    var id = 0.0
        private set

    fun setId(id: Int) {
        this.id = id.toDouble()
    }

    override fun toString(): String {
        return "WeatherItem{" +
                "icon = '" + icon + '\'' +
                ",description = '" + description + '\'' +
                ",main = '" + main + '\'' +
                ",id = '" + id + '\'' +
                "}"
    }
}
