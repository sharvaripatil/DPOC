package com.a4tech.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ordergroup")
public class OrderGroupEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Order_Group_Id")
	private Integer orderGroupId;
	@Column(name="Delivary_No")
	private String delivaryNo;
	@Column(name="Original_Order_Qty")
	private String originalOrderQty;
	@Column(name="Truck_No")
	private String truckNo;
	@Column(name="Truck_Capacity")
	private String truckCapacity;
	@Column(name="Truck_Order_Qty")
	private String truckOrderQty;
	@Column(name="Delivary_Date")
	private String delivaryDate;
	@Column(name="Material_Name")
	private String materialName;
	@Column(name="District_Name")
	private String districtName;
	@Column(name="Ship_Latitude")
	private String latitude;
	@Column(name="Ship_Longitude")
	private String longitude;
	
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
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
	public String getTruckOrderQty() {
		return truckOrderQty;
	}
	public void setTruckOrderQty(String truckOrderQty) {
		this.truckOrderQty = truckOrderQty;
	}
	public String getDelivaryDate() {
		return delivaryDate;
	}
	public void setDelivaryDate(String delivaryDate) {
		this.delivaryDate = delivaryDate;
	}

}
