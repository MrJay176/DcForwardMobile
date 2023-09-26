package com.example.weatherid.Controllers

import com.example.weatherid.Interface.WeatherInterface
import com.example.weatherid.Utils.Constant
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherApiController {
    var retrofit: Retrofit
    var weatherInterface: WeatherInterface

    init {
        retrofit = Retrofit.Builder().baseUrl(Constant.Base_Url)
            .addConverterFactory(GsonConverterFactory.create()).build()
        weatherInterface = retrofit.create(WeatherInterface::class.java)
    }

    fun getWeatherDetailsByName(name: String?): Call<ResponseBody> {
        return weatherInterface.getWeatherDetilsByName(name, "7", Constant.APP_ID)
    }

    fun getWeatherByLatLon(latitude: String?, longitude: String?): Call<ResponseBody> {
        return weatherInterface.getWithLatitudeAndLongitude(latitude, longitude, Constant.APP_ID)
    }
}
