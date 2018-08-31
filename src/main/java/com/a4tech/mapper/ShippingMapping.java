package com.a4tech.mapper;
import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.a4tech.dao.entity.ShippingEntity;
import com.a4tech.daoService.ShippingDao;

public class ShippingMapping {
	
	
	ShippingDao shippingDao;
	
	public void mapper()
	{
		ShippingEntity entityObj=new ShippingEntity();
		try{
			@SuppressWarnings("resource")
			XSSFWorkbook workbook=new XSSFWorkbook(new  FileInputStream("C://Users//Sharvari//Desktop//12-06-2018//Dalmia//Test.XLSX"));
			XSSFSheet sheet=workbook.getSheetAt(0);
			Iterator<Row> iterator = sheet.iterator();
			
			while (iterator.hasNext()) {
				
				Row nextRow = iterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					int columnIndex = cell.getColumnIndex();

				
					switch (columnIndex + 1) {
					
					case 1:// id
						String id=cell.getStringCellValue();
						int result = Integer.parseInt(id);		
					    System.out.println("id----"  +id);
					    entityObj.setId(result);
						break;
					case 2:// Delivery
						String delivery=cell.getStringCellValue();
						double value = Double.parseDouble(delivery);
						entityObj.setDelivery(value);
						
						break;
					case 3:// Reference document
						String document=cell.getStringCellValue();
						entityObj.setDeference_document(document);
						break;
					case 4:// Sold-to party
						String sold=cell.getStringCellValue();
						entityObj.setSold_to_party(sold);

						break;
					case 5:// Name of sold-to party
						String name_sold=cell.getStringCellValue();
						entityObj.setName_of_sold_to_party(name_sold);

						break;
					case 6:// Name of the ship-to party
						String name_ship=cell.getStringCellValue();
						entityObj.setName_of_the_ship_to_party(name_ship);

						break;
					case 7:// Material
						String material=cell.getStringCellValue();
						entityObj.setMaterial(material);

						break;
					case 8:// Actual delivery qty
						String qty=cell.getStringCellValue();
						entityObj.setActual_delivery_qty(qty);

						break;
					case 9:// Route Description
						String route_desc=cell.getStringCellValue();
						entityObj.setRoute_description(route_desc);

						break;
					case 11:// Plant
						String plant=cell.getStringCellValue();
						entityObj.setPlant(plant);

						break;
						
		            case 12:// Route
						String route=cell.getStringCellValue();
						entityObj.setRoute(route);

						break;
					
		            case 13://Forwarding agent name
						String agent_name=cell.getStringCellValue();
						entityObj.setForwarding_agent_name(agent_name);

						break;
						
		            case 14://Distribution Channel
						String distribution=cell.getStringCellValue();
						entityObj.setDistribution_channel(distribution);

						break;
						
		            case 15://Deliv. date(From/to)
						String date=cell.getStringCellValue();
						entityObj.setDeliv_date(date);

						break;	
						
						
		            case 16://Shipping Point/Receiving Pt
						String point=cell.getStringCellValue();
						entityObj.setShipping_Point(point);

						break;
						
		            case 17://District Code
						String code=cell.getStringCellValue();
						entityObj.setDistrict_code(code);

						break;
						
		            case 18://Ship-to party
						String ship_party=cell.getStringCellValue();
						entityObj.setShip_to_party(ship_party);

						break;
						
		            case 19://Ship to Long
						String ship_long=cell.getStringCellValue();
						entityObj.setShip_to_long(ship_long);

						break;
						
		            case 20://Ship to Latt
						String ship_latt=cell.getStringCellValue();
						entityObj.setShip_to_latt(ship_latt);

						break;
					
					}
				}
			
			}
			
			
		}catch(Exception e)
		{
		System.out.println(e.getMessage());	
		}
		
		
		shippingDao.saveShippingEntity(entityObj);
	}



	public ShippingDao getShippingDao() {
		return shippingDao;
	}

	public void setShippingDao(ShippingDao shippingDao) {
		this.shippingDao = shippingDao;
	}
	
	
	
	
	
	
}
