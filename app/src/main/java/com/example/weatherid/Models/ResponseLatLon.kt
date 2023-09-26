package com.example.weatherid.Models

class ResponseLatLon {
    var visibility = 0.0
    var timezone = 0.0
    var main: Main? = null
    var clouds: Clouds? = null
    var sys: Sys? = null
    var dt = 0.0
        private set
    var coord: Coord? = null
    var weather: List<WeatherItem>? = null
    var name: String? = null
    var cod = 0.0
        private set
    var id = 0.0
        private set
    var base: String? = null
    var wind: Wind? = null
    fun setDt(dt: Int) {
        this.dt = dt.toDouble()
    }

    fun setCod(cod: Int) {
        this.cod = cod.toDouble()
    }

    fun setId(id: Int) {
        this.id = id.toDouble()
    }

    override fun toString(): String {
        return "ResponseLatLon{" +
                "visibility = '" + visibility + '\'' +
                ",timezone = '" + timezone + '\'' +
                ",main = '" + main + '\'' +
                ",clouds = '" + clouds + '\'' +
                ",sys = '" + sys + '\'' +
                ",dt = '" + dt + '\'' +
                ",coord = '" + coord + '\'' +
                ",weather = '" + weather + '\'' +
                ",name = '" + name + '\'' +
                ",cod = '" + cod + '\'' +
                ",id = '" + id + '\'' +
                ",base = '" + base + '\'' +
                ",wind = '" + wind + '\'' +
                "}"
    }
}
