package com.example.weatherid.Utils;
import com.example.weatherid.Models.ResponseGetByName;
import com.example.weatherid.Models.ResponseLatLon;
import java.util.ArrayList;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SharedPreferenceUtils {

    private static final String PREF_NAME = "MyPrefs";
    private static final String KEY_MY_LIST = "myList";

    void saveNameResult(Context context , List<ResponseGetByName> responseGetByNames){
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(responseGetByNames);
        editor.putString("listnames",json);
        editor.apply();
    }

    public List<ResponseGetByName> loadListResponseName(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String json = sharedPreferences.getString("listnames","");

        if (!json.isEmpty()) {
            // Convert JSON String back to ArrayList
            Gson gson = new Gson();
            Type type = new TypeToken<List<ResponseGetByName>>() {}.getType();
            return gson.fromJson(json,type);
        } else {
            return new ArrayList<>();
        }
    }
    void saveLatLonResult(Context context , ResponseLatLon responseGetByLatLon){
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        // Serialize the object to JSON
        Gson gson = new Gson();
        String json = gson.toJson(responseGetByLatLon);
        editor.putString("myObject",json);
        editor.apply();
    }

   public ResponseLatLon loadLatLonResult(Context context){
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        // Retrieve JSON String
        String json = prefs.getString("myObject", "");

        if (!json.isEmpty()) {
            // Deserialize JSON String back to the object
            Gson gson = new Gson();
            return gson.fromJson(json,ResponseLatLon.class);
        } else {
            // Return a default object or handle the absence of data
            return null;
        }

    }


}
