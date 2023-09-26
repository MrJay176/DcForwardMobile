package com.example.weatherid.Controllers;

import com.example.weatherid.Interface.WeatherInterface;
import com.example.weatherid.Utils.Constant;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherApiController {

    Retrofit retrofit;
    WeatherInterface weatherInterface;

     public WeatherApiController() {
        retrofit = new Retrofit.Builder().baseUrl(Constant.Base_Url)
                .addConverterFactory(GsonConverterFactory.create()).build();
        weatherInterface = retrofit.create(WeatherInterface.class);
    }

    public Call<ResponseBody> getWeatherDetailsByName(String name){
       return  weatherInterface.getWeatherDetilsByName(name,"7",Constant.APP_ID);
    }

    public Call<ResponseBody> getWeatherByLatLon(String latitude,String longitude){
         return weatherInterface.getWithLatitudeAndLongitude(latitude,longitude,Constant.APP_ID);
    }

}
