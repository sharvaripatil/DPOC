package com.a4tech.service.mapper;

import org.apache.poi.ss.usermodel.Workbook;

public interface IOrderDataMapper {
	void mapper();
	
	public String readTruckExcel(Workbook wb);
	
}


