package com.example.weatherid.Interface

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherInterface {
    @GET("/geo/1.0/direct")
    fun getWeatherDetilsByName(
        @Query("q") q: String?,
        @Query("limit") limit: String?,
        @Query("appid") appId: String?
    ): Call<ResponseBody?>?

    @GET("/data/2.5/weather")
    fun getWithLatitudeAndLongitude(
        @Query("lat") lat: String?,
        @Query("lon") lon: String?,
        @Query("appid") appId: String?
    ): Call<ResponseBody?>?
}
