package com.example.weatherid.Models

class Clouds {
    var all = 0.0
        private set

    fun setAll(all: Int) {
        this.all = all.toDouble()
    }

    override fun toString(): String {
        return "Clouds{" +
                "all = '" + all + '\'' +
                "}"
    }
}
