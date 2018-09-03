package com.a4tech.shipping.model;

import java.util.List;

public class IntellishipModel {
  private String delivaryDate;
  private int    totalOrders;
  private String truckNum;
  private String truckCapacity;
  private String plant;
  private String totalKilometers;
  private List<ShippingDetails1> orderDetailsList;
public String getDelivaryDate() {
	return delivaryDate;
}
public void setDelivaryDate(String delivaryDate) {
	this.delivaryDate = delivaryDate;
}
public int getTotalOrders() {
	return totalOrders;
}
public void setTotalOrders(int totalOrders) {
	this.totalOrders = totalOrders;
}
public String getTruckNum() {
	return truckNum;
}
public void setTruckNum(String truckNum) {
	this.truckNum = truckNum;
}
public String getTruckCapacity() {
	return truckCapacity;
}
public void setTruckCapacity(String truckCapacity) {
	this.truckCapacity = truckCapacity;
}
public String getPlant() {
	return plant;
}
public void setPlant(String plant) {
	this.plant = plant;
}
public String getTotalKilometers() {
	return totalKilometers;
}
public void setTotalKilometers(String totalKilometers) {
	this.totalKilometers = totalKilometers;
}
public List<ShippingDetails1> getOrderDetailsList() {
	return orderDetailsList;
}
public void setOrderDetailsList(List<ShippingDetails1> orderDetailsList) {
	this.orderDetailsList = orderDetailsList;
}
  
}
