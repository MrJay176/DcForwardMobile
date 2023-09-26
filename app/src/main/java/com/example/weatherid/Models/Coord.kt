package com.example.weatherid.Models

class Coord {
    var lon: Any? = null
    var lat: Any? = null
    override fun toString(): String {
        return "Coord{" +
                "lon = '" + lon + '\'' +
                ",lat = '" + lat + '\'' +
                "}"
    }
}
