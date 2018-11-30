package com.a4tech.mapper;

import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import com.a4tech.controller.ShippingDetailController;
import com.a4tech.dao.entity.TruckDetailsEntity;


public class TruckdetailsMapping {


	
    
	public String readTruckExcel(Workbook workbook) {
	{
		ShippingDetailController conObj=new ShippingDetailController();
		TruckDetailsEntity entityObj=new TruckDetailsEntity();
		
			try{
			@SuppressWarnings("resource")
			Sheet sheet=workbook.getSheetAt(0);
			Iterator<Row> iterator = sheet.iterator();
			while (iterator.hasNext()) {
				Row nextRow = iterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				if (nextRow.getRowNum() == 0)
					continue;
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					int columnIndex = cell.getColumnIndex();
					
					switch (columnIndex + 1) {
					
					case 1:
						Double Truck_id=cell.getNumericCellValue();
						int id=Truck_id.intValue();
						entityObj.setTruckId(id);
						
						break;
						
					case 2:
						String SL_NO=cell.getStringCellValue(); 
						entityObj.setSlNo(SL_NO);
						
						break;	
						
					case 3:
						String VEHICLE_NO=cell.getStringCellValue(); 
						entityObj.setSlNo(VEHICLE_NO);
						
						break;
						
					case 4:
						Double VEHICLE_TYPE=cell.getNumericCellValue();
						int intVehicleType=VEHICLE_TYPE.intValue();
						entityObj.setTruckId(intVehicleType);
						break;
	
					case 5:
						String WHEELS=cell.getStringCellValue(); 
						entityObj.setSlNo(WHEELS);
						break;
	
					case 6:
						String ENTRY_TYPE=cell.getStringCellValue(); 
						entityObj.setSlNo(ENTRY_TYPE);
						break;
	
					case 7:
						String TRANSPORTER=cell.getStringCellValue(); 
						entityObj.setSlNo(TRANSPORTER);
						break;
	
					case 8:
						String DO_NO=cell.getStringCellValue(); 
						entityObj.setSlNo(DO_NO);
						break;
	
					case 9:
						String TAGGED_DATE=cell.getStringCellValue(); 
						entityObj.setSlNo(TAGGED_DATE);
						break;
	
					case 10:
						String TAGGED_TIME=cell.getStringCellValue(); 
						entityObj.setSlNo(TAGGED_TIME);
						break;
	
					case 11:
						String DELAY=cell.getStringCellValue(); 
						entityObj.setSlNo(DELAY);
						break;
	
					}
				}
			
			}
			
			
		}catch(Exception e)
		{
		System.out.println(e.getMessage());	
		}
		
		
		//shippingDao.saveShippingEntity(entityObj);
	
		
		
		
		
		
		
		
	}
	return null;	
		
	}


}
