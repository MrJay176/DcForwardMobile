package com.example.weatherid.Models

class Wind {
    var deg = 0.0
    var speed = 0.0
    override fun toString(): String {
        return "Wind{" +
                "deg = '" + deg + '\'' +
                ",speed = '" + speed + '\'' +
                "}"
    }
}
