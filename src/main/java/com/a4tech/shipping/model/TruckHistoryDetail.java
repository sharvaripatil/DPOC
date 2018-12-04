package com.a4tech.shipping.model;

import java.util.Date;

public class TruckHistoryDetail {

	
	private Integer Sr_No;
	private String truckNo;
	private String districtCode;
	private String districtName;
	private Integer ratedLoad;
	private Integer normalLoad;
	//private Date lastTransactionOfNormalLoad;

	
	public Integer getSr_No() {
		return Sr_No;
	}
	public void setSr_No(Integer sr_No) {
		Sr_No = sr_No;
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
/*	public Date getLastTransactionOfNormalLoad() {
		return lastTransactionOfNormalLoad;
	}
	public void setLastTransactionOfNormalLoad(Date lastTransactionOfNormalLoad) {
		this.lastTransactionOfNormalLoad = lastTransactionOfNormalLoad;
	}*/
	

	
	
}
