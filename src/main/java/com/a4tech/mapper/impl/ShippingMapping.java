package com.a4tech.mapper.impl;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a4tech.controller.ShippingDetailController;
import com.a4tech.dao.entity.ShippingEntity;
import com.a4tech.dao.entity.TruckDetailsEntity;
import com.a4tech.dao.entity.TruckHistoryDetailsEntity;
import com.a4tech.service.mapper.IOrderDataMapper;
import com.a4tech.shipping.ishippingDao.IshippingOrderDao;
import com.a4tech.util.ApplicationConstants;
import com.a4tech.util.CommonUtility;

@Service
public class ShippingMapping implements IOrderDataMapper{
	
	
	//ShippingDao shippingDao;
	@Autowired
	private IshippingOrderDao shippingOrderDao;
	@Override
	public void pendingOrderMapper(Workbook workbook)
	{
		ShippingEntity entityObj=new ShippingEntity();
		try{
			/*@SuppressWarnings("resource")
			XSSFWorkbook workbook=new XSSFWorkbook(new  FileInputStream("D://A4 ESPUpdate//dpoc//Pending order details 5300_old.XLSX"));
			*/
			Sheet sheet=workbook.getSheetAt(0);
			Iterator<Row> iterator = sheet.iterator();
			Set<String>  productXids = new HashSet<String>();
			String orderNo = null;
			while (iterator.hasNext()) {
				
				Row nextRow = iterator.next();
				if(nextRow.getRowNum() == ApplicationConstants.CONST_NUMBER_ZERO){
					continue;
				}
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				if(orderNo != null){
					productXids.add(orderNo);
				}
				 boolean checkXid  = false;
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					int columnIndex = cell.getColumnIndex();
					if(columnIndex  == 0){
						Cell xidCell = nextRow.getCell(0);
					     orderNo = CommonUtility.getCellValueStrinOrInt(xidCell);
						//xid = CommonUtility.getCellValueStrinOrInt(cell);
						checkXid = true;
					}else{
						checkXid = false;
					}
					if(checkXid){
						 if(!productXids.contains(orderNo)){
							 if(nextRow.getRowNum() != 1){
								 System.out.println("Java object converted to JSON String, written to file");
								 //int num = postServiceImpl.postProduct(accessToken, productExcelObj,asiNumber ,batchId, environmentType);
								 entityObj.setIsOrderGroup("No");
								 shippingOrderDao.saveShippingEntity(entityObj);
							 }
							    if(!productXids.contains(orderNo)){
							    	productXids.add(orderNo);
							    }
							    entityObj = new ShippingEntity();
						 }
					}
				
					switch (columnIndex + 1) {
					case 1:// Delivery
						String delivery=CommonUtility.getCellValueDouble(cell);
						//double value = Double.parseDouble(delivery);
						entityObj.setDelivery(delivery);
						
						break;
					case 2:// Reference document
						String document=CommonUtility.getCellValueStrinOrInt(cell);
						entityObj.setDeference_document(document);
						break;
					case 3:// Sold-to party
						String sold=cell.getStringCellValue();
						entityObj.setSold_to_party(sold);

						break;
					case 4:// Name of sold-to party
						String name_sold=cell.getStringCellValue();
						entityObj.setName_of_sold_to_party(name_sold);

						break;
					case 5:// Name of the ship-to party
						String name_ship=cell.getStringCellValue();
						entityObj.setName_of_the_ship_to_party(name_ship);

						break;
					case 6:// Material
						String material=cell.getStringCellValue();
						entityObj.setMaterial(material);

						break;
					case 7:// Actual delivery qty
						String qty=CommonUtility.getCellValueStrinOrInt(cell);
						entityObj.setActual_delivery_qty(qty);

						break;
					case 8:// Route Description
						String route_desc=cell.getStringCellValue();
						entityObj.setRoute_description(route_desc);

						break;
					case 9:// dist. Name
						String districtName = cell.getStringCellValue();
						entityObj.setDistrict_name(districtName);
						break;
					case 10:// Plant
						String plant=CommonUtility.getCellValueStrinOrInt(cell);
						entityObj.setPlant(plant);

						break;
						
		            case 11:// Route
						String route=cell.getStringCellValue();
						entityObj.setRoute(route);

						break;
					
		            case 12://Forwarding agent name
						String agent_name=cell.getStringCellValue();
						entityObj.setForwarding_agent_name(agent_name);

						break;
						
		            case 13://Distribution Channel
						String distribution=CommonUtility.getCellValueStrinOrInt(cell);
						entityObj.setDistribution_channel(distribution);

						break;
						
		            case 14://Deliv. date(From/to)
						Date date=cell.getDateCellValue();
						DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
						String delivaryDate = df.format(date);
						entityObj.setDeliv_date(delivaryDate);
						break;	
						
		            case 15://delivary Type
		            	String delivaryType = cell.getStringCellValue();
		            	entityObj.setDelivery_type(delivaryType);
		            	break;
		            case 16://Shipping Point/Receiving Pt
						String point=CommonUtility.getCellValueStrinOrInt(cell);
						entityObj.setShipping_Point(point);

						break;
						
		            case 17://District Code
						String code=cell.getStringCellValue();
						entityObj.setDistrict_code(code);

						break;
						
		            case 18://Ship-to party
						String ship_party=CommonUtility.getCellValueStrinOrInt(cell);
						entityObj.setShip_to_party(ship_party);

						break;
						
		            case 19://Ship to Long
						String ship_long=CommonUtility.getCellValueDouble(cell);
						entityObj.setShip_to_long(ship_long);

						break;
						
		            case 20://Ship to Latt
						String ship_latt=CommonUtility.getCellValueDouble(cell);
						entityObj.setShip_to_latt(ship_latt);

						break;
					
					}
				}
			
			}	
		}catch(Exception e)
		{
		System.out.println(e.getMessage());	
		}
		entityObj.setIsOrderGroup("No");
		shippingOrderDao.saveShippingEntity(entityObj);
	}
	
	@Override
	public String readTruckExcel(Workbook workbook) {
	{
		ShippingDetailController conObj=new ShippingDetailController();
		TruckDetailsEntity entityObj=new TruckDetailsEntity();
		
		Sheet sheet=workbook.getSheetAt(0);
		Iterator<Row> iterator = sheet.iterator();
		Set<String>  productXids = new HashSet<String>();
		//String TruckValue="";
		String SL_NO="";
		Cell xidCell = null ;
		while (iterator.hasNext()) {
			
			Row nextRow = iterator.next();
			if(nextRow.getRowNum() == ApplicationConstants.CONST_NUMBER_ZERO){
				continue;
			}
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			if(SL_NO != null){
				productXids.add(SL_NO);
			}
			 boolean checkXid  = false;
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				int columnIndex = cell.getColumnIndex();
				if(columnIndex  == 0){
					 xidCell = nextRow.getCell(1);
					 SL_NO = CommonUtility.getCellValueStrinOrInt(xidCell);
					//xid = CommonUtility.getCellValueStrinOrInt(cell);
					checkXid = true;
				}else{
					checkXid = false;
				}
				if(checkXid){
					 if(!productXids.contains(SL_NO)){
						 if(nextRow.getRowNum() != 1){
							 //int num = postServiceImpl.postProduct(accessToken, productExcelObj,asiNumber ,batchId, environmentType);
							 shippingOrderDao.saveTruckdetailsEntity(entityObj);
						 }
						    if(!productXids.contains(SL_NO)){
						    	productXids.add(SL_NO);
						    }
						    entityObj=new TruckDetailsEntity();
					 }
				}
					switch (columnIndex + 1) {
					
			/*		case 1:
						TruckValue=CommonUtility.getCellValueStrinOrInt(xidCell);
						int id=Integer.parseInt(TruckValue);
						entityObj.setTruckId(id);
						
						break;*/
						
					case 1:
					    SL_NO=cell.getStringCellValue(); 
						entityObj.setSlNo(SL_NO);
						
						break;	
						
					case 2:
						String VEHICLE_NO=CommonUtility.getCellValueStrinOrInt(cell); 
						entityObj.setVehiclNo(VEHICLE_NO);
						
						break;
						
					case 3:
						int intVehicleType = Integer.parseInt(CommonUtility.getCellValueStrinOrInt(cell));
						entityObj.setVehicleType(intVehicleType);
						break;
	
					case 4:
						String WHEELS=cell.getStringCellValue(); 
						entityObj.setWheels(WHEELS);
						break;
	
					case 5:
						String ENTRY_TYPE=cell.getStringCellValue(); 
						entityObj.setEntryType(ENTRY_TYPE);
						break;
	
					case 6:
						String TRANSPORTER=cell.getStringCellValue(); 
						entityObj.setTaggedTranspoter(TRANSPORTER);
						break;
	
					case 7:
						String DO_NO=cell.getStringCellValue(); 
						entityObj.setDoNo(DO_NO);
						break;
	
					case 8:
						String TAGGED_DATE=cell.getStringCellValue(); 
						entityObj.setTaggedDate(TAGGED_DATE);
						break;
	
					case 9:
						String TAGGED_TIME=cell.getStringCellValue(); 
						entityObj.setTaggedTime(TAGGED_TIME);
						break;
	
					case 10:
						String DELAY=cell.getStringCellValue(); 
						entityObj.setDelay(DELAY);
						break;
	
					}
				}
			
			shippingOrderDao.saveTruckdetailsEntity(entityObj);

			}
		
		
		//shippingDao.saveShippingEntity(entityObj);

		
	}
	return "Success";	
		
	}

	@Override
	public String readTruckHistoryExcel(Workbook wb) {
		

		{
		//	ShippingDetailController historyObj=new ShippingDetailController();
			TruckHistoryDetailsEntity historyObj=new TruckHistoryDetailsEntity();
			
			Sheet sheet=wb.getSheetAt(0);
			Iterator<Row> iterator = sheet.iterator();
			Set<String>  productXids = new HashSet<String>();
			//String TruckValue="";
			String SL_NO="";
			Cell xidCell = null ;
			while (iterator.hasNext()) {
				
				Row nextRow = iterator.next();
				if(nextRow.getRowNum() == ApplicationConstants.CONST_NUMBER_ZERO){
					continue;
				}
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				/*if(SL_NO != null){
					productXids.add(SL_NO);
				}*/
				 boolean checkXid  = false;
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					int columnIndex = cell.getColumnIndex();
					if(columnIndex  == 0){
						 xidCell = nextRow.getCell(0);
						 SL_NO = CommonUtility.getCellValueStrinOrInt(xidCell);
						//xid = CommonUtility.getCellValueStrinOrInt(cell);
						checkXid = true;
					}else{
						checkXid = false;
					}
					if(checkXid){
						 if(!productXids.contains(SL_NO)){
							 if(nextRow.getRowNum() != 1){
								 //int num = postServiceImpl.postProduct(accessToken, productExcelObj,asiNumber ,batchId, environmentType);
								// shippingOrderDao.saveTruckhistory(historyObj);
							 }
							    if(!productXids.contains(SL_NO)){
							    	productXids.add(SL_NO);
							    }
							    historyObj=new TruckHistoryDetailsEntity();
						 }
					}
						switch (columnIndex + 1) {
						
				/*		case 1:
							TruckValue=CommonUtility.getCellValueStrinOrInt(xidCell);
							int id=Integer.parseInt(TruckValue);
							entityObj.setTruckId(id);
							
							break;*/
							
						case 1:
						    SL_NO=cell.getStringCellValue(); 
						    historyObj.setTruckNo(SL_NO);
							
							break;	
							
						case 2:
							String SP_District_Code=cell.getStringCellValue(); 
							historyObj.setDistrictCode(SP_District_Code);
							
							break;
							
						case 3:
							String SP_District_Name=cell.getStringCellValue(); 
							historyObj.setDistrictName(SP_District_Name);
							break;
		
						case 4:
							Double Rated_Load=cell.getNumericCellValue();
							int intRated_Load=Rated_Load.intValue();
							historyObj.setRatedLoad(intRated_Load);
							
							break;
		
						case 5:
							Double Normal_Load=cell.getNumericCellValue();
							int intNormal_Load=Normal_Load.intValue();
							historyObj.setNormalLoad(intNormal_Load);
							
							break;
		
						}
					}
				
				 shippingOrderDao.saveTruckhistory(historyObj);
				
			}
			
			//shippingDao.saveShippingEntity(entityObj);

			
		}
		return "Success";	
		
		}
		
			
}
