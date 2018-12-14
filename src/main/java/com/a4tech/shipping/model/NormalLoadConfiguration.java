package com.a4tech.shipping.model;

/*
 * @author: Venkat
 * this model class used for binding values in jsp
 */
public class NormalLoadConfiguration {
	private String districtName;
	private Integer ratedLoad;
	private String normalLoad;

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
		return normalLoad;
	}

	public void setNormalLoad(String normalLoad) {
		this.normalLoad = normalLoad;
	}

}
