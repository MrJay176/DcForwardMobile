package com.example.weatherid.Models;

public class ResponseGetByName{
	private String country;
	private String name;
	private Object lon;
	private String state;
	private Object lat;
	private LocalNames localNames;

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLon(Object lon){
		this.lon = lon;
	}

	public Object getLon(){
		return lon;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setLat(Object lat){
		this.lat = lat;
	}

	public Object getLat(){
		return lat;
	}

	public void setLocalNames(LocalNames localNames){
		this.localNames = localNames;
	}

	public LocalNames getLocalNames(){
		return localNames;
	}

	@Override
 	public String toString(){
		return 
			"ResponseGetByNameItem{" + 
			"country = '" + country + '\'' + 
			",name = '" + name + '\'' + 
			",lon = '" + lon + '\'' + 
			",state = '" + state + '\'' + 
			",lat = '" + lat + '\'' + 
			",local_names = '" + localNames + '\'' + 
			"}";
		}
}
