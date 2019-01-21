package com.a4tech.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "axlewheelertype")
public class AxleWheelTypeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "axlewheelerid")
	private Integer axlewheelerid;
	@Column(name = "axlewheelertype")
	private String axlewheelertype;
	public Integer getAxlewheelerid() {
		return axlewheelerid;
	}
	public void setAxlewheelerid(Integer axlewheelerid) {
		this.axlewheelerid = axlewheelerid;
	}
	public String getAxlewheelertype() {
		return axlewheelertype;
	}
	public void setAxlewheelertype(String axlewheelertype) {
		this.axlewheelertype = axlewheelertype;
	}
	
	
	
	
	
	
}
