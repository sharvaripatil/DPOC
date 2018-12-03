package com.a4tech.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="district_wise_normal_load_capacity")
public class DistrictWiseNormalLoadCapacity {

	 @Id
	 @Column(name="distNo")
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer id;
	 @Column(name="district_name")
	 private String districtName;
	 @Column(name="rated_load")
	 private Integer ratedLoad;
	 @Column(name="truck_over_loading")
	 private Double truckOverLoading;
	 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public Integer getRatedLoad() {
		return ratedLoad;
	}
	public void setRatedLoad(Integer ratedLoad) {
		this.ratedLoad = ratedLoad;
	}
	public Double getTruckOverLoading() {
		return truckOverLoading;
	}
	public void setTruckOverLoading(Double truckOverLoading) {
		this.truckOverLoading = truckOverLoading;
	}
}
