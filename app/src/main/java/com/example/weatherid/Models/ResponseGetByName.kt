package com.example.weatherid.Models

class ResponseGetByName {
    var country: String? = null
    var name: String? = null
    var lon: Any? = null
    var state: String? = null
    var lat: Any? = null
    var localNames: LocalNames? = null
    override fun toString(): String {
        return "ResponseGetByNameItem{" +
                "country = '" + country + '\'' +
                ",name = '" + name + '\'' +
                ",lon = '" + lon + '\'' +
                ",state = '" + state + '\'' +
                ",lat = '" + lat + '\'' +
                ",local_names = '" + localNames + '\'' +
                "}"
    }
}
