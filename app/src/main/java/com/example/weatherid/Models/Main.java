package com.example.weatherid.Models;

public class Main{
	private Object temp;
	private double tempMin;
	private double humidity;
	private double pressure;
	private Object feelsLike;
	private Object tempMax;

	public void setTemp(Object temp){
		this.temp = temp;
	}

	public Object getTemp(){
		return temp;
	}

	public void setTempMin(double tempMin){
		this.tempMin = tempMin;
	}

	public double getTempMin(){
		return tempMin;
	}

	public void setHumidity(double humidity){
		this.humidity = humidity;
	}

	public double getHumidity(){
		return humidity;
	}

	public void setPressure(double pressure){
		this.pressure = pressure;
	}

	public double getPressure(){
		return pressure;
	}

	public void setFeelsLike(Object feelsLike){
		this.feelsLike = feelsLike;
	}

	public Object getFeelsLike(){
		return feelsLike;
	}

	public void setTempMax(Object tempMax){
		this.tempMax = tempMax;
	}

	public Object getTempMax(){
		return tempMax;
	}

	@Override
 	public String toString(){
		return 
			"Main{" + 
			"temp = '" + temp + '\'' + 
			",temp_min = '" + tempMin + '\'' + 
			",humidity = '" + humidity + '\'' + 
			",pressure = '" + pressure + '\'' + 
			",feels_like = '" + feelsLike + '\'' + 
			",temp_max = '" + tempMax + '\'' + 
			"}";
		}
}
