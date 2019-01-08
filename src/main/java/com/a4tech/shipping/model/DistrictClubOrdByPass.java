package com.a4tech.shipping.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/*
 * @Author By Venkat
 */
public class DistrictClubOrdByPass {
	private String districtName;
	private String districtCode;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date startDate;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date endDate;

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
