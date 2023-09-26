package com.example.weatherid.Models;

public class Sys{
	private String country;
	private double sunrise;
	private double sunset;
	private double id;
	private double type;

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setSunrise(int sunrise){
		this.sunrise = sunrise;
	}

	public double getSunrise(){
		return sunrise;
	}

	public void setSunset(int sunset){
		this.sunset = sunset;
	}

	public double getSunset(){
		return sunset;
	}

	public void setId(int id){
		this.id = id;
	}

	public double getId(){
		return id;
	}

	public void setType(int type){
		this.type = type;
	}

	public double getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"Sys{" + 
			"country = '" + country + '\'' + 
			",sunrise = '" + sunrise + '\'' + 
			",sunset = '" + sunset + '\'' + 
			",id = '" + id + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}
