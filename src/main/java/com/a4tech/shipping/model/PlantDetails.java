package com.a4tech.shipping.model;

public class PlantDetails {
   private String plantName;
   private String plantState;
   private double latitude ;
   private double longitude;
/**
 * @return the plantName
 */
public String getPlantName() {
	return plantName;
}
/**
 * @param plantName the plantName to set
 */
public void setPlantName(String plantName) {
	this.plantName = plantName;
}
/**
 * @return the plantState
 */
public String getPlantState() {
	return plantState;
}
/**
 * @param plantState the plantState to set
 */
public void setPlantState(String plantState) {
	this.plantState = plantState;
}
public double getLatitude() {
	return latitude;
}
public void setLatitude(double latitude) {
	this.latitude = latitude;
}
public double getLongitude() {
	return longitude;
}
public void setLongitude(double longitude) {
	this.longitude = longitude;
}
   
}
