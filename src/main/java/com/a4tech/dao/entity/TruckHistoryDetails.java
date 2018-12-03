package com.a4tech.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "truck_history_details")
public class TruckHistoryDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Sr_No")
	private Integer id;
	@Column(name = "Truck_No")
	private String truckNo;
	@Column(name = "SP_District_Code")
	private String districtCode;
	@Column(name = "SP_District_Name")
	private String districtName;
	@Column(name = "Rated_Load")
	private Integer ratedLoad;
	@Column(name = "Normal_Load")
	private Integer normalLoad;
	@Column(name = "Last_Transaction_Of_Normal_Load")
	private Date lastTransactionOfNormalLoad;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTruckNo() {
		return truckNo;
	}

	public void setTruckNo(String truckNo) {
		this.truckNo = truckNo;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
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

	public Integer getNormalLoad() {
		return normalLoad;
	}

	public void setNormalLoad(Integer normalLoad) {
		this.normalLoad = normalLoad;
	}

	public Date getLastTransactionOfNormalLoad() {
		return lastTransactionOfNormalLoad;
	}

	public void setLastTransactionOfNormalLoad(Date lastTransactionOfNormalLoad) {
		this.lastTransactionOfNormalLoad = lastTransactionOfNormalLoad;
	}


}
