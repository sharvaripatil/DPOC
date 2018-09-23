package com.a4tech.shipping.model;

public class IntellishipModelByMaterial {
	private String    truckNo;
	private String    loadType;
	private String    materialType;
	private Integer   totalOrders;
	private Integer   totalOrderQuantity;
	private String    truckCapacity;
	private Integer   pendingQuantity;
	private String    plant;
	private String    totalKilometers;
	private String    delivaryDate;
	public String getTruckNo() {
		return truckNo;
	}
	public void setTruckNo(String truckNo) {
		this.truckNo = truckNo;
	}
	public String getLoadType() {
		return loadType;
	}
	public void setLoadType(String loadType) {
		this.loadType = loadType;
	}
	public String getMaterialType() {
		return materialType;
	}
	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}
	public Integer getTotalOrders() {
		return totalOrders;
	}
	public void setTotalOrders(Integer totalOrders) {
		this.totalOrders = totalOrders;
	}
	public Integer getTotalOrderQuantity() {
		return totalOrderQuantity;
	}
	public void setTotalOrderQuantity(Integer totalOrderQuantity) {
		this.totalOrderQuantity = totalOrderQuantity;
	}
	public String getTruckCapacity() {
		return truckCapacity;
	}
	public void setTruckCapacity(String truckCapacity) {
		this.truckCapacity = truckCapacity;
	}
	public Integer getPendingQuantity() {
		return pendingQuantity;
	}
	public void setPendingQuantity(Integer pendingQuantity) {
		this.pendingQuantity = pendingQuantity;
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
	public String getDelivaryDate() {
		return delivaryDate;
	}
	public void setDelivaryDate(String delivaryDate) {
		this.delivaryDate = delivaryDate;
	}
	
}
