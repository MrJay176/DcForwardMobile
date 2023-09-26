package com.example.weatherid.Models;

public class Clouds{
	private double all;

	public void setAll(int all){
		this.all = all;
	}

	public double getAll(){
		return all;
	}

	@Override
 	public String toString(){
		return 
			"Clouds{" + 
			"all = '" + all + '\'' + 
			"}";
		}
}
