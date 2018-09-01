package com.a4tech.shipping.model;

public class ShippingDetails {
   private String delivary;
   private String qty;
   private String materilaType;
   private double latitude ;
   private double longitude;
   private String date;
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
/**
 * @return the delivary
 */
public String getDelivary() {
	return delivary;
}
/**
 * @param delivary the delivary to set
 */
public void setDelivary(String delivary) {
	this.delivary = delivary;
}
/**
 * @return the qty
 */
public String getQty() {
	return qty;
}
/**
 * @param qty the qty to set
 */
public void setQty(String qty) {
	this.qty = qty;
}
/**
 * @return the materilaType
 */
public String getMaterilaType() {
	return materilaType;
}
/**
 * @param materilaType the materilaType to set
 */
public void setMaterilaType(String materilaType) {
	this.materilaType = materilaType;
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
