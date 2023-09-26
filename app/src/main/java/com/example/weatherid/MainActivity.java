package com.example.weatherid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import android.widget.ImageView;
import com.example.weatherid.Controllers.WeatherApiController;
import com.example.weatherid.Models.ResponseGetByName;
import com.example.weatherid.Models.ResponseLatLon;
import com.example.weatherid.Utils.Constant;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ExecutorService executorService;
    WeatherApiController weatherApiController;

    Call<ResponseBody> responseWeatherName;
    Call<ResponseBody> responseLatitudeLongitude;

    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> arrayAdapter;


    ImageView imageViewDisplay;

    ResponseLatLon responseGetByLatLon;

    TextView country;
    TextView textWeatherDescription;
    TextView textWeatherMain;

    TextView textTemp;

    TextView textHumidity;

    TextView textViewPressure;

    TextView textViewDegree;

    String imageUrl = "https://openweathermap.org/img/wn/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewDegree = findViewById(R.id.degree);
        country = findViewById(R.id.country);
        textTemp = findViewById(R.id.temp);
        textHumidity = findViewById(R.id.humidity);
        textViewPressure = findViewById(R.id.pressure);
        imageViewDisplay = findViewById(R.id.imgDisplay);
        textWeatherDescription = findViewById(R.id.weather_description);
        textWeatherMain = findViewById(R.id.weather_main);
        autoCompleteTextView = findViewById(R.id.auto_complete_txt);

        arrayAdapter = new ArrayAdapter<String>(this,R.layout.list_item,Constant.returnListOfStates());
        autoCompleteTextView.setAdapter(arrayAdapter);
        weatherApiController = new WeatherApiController();
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this,item,Toast.LENGTH_LONG).show();
                String city = item+",USA";
                Log.d("TOAST", "onItemClick:  "+city);
                responseWeatherName = weatherApiController.getWeatherDetailsByName(city);
                backGroundCall(responseWeatherName);
            }
        });



    }

    private void backGroundCall(Call<ResponseBody> responseWeatherName) {
        responseWeatherName.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                // Handle successful response
                ResponseBody data = response.body();
                Gson gson = new Gson();
                ArrayList<ResponseGetByName> responseGetByName;
                try {
                    TypeToken<List<ResponseGetByName>> listType = new TypeToken<List<ResponseGetByName>>() {};
                    responseGetByName = gson.fromJson(data.string(),listType.getType());
                    String latitude = responseGetByName.get(0).getLat().toString();
                    String longitude = responseGetByName.get(0).getLon().toString();
                    //Log.d("backGroundCall","Latitude "+latitude+"Longitude"+longitude+data.string());
                    responseLatitudeLongitude = weatherApiController.getWeatherByLatLon(latitude,longitude);
                    backGroundCheckLatLong(responseLatitudeLongitude);
                }catch (IOException e){}
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void backGroundCheckLatLong(Call<ResponseBody> responseLatitudeLongitude ){
        responseLatitudeLongitude.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                ResponseBody data = response.body();
                Gson gson = new Gson();

                JSONObject jsonObject = null;
                try{
                    jsonObject = new JSONObject(data.string());
                    responseGetByLatLon = gson.fromJson(jsonObject.toString(),ResponseLatLon.class);

                    country.setText(""+responseGetByLatLon.getName());
                    textViewDegree.setText("+"+responseGetByLatLon.getMain().getTemp()+"°");
                    textViewPressure.setText(""+responseGetByLatLon.getMain().getPressure());
                    textTemp.setText(""+responseGetByLatLon.getMain().getTemp());
                    textWeatherDescription.setText(responseGetByLatLon.getWeather().get(0).getDescription());
                    textWeatherMain.setText(responseGetByLatLon.getWeather().get(0).getMain());
                    textHumidity.setText(""+responseGetByLatLon.getMain().getHumidity());
                    String icon = responseGetByLatLon.getWeather().get(0).getIcon();
                    String newUrl = "https://openweathermap.org/img/wn/"+icon+"@2x.png";
                    Log.d("backGroundLatLon","body "+newUrl);
                    Picasso.get()
                            .load(newUrl)
                            .into(imageViewDisplay);

                }catch (Exception e){
                    Log.d("backGroundLatLon","body "+e.getMessage());

                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

}
