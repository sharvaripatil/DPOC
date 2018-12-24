package com.a4tech.shipping.model;

/*
 * @author: Venkat
 * this model class used for binding values in jsp
 */
public class NormalLoadConfiguration {
	private String districtName;
	private Integer ratedLoad;
	private String normalLoadInPer;
	private Integer normalLoadInTonns;


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

	public String getNormalLoad() {
		return normalLoadInPer;
	}

	public void setNormalLoad(String normalLoad) {
		this.normalLoadInPer = normalLoad;
	}

	public String getNormalLoadInPer() {
		return normalLoadInPer;
	}

	public void setNormalLoadInPer(String normalLoadInPer) {
		this.normalLoadInPer = normalLoadInPer;
	}

	public Integer getNormalLoadInTonns() {
		return normalLoadInTonns;
	}

	public void setNormalLoadInTonns(Integer normalLoadInTonns) {
		this.normalLoadInTonns = normalLoadInTonns;
	}




}
