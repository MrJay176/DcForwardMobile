package com.example.weatherid

import android.os.Bundle
import android.util.Log
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherid.Controllers.WeatherApiController
import com.example.weatherid.Models.ResponseGetByName
import com.example.weatherid.Models.ResponseLatLon
import com.example.weatherid.Utils.Constant.returnListOfStates
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.squareup.picasso.Picasso
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.util.concurrent.ExecutorService

class MainActivity : AppCompatActivity() {
    var executorService: ExecutorService? = null
    var weatherApiController: WeatherApiController? = null
    var responseWeatherName: Call<ResponseBody>? = null
    var responseLatitudeLongitude: Call<ResponseBody>? = null
    var autoCompleteTextView: AutoCompleteTextView? = null
    var arrayAdapter: ArrayAdapter<String>? = null
    var imageViewDisplay: ImageView? = null
    var responseGetByLatLon: ResponseLatLon? = null
    var country: TextView? = null
    var textWeatherDescription: TextView? = null
    var textWeatherMain: TextView? = null
    var textTemp: TextView? = null
    var textHumidity: TextView? = null
    var textViewPressure: TextView? = null
    var textViewDegree: TextView? = null
    var imageUrl = "https://openweathermap.org/img/wn/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewDegree = findViewById(R.id.degree)
        country = findViewById(R.id.country)
        textTemp = findViewById(R.id.temp)
        textHumidity = findViewById(R.id.humidity)
        textViewPressure = findViewById(R.id.pressure)
        imageViewDisplay = findViewById(R.id.imgDisplay)
        textWeatherDescription = findViewById(R.id.weather_description)
        textWeatherMain = findViewById(R.id.weather_main)
        autoCompleteTextView = findViewById(R.id.auto_complete_txt)
        arrayAdapter = ArrayAdapter(this, R.layout.list_item, returnListOfStates())
        autoCompleteTextView.setAdapter(arrayAdapter)
        weatherApiController = WeatherApiController()
        autoCompleteTextView.setOnItemClickListener(OnItemClickListener { parent, view, position, id ->
            val item = parent.getItemAtPosition(position).toString()
            Toast.makeText(this@MainActivity, item, Toast.LENGTH_LONG).show()
            val city = "$item,USA"
            Log.d("TOAST", "onItemClick:  $city")
            responseWeatherName = weatherApiController!!.getWeatherDetailsByName(city)
            backGroundCall(responseWeatherName!!)
        })
    }

    private fun backGroundCall(responseWeatherName: Call<ResponseBody>) {
        responseWeatherName.enqueue(object : Callback<ResponseBody?> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                // Handle successful response
                val data = response.body()
                val gson = Gson()
                val responseGetByName: ArrayList<ResponseGetByName>
                try {
                    val listType: TypeToken<List<ResponseGetByName>> =
                        object : TypeToken<List<ResponseGetByName?>?>() {}
                    responseGetByName = gson.fromJson(data!!.string(), listType.type)
                    val latitude = responseGetByName[0].lat.toString()
                    val longitude = responseGetByName[0].lon.toString()
                    //Log.d("backGroundCall","Latitude "+latitude+"Longitude"+longitude+data.string());
                    responseLatitudeLongitude =
                        weatherApiController!!.getWeatherByLatLon(latitude, longitude)
                    backGroundCheckLatLong(responseLatitudeLongitude!!)
                } catch (e: IOException) {
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {}
        })
    }

    private fun backGroundCheckLatLong(responseLatitudeLongitude: Call<ResponseBody>) {
        responseLatitudeLongitude.enqueue(object : Callback<ResponseBody?> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                val data = response.body()
                val gson = Gson()
                var jsonObject: JSONObject? = null
                try {
                    jsonObject = JSONObject(data!!.string())
                    responseGetByLatLon =
                        gson.fromJson(jsonObject.toString(), ResponseLatLon::class.java)
                    country!!.text = "" + responseGetByLatLon.name
                    textViewDegree!!.text = "+" + responseGetByLatLon.main!!.temp + "°"
                    textViewPressure!!.text = "" + responseGetByLatLon.main!!.pressure
                    textTemp!!.text = "" + responseGetByLatLon.main!!.temp
                    textWeatherDescription!!.text = responseGetByLatLon.weather!![0].description
                    textWeatherMain!!.text = responseGetByLatLon.weather!![0].main
                    textHumidity!!.text = "" + responseGetByLatLon.main!!.humidity
                    val icon = responseGetByLatLon.weather!![0].icon
                    val newUrl = "https://openweathermap.org/img/wn/$icon@2x.png"
                    Log.d("backGroundLatLon", "body $newUrl")
                    Picasso.get()
                        .load(newUrl)
                        .into(imageViewDisplay)
                } catch (e: Exception) {
                    Log.d("backGroundLatLon", "body " + e.message)
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {}
        })
    }
}
