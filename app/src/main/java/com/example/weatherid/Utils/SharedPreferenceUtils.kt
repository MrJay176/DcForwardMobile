package com.example.weatherid.Utils

import android.content.Context
import com.example.weatherid.Models.ResponseGetByName
import com.example.weatherid.Models.ResponseLatLon
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SharedPreferenceUtils {
    fun saveNameResult(context: Context, responseGetByNames: List<ResponseGetByName?>?) {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = prefs.edit()
        val gson = Gson()
        val json = gson.toJson(responseGetByNames)
        editor.putString("listnames", json)
        editor.apply()
    }

    fun loadListResponseName(context: Context): List<ResponseGetByName> {
        val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val json = sharedPreferences.getString("listnames", "")
        return if (!json!!.isEmpty()) {
            // Convert JSON String back to ArrayList
            val gson = Gson()
            val type = object :
                TypeToken<List<ResponseGetByName?>?>() {}.type
            gson.fromJson(json, type)
        } else {
            ArrayList()
        }
    }

    fun saveLatLonResult(context: Context, responseGetByLatLon: ResponseLatLon?) {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = prefs.edit()
        // Serialize the object to JSON
        val gson = Gson()
        val json = gson.toJson(responseGetByLatLon)
        editor.putString("myObject", json)
        editor.apply()
    }

    fun loadLatLonResult(context: Context): ResponseLatLon? {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

        // Retrieve JSON String
        val json = prefs.getString("myObject", "")
        return if (!json!!.isEmpty()) {
            // Deserialize JSON String back to the object
            val gson = Gson()
            gson.fromJson(json, ResponseLatLon::class.java)
        } else {
            // Return a default object or handle the absence of data
            null
        }
    }

    companion object {
        private const val PREF_NAME = "MyPrefs"
        private const val KEY_MY_LIST = "myList"
    }
}
