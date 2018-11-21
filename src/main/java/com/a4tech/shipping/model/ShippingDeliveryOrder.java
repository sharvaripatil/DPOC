package com.a4tech.shipping.model;

import java.util.Date;

public class ShippingDeliveryOrder {
	private Integer deliveryId;
	private String truckNo;
	private Date shippingDeliveryDate;

	public Integer getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(Integer deliveryId) {
		this.deliveryId = deliveryId;
	}

	public String getTruckNo() {
		return truckNo;
	}

	public void setTruckNo(String truckNo) {
		this.truckNo = truckNo;
	}

	public Date getShippingDeliveryDate() {
		return shippingDeliveryDate;
	}

	public void setShippingDeliveryDate(Date shippingDeliveryDate) {
		this.shippingDeliveryDate = shippingDeliveryDate;
	}
}
