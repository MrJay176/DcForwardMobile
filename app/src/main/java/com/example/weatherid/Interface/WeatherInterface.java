package com.example.weatherid.Interface;

import com.example.weatherid.Utils.Constant;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeatherInterface {

    @GET("/geo/1.0/direct")
    Call<ResponseBody> getWeatherDetilsByName(
             @Query("q") String q,
             @Query("limit") String limit,
             @Query("appid") String appId
            );

    @GET("/data/2.5/weather")
    Call<ResponseBody> getWithLatitudeAndLongitude(
         @Query("lat") String lat,
         @Query("lon")  String lon,
         @Query("appid") String appId
    );

}
