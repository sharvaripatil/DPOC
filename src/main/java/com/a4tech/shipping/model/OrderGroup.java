package com.a4tech.shipping.model;

public class OrderGroup {
	private String delivaryNo;
	private String originalOrderQty;
	private String truckNo;
	private String truckCapacity;
	private int truckOrderQty;
	private String delivaryDate;
	
	public String getDelivaryNo() {
		return delivaryNo;
	}
	public void setDelivaryNo(String delivaryNo) {
		this.delivaryNo = delivaryNo;
	}
	public String getOriginalOrderQty() {
		return originalOrderQty;
	}
	public void setOriginalOrderQty(String originalOrderQty) {
		this.originalOrderQty = originalOrderQty;
	}
	public String getTruckNo() {
		return truckNo;
	}
	public void setTruckNo(String truckNo) {
		this.truckNo = truckNo;
	}
	public String getTruckCapacity() {
		return truckCapacity;
	}
	public void setTruckCapacity(String truckCapacity) {
		this.truckCapacity = truckCapacity;
	}
	
	public int getTruckOrderQty() {
		return truckOrderQty;
	}
	public void setTruckOrderQty(int truckOrderQty) {
		this.truckOrderQty = truckOrderQty;
	}
	public String getDelivaryDate() {
		return delivaryDate;
	}
	public void setDelivaryDate(String delivaryDate) {
		this.delivaryDate = delivaryDate;
	}

}
