package com.a4tech.service.mapper;

import org.apache.poi.ss.usermodel.Workbook;

public interface IOrderDataMapper {
	void pendingOrderMapper(Workbook wb);
	
	
	public String readTruckExcel(Workbook wb);
	
	public String readTruckHistoryExcel(Workbook wb);

	
}


