package com.a4tech.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.a4tech.map.service.MapService;
import com.a4tech.shipping.iservice.IShippingOrder;
import com.a4tech.shipping.model.IntellishipModel;
import com.a4tech.shipping.model.OrderGroup;
import com.a4tech.shipping.model.PlantDetails;
import com.a4tech.shipping.model.ShippingDetails;
import com.a4tech.shipping.model.ShippingDetails1;
import com.a4tech.shipping.model.ShortestDistLantiAndLongti;
import com.a4tech.shipping.model.TruckDetails;

import saveShipping.StoreSpDetails;

@Controller
public class ShippingDetailController {
  
	/*@Autowired
	private IOrderDataMapper dataMapper;*/
	@Autowired 
	private IShippingOrder shippingOrder;
	@RequestMapping(value="/getShortestDistence/{orderNo}")
	public String getShortDistence(@PathVariable("orderNo") String orderNo){
		System.out.println(orderNo);
	  return getDistence(orderNo);
  }
	@RequestMapping(value="/getAllShortestDistence")
	public String getAllShortDistenceFromOrders(){
	  return getAllDistence1();
  }
	
	/*@RequestMapping(value="/saveShippingMapping")
	public void saveShippingData(){
		dataMapper.mapper();
		System.out.println("Test");
  }*/
	@RequestMapping(value="/algorithmProcess")
	public ModelAndView algorithmProcess(){
		List<ShippingDetails1> shippingaOrderList = shippingOrder.getAllShippingOrders();
		System.out.println("Total Orders: "+shippingaOrderList.size());
		return new ModelAndView("algorithm_process", "shippingaOrderList", shippingaOrderList);
  }
	@RequestMapping(value="/intellShip")
	public ModelAndView intellShipPro(){
    	List<IntellishipModel> orderGroupList = getGroupOrders();
		return new ModelAndView("intellShipProcess", "shippingGroupList", orderGroupList);
		//return "intellShipProcess";
  }
	@RequestMapping(value = "/getShippingOrderByDate")
	@ResponseBody
	public List<ShippingDetails1> getOderDetailsByDate(HttpServletRequest req) {
		System.out.println("Get Shipping Order details based On Date");
		String orderDate = req.getParameter("orderDate");
		List<ShippingDetails1> shippingaOrderList = shippingOrder.getShippingDetailsByDate(orderDate);
		return shippingaOrderList;
	}
	@RequestMapping(value = "/getGroupOrderByDate")
	@ResponseBody
	public List<OrderGroup> getGroupOrders(HttpServletRequest req) {
		System.out.println("Get order Group Order details based On Date");
		String orderDate = req.getParameter("orderDate");
		List<OrderGroup> orderGroupList = shippingOrder.getOrderGroupByDate(orderDate);
		return orderGroupList;
	}
	@RequestMapping(value="/getShippingOrderHistory")
	public String getShippingHistory(){
		return "history";
		//return "intellShipProcess";
  }
	public List<IntellishipModel> getGroupOrders(){
		  StoreSpDetails sd = new StoreSpDetails();
		  MapService gmapDist = new MapService();
		  List<ShippingDetails1> shippingaOrderList = shippingOrder.getAllShippingOrders();
		  List<PlantDetails> plantDetailsList = sd.getAllPlantDetails();
			Map<String, ShippingDetails> shippingDetailsMap = sd.getAllShippingDetailsMap();
		  Map<Double, String> distences = new LinkedHashMap<>();
		  double initialDistence = 0.0;
		  Map<String, StringBuilder> shortDist = new HashMap<>();
		  String plantLangitude = "";
		  String plantLatitude = "";
		  int intitialDist = 1;
		  Map<Long, List<ShippingDetails1>> groupBasedOnDays = new HashMap<>();
		  PlantDetails plantDetails  = plantDetailsList.get(2);
		  for (ShippingDetails1 shippingDetail : shippingaOrderList) {
			    String date = shippingDetail.getDeliv_date();
			  
			    LocalDate delivaryDate = LocalDate.parse(date);
			   Long noOfdays =  ChronoUnit.DAYS.between(LocalDate.now(), delivaryDate);
			   List<ShippingDetails1> shippingList = groupBasedOnDays.get(noOfdays);
			   if(shippingList == null){
				   List<ShippingDetails1> initialList = new ArrayList<>();
				   initialList.add(shippingDetail);
				   groupBasedOnDays.put(noOfdays, initialList);
			   } else {
				   shippingList.add(shippingDetail);
				   groupBasedOnDays.put(noOfdays, shippingList);
			   }
	}
		  Map<Long, List<ShippingDetails1>> afterSoringGroup= new HashMap<>();
		  for (Map.Entry<Long, List<ShippingDetails1>> data : groupBasedOnDays.entrySet()) {
			  Collections.sort(data.getValue(),new Comparator<ShippingDetails1>() {

				@Override
				public int compare(ShippingDetails1 o1, ShippingDetails1 o2) {
					return Double.compare(Double.parseDouble(o1.getShip_to_latt()), Double.parseDouble(o2.getShip_to_latt()));
				}
			});
			  afterSoringGroup.put(data.getKey(), data.getValue());
		}
		  List<IntellishipModel> intellishipList = new ArrayList<>();
		  IntellishipModel intellishipObj = null;
		  int orderNo = 1;
		  for (Map.Entry<Long, List<ShippingDetails1>> details : afterSoringGroup.entrySet()) {
			  intellishipObj = new IntellishipModel();
			Long delivaryDueDays = details.getKey();
			List<ShippingDetails1> shippingOrderList = details.getValue();
			StringBuilder shippingLatitudeAndLonitude = new StringBuilder();
			double distence = 0.0;
			String delivaryDate ="";
			for (ShippingDetails1 shippingDetails1 : shippingOrderList) {
				delivaryDate = shippingDetails1.getDeliv_date();
				shippingLatitudeAndLonitude.append(shippingDetails1.getShip_to_latt()).append(",").append(shippingDetails1.getShip_to_long());
				shippingLatitudeAndLonitude.append("|");
			}
			try {
				distence = gmapDist.getMaxDistenceFromMultipleDestination(
						plantDetails.getLatitude() + "," + plantDetails.getLongitude(),
						shippingLatitudeAndLonitude.toString());
			} catch (IOException e) {
				System.out.println("Unbale to calculate distence :"+e.getCause());
				e.printStackTrace();
			}
			intellishipObj.setDelivaryDate(delivaryDate);
			intellishipObj.setTotalOrders(shippingOrderList.size());
			if(orderNo == 1){
				intellishipObj.setTruckNum("JH02AE4348");
				intellishipObj.setTruckCapacity("10");	
			} else if(orderNo == 2){
				intellishipObj.setTruckNum("JH09AL3681");
				intellishipObj.setTruckCapacity("12");
			}else if(orderNo == 3){
				intellishipObj.setTruckNum("JH09AH6721");
				intellishipObj.setTruckCapacity("14");
			}else if(orderNo == 4){
				intellishipObj.setTruckNum("JH09AD4244");
				intellishipObj.setTruckCapacity("12");
			}else if(orderNo == 5){
				intellishipObj.setTruckNum("JH09T5702");
				intellishipObj.setTruckCapacity("12");
			} else {
				intellishipObj.setTruckNum("JH11E9261");
				intellishipObj.setTruckCapacity("10");
			}
			intellishipObj.setPlant(plantDetails.getPlantName());
			intellishipObj.setTotalKilometers(String.valueOf(distence));
			intellishipObj.setOrderDetailsList(shippingOrderList);
			intellishipList.add(intellishipObj);
			orderNo ++;
		}
		  
		  /*System.out.println("After sorting"); 
		  for (Map.Entry<Long, List<ShippingDetails1>> details : afterSoringGroup.entrySet()) {
	          for (ShippingDetails1 shippingDetils : details.getValue()) {
		System.out.println("No Delivary Due Days: " + details.getKey() + "Shipping details:"
				+ shippingDetils.getShip_to_latt() + ":Longitude:  " + shippingDetils.getShip_to_long());
			}
	   //System.out.println("Delivary Time Day due:"+details.getKey()+"##"+"NoOfOrders: "+details.getValue().size());
}
		  
			 StringBuilder allData = new StringBuilder();
			 allData.append("All Plant Distence from Receptive Order: ").append("\n");
		  for (Map.Entry<Double, String> dist: distences.entrySet()) {
			System.out.println(dist.getValue()+"::"+dist.getKey());
			allData.append(dist.getValue()).append("::").append(dist.getKey());
			allData.append("\n");
		}
		  allData.append("\n");
		  System.out.println("#####SHORTEST DISTENCE FROM PLANT#####");
		  allData.append("#####SHORTEST DISTENCE FROM PLANT#####");
		  allData.append("\n");
		  for (Map.Entry<String, StringBuilder> dist : shortDist.entrySet()) {
			System.out.println("Order No: "+dist.getKey()+"::"+"Shortest Distence:"+dist.getValue());
			allData.append("Order No: "+dist.getKey()).append("::").append("Shortest Distence:"+dist.getValue());
			allData.append("\n");
		}*/
		  getGroupByOrderQty(intellishipList);
		 List<IntellishipModel> newIntelliList = getTrucksCount(intellishipList);
		  return newIntelliList;
		
	}

	
	private void getGroupByOrderQty(List<IntellishipModel> data){
		//List<TruckDetails> truckInfoList = shippingOrder.getAllTruckInfo();
		Map<IntellishipModel, List<TruckDetails>> groupTruckMap = new HashMap<>();
		for (IntellishipModel intellishipModel : data) {
			List<ShippingDetails1> ordersList = intellishipModel.getOrderDetailsList();
			List<TruckDetails> groupTruckList = new ArrayList<>();
			int allOrderQty = 0;
			for (ShippingDetails1 shippingDetails1 : ordersList) {
				allOrderQty = allOrderQty+ Integer.parseInt(shippingDetails1.getActual_delivery_qty());
			}
			List<TruckDetails> groupTruckDetails = getfinalTruckList(groupTruckList, allOrderQty);
			groupTruckMap.put(intellishipModel, groupTruckDetails);
		}
		orderGroupByTruck(groupTruckMap);
		//split tru1cks based on order quantity
	}
	private List<TruckDetails> getfinalTruckList(List<TruckDetails> groupTruckList,int orderQty){
		List<TruckDetails> initialTruckInfoList = shippingOrder.getAllTruckInfo();
		TruckDetails maxTruckDetails = initialTruckInfoList.stream().max(Comparator.comparing(TruckDetails::getVehicleType))
				.orElseThrow(NoSuchElementException::new);	
		int truckMaxCapacity = maxTruckDetails.getVehicleType();
		if(orderQty > truckMaxCapacity){//check order qty with max truck capacity
			if(orderQty != truckMaxCapacity){
				groupTruckList.add(maxTruckDetails);
				  int remainingOrderQty = orderQty - truckMaxCapacity;
				  if(remainingOrderQty > truckMaxCapacity){
					  
				  } else {
					  for (TruckDetails truckDetails : initialTruckInfoList) {
						   if(truckDetails.getVehicleType() == remainingOrderQty){
							  if(!isTruckGroup(groupTruckList,truckDetails.getSlNo())){
								   groupTruckList.add(truckDetails);
								   break;
							   }
						   } /*else {
							getfinalTruckList(groupTruckList, remainingOrderQty);  
						   }*/
						}  
				  }  
			} else {//if allOrderQty and truck capacity is same
				
			}
		} else {// if orser qty is low compare to truck max capacity
			TruckDetails tDetails = Collections.min(initialTruckInfoList,
					Comparator.comparing(TruckDetails::getVehicleType));
			groupTruckList.add(tDetails);
			
		}
				return groupTruckList;
	}
	private boolean isTruckGroup(List<TruckDetails> truckList,String truckNo){
		String allTruckNos = truckList.stream().map(TruckDetails::getSlNo).collect(Collectors.joining(","));
		if(allTruckNos.contains(truckNo)){
			return true;
		}
		return false;
	}
	private void orderGroupByTruck(Map<IntellishipModel, List<TruckDetails>> groupTruckMap){
		for (Map.Entry<IntellishipModel, List<TruckDetails>> allDetails: groupTruckMap.entrySet()) {
			IntellishipModel intellship = allDetails.getKey();
			List<ShippingDetails1> ordersList = intellship.getOrderDetailsList();
			//ordersList.stream().map(ShippingDetails1::getActual_delivery_qty).
			int allOrdsQtys = getAllOrdersQty(ordersList);
			List<TruckDetails> groupTruckDetails = allDetails.getValue();
			OrderGroup orderGroup = null;
			List<OrderGroup> orderGroupList = new ArrayList<>();
			Map<String, List<OrderGroup>> ordersMap = new HashMap<>();
			for (TruckDetails truckDetails : groupTruckDetails) {
				int initialOrder = 1;
				int truckCapacity = truckDetails.getVehicleType();
				int ordersQtyTruck = 0;
				for (ShippingDetails1 orderDetails : ordersList) {
					orderGroup = new OrderGroup();
					int orderQty = Integer.parseInt(orderDetails.getActual_delivery_qty());
					if(isOrderQtyTruck(ordersMap, orderQty, orderDetails.getDelivery())){// check is order load in truck or not,if order is loaded then skip those order
						continue;
					}
					int remaingTruckCapacity = 0;
					if(initialOrder != 1){
						int truckOrdQty = truckCapacity -  ordersQtyTruck;
						if(truckOrdQty < orderQty){
							remaingTruckCapacity = truckOrdQty;
						} else {
							remaingTruckCapacity = orderQty;
						}
					}
					if(ordersMap.containsKey(orderDetails.getDelivery())){
						remaingTruckCapacity =  getRemainingOrderqQty(ordersMap, orderDetails.getDelivery());
						if(initialOrder == 1){
							orderQty = remaingTruckCapacity;
						} 
					}
						orderGroup.setDelivaryNo(orderDetails.getDelivery());
						 orderGroup.setOriginalOrderQty(orderDetails.getActual_delivery_qty());
						 orderGroup.setTruckNo(truckDetails.getSlNo());
						 orderGroup.setTruckCapacity(String.valueOf(truckDetails.getVehicleType()));
						 if(initialOrder == 1){
							 orderGroup.setTruckOrderQty(orderQty);	
							 ordersQtyTruck = orderQty;
						 } else {
							 orderGroup.setTruckOrderQty(remaingTruckCapacity);
							 ordersQtyTruck = ordersQtyTruck + remaingTruckCapacity;
						 }
						 orderGroup.setDelivaryDate(orderDetails.getDeliv_date());
						// orderGroupList.add(orderGroup);
						 if(ordersMap.containsKey(orderDetails.getDelivery())){
							 List<OrderGroup> orderGroupsList = ordersMap.get(orderDetails.getDelivery());
							 orderGroupsList.add(orderGroup);
							 ordersMap.put(orderDetails.getDelivery(), orderGroupsList);
						 } else {
							 List<OrderGroup> orders = new ArrayList<>();
							 orders.add(orderGroup);
							 ordersMap.put(orderDetails.getDelivery(), orders);	 
						 }
						 
					
					initialOrder++;
					if(ordersQtyTruck == truckCapacity || isOrderQtyTruck(ordersMap, allOrdsQtys, orderDetails.getDelivery())){// truck is full with orders
						break;
					}
				}
				//orderGroupList = new ArrayList<>();
			}//end truck for loop
			for (Map.Entry<String, List<OrderGroup>> ords : ordersMap.entrySet()) {
				List<OrderGroup> ordGroup = ords.getValue();
				for (OrderGroup orderGroup2 : ordGroup) {
				     shippingOrder.saveOrderGroup(orderGroup2);	
				}
			}
		}  
	}
	
	private int getRemainingOrderqQty(Map<String, List<OrderGroup>> ordersMap, String delivaryNo) {
		List<OrderGroup> orderGroupList = ordersMap.get(delivaryNo);
       int finalOrdQty =0;
		for (OrderGroup orderGroup : orderGroupList) {
			int originalOrdQty = Integer.parseInt(orderGroup.getOriginalOrderQty());
			int truckOrdQty = orderGroup.getTruckOrderQty();
		    finalOrdQty = originalOrdQty - truckOrdQty;
		}

		return finalOrdQty;
	}
	private int getAllOrdersQty(List<ShippingDetails1> shippingDetailsList){
		int ordQty = 0;
		for (ShippingDetails1 shippingDetails1 : shippingDetailsList) {
			ordQty = ordQty + Integer.parseInt(shippingDetails1.getActual_delivery_qty());
		}
		return ordQty;
	}
	private boolean isOrderQtyTruck(Map<String, List<OrderGroup>> ordersMap ,int allOrdersQty,String delivaryNo){
		  List<OrderGroup> orderGroupList = ordersMap.get(delivaryNo);
		  if(CollectionUtils.isEmpty(orderGroupList)){
			  return false;
		  }
		  int ordQtyInTruck = 0;
		  for (OrderGroup orderGroup : orderGroupList) {
			ordQtyInTruck = ordQtyInTruck + orderGroup.getTruckOrderQty();
		}
		  if(allOrdersQty == ordQtyInTruck){
			  return true;
		  }
		return false;
	}
	
	public List<IntellishipModel> getTrucksCount(List<IntellishipModel> intellishModel){
		List<OrderGroup> orderGroupList = shippingOrder.getAllGroupOrderList();
		Map<String, Set<String>> truckGroup = new HashMap<>();
		for (OrderGroup orderGroup : orderGroupList) {
			String date = orderGroup.getDelivaryDate();
			if(truckGroup.containsKey(date)){
				Set<String> truckNo = truckGroup.get(date);
				truckNo.add(orderGroup.getTruckNo());
				truckGroup.put(date, truckNo);
			} else {
				Set<String> truNo = new HashSet<>();
				truNo.add(orderGroup.getTruckNo());
				truckGroup.put(date, truNo);
			}
		}
		List<IntellishipModel> newIntellishModel = new ArrayList<>();
		for (IntellishipModel intellModel : intellishModel) {
			String delivaryDate = intellModel.getDelivaryDate();
			Set<String> totTrucks = truckGroup.get(delivaryDate);
			intellModel.setTruckNum(String.valueOf(totTrucks.size()));
			newIntellishModel.add(intellModel);
		}
		return newIntellishModel;
	}
	public String getDistence(String orderNo){
		ShortestDistLantiAndLongti shortestDetails = new ShortestDistLantiAndLongti();
		  StoreSpDetails sd = new StoreSpDetails();
		  MapService gmapDist = new MapService();
		  List<ShippingDetails> shippingDetailsList = sd.getAllShippingDetails();
		  List<PlantDetails> plantDetailsList = sd.getAllPlantDetails();
			Map<String, ShippingDetails> shippingDetailsMap = sd.getAllShippingDetailsMap();
		  //List<Double> distences = new ArrayList<>();
			ShippingDetails shippingDetail = shippingDetailsMap.get(orderNo);
			if(shippingDetail == null){
				return "Invaild OrderNo,Please enter vaild OrderNo";
			}
		  Map<Double, String> distences = new LinkedHashMap<>();
		  double initialDistence = 0.0;
		  Map<String, StringBuilder> shortDist = new HashMap<>();
		  double plantLangitude = 0.0;
		  double plantLatitude = 0.0;
		  int intitialDist = 1;
			  for (PlantDetails plantDetails : plantDetailsList) {
				/*double distence =	distance(Double.parseDouble(shippingdetail.getLatitude()),
							Double.parseDouble(shippingdetail.getLongitude()),
							Double.parseDouble(plantDetails.getLatitude()), Double.parseDouble(plantDetails.getLongitude()),
							"K");*/
				  double distence = 0.0;
				  try {
					distence =gmapDist.getDistence(shippingDetail.getLatitude()+","+shippingDetail.getLongitude(), plantDetails.getLatitude()+","+plantDetails.getLongitude());
				} catch (IOException e) {
					System.out.println("Unbale to calculate distence :"+e.getCause());
					e.printStackTrace();
				}
	            if(intitialDist == 1) {
	            	initialDistence = distence;
	            }
				if(distence<initialDistence) {
					initialDistence = distence;
					plantLangitude = plantDetails.getLongitude();
					plantLatitude = plantDetails.getLatitude();
				}
				StringBuilder ord = new StringBuilder();
				ord.append("PlantName:"+plantDetails.getPlantName()).append("_").append(plantDetails.getPlantState());
				distences.put(distence, ord.toString());
				intitialDist++;
			}
			  shortestDetails.setPlantLatitude(plantLatitude);
			  shortestDetails.setPlantLongitude(plantLangitude);
			  shortestDetails.setShortestDist(initialDistence);
			  shortestDetails.setOrderLatitude(shippingDetail.getLatitude());
			  shortestDetails.setOrderLongitude(shippingDetail.getLongitude());
			  StringBuilder allDetails = new StringBuilder();
				/*allDetails.append(initialDistence).append("##")
						.append("Plant Latitude & Longitude:").append("Latitude: " + plantLatitude).append(":")
						.append("Longitude: " + plantLangitude).append("Order Latitude & Longitude:")
						.append("Latitude: " + shippingDetail.getLatitude()).append(":")
						.append("Longitude: " + shippingDetail.getLongitude());*/
			  allDetails.append(initialDistence).append("##")
				.append("Plant Details: ").append(plantLangitude).append(",").append(plantLatitude);
			 shortDist.put(shippingDetail.getDelivary(), allDetails);
		
			 StringBuilder allData = new StringBuilder();
			 allData.append("All Plant Distence from Receptive Order: ").append(orderNo).append("\n");
		  for (Map.Entry<Double, String> dist: distences.entrySet()) {
			System.out.println(dist.getValue()+"::"+dist.getKey());
			allData.append(dist.getValue()).append("::").append(dist.getKey());
			allData.append("\n");
		}
		  allData.append("\n");
		  System.out.println("#####SHORTEST DISTENCE FROM PLANT#####");
		  allData.append("#####SHORTEST DISTENCE FROM PLANT#####");
		  allData.append("\n");
		  for (Map.Entry<String, StringBuilder> dist : shortDist.entrySet()) {
			System.out.println("Order No: "+dist.getKey()+"::"+"Shortest Distence:"+dist.getValue());
			allData.append("Order No: "+dist.getKey()).append("::").append("Shortest Distence:"+dist.getValue());
		}
		  shortestDetails.setOrderNo(orderNo);
		return allData.toString();
		
	}
	
	public String getAllDistence(){
		  StoreSpDetails sd = new StoreSpDetails();
		  MapService gmapDist = new MapService();
		  List<ShippingDetails> shippingDetailsList = sd.getAllShippingDetails();
		  List<PlantDetails> plantDetailsList = sd.getAllPlantDetails();
			Map<String, ShippingDetails> shippingDetailsMap = sd.getAllShippingDetailsMap();
		  //List<Double> distences = new ArrayList<>();
		//	ShippingDetails shippingDetail = shippingDetailsMap.get();
			/*if(shippingDetail == null){
				return "Invaild OrderNo,Please enter vaild OrderNo";
			}*/
		  Map<Double, String> distences = new LinkedHashMap<>();
		  double initialDistence = 0.0;
		  Map<String, StringBuilder> shortDist = new HashMap<>();
		  String plantLangitude = "";
		  String plantLatitude = "";
		  int intitialDist = 1;
		  for (ShippingDetails shippingDetail : shippingDetailsList) {
			  for (PlantDetails plantDetails : plantDetailsList) {
				/*double distence =	distance(Double.parseDouble(shippingdetail.getLatitude()),
							Double.parseDouble(shippingdetail.getLongitude()),
							Double.parseDouble(plantDetails.getLatitude()), Double.parseDouble(plantDetails.getLongitude()),
							"K");*/
				  double distence = 0.0;
				  try {
					distence =gmapDist.getDistence(shippingDetail.getLatitude()+","+shippingDetail.getLongitude(), plantDetails.getLatitude()+","+plantDetails.getLongitude());
				} catch (IOException e) {
					System.out.println("Unbale to calculate distence :"+e.getCause());
					e.printStackTrace();
				}
	            if(intitialDist == 1) {
	            	initialDistence = distence;
	            }
				if(distence<initialDistence) {
					initialDistence = distence;
					plantLangitude = plantDetails.getPlantName();
					plantLatitude = plantDetails.getPlantState();
				}
				StringBuilder ord = new StringBuilder();
				ord.append("Order:" + shippingDetail.getDelivary()).append("##")
						.append("PlantName:" + plantDetails.getPlantName()).append("_")
						.append(plantDetails.getPlantState());
				distences.put(distence, ord.toString());
				intitialDist++;
			}
			  StringBuilder allDetails = new StringBuilder();
				/*allDetails.append(initialDistence).append("##")
						.append("Plant Latitude & Longitude:").append("Latitude: " + plantLatitude).append(":")
						.append("Longitude: " + plantLangitude).append("Order Latitude & Longitude:")
						.append("Latitude: " + shippingDetail.getLatitude()).append(":")
						.append("Longitude: " + shippingDetail.getLongitude());*/
			  allDetails.append(initialDistence).append("##")
				.append("Plant Details: ").append(plantLangitude).append(",").append(plantLatitude);
			 shortDist.put(shippingDetail.getDelivary(), allDetails);
	}
			 StringBuilder allData = new StringBuilder();
			 allData.append("All Plant Distence from Receptive Order: ").append("\n");
		  for (Map.Entry<Double, String> dist: distences.entrySet()) {
			System.out.println(dist.getValue()+"::"+dist.getKey());
			allData.append(dist.getValue()).append("::").append(dist.getKey());
			allData.append("\n");
		}
		  allData.append("\n");
		  System.out.println("#####SHORTEST DISTENCE FROM PLANT#####");
		  allData.append("#####SHORTEST DISTENCE FROM PLANT#####");
		  allData.append("\n");
		  for (Map.Entry<String, StringBuilder> dist : shortDist.entrySet()) {
			System.out.println("Order No: "+dist.getKey()+"::"+"Shortest Distence:"+dist.getValue());
			allData.append("Order No: "+dist.getKey()).append("::").append("Shortest Distence:"+dist.getValue());
			allData.append("\n");
		}
		return allData.toString();
		
	}
	public String getAllDistence1(){
		  StoreSpDetails sd = new StoreSpDetails();
		  MapService gmapDist = new MapService();
		  List<ShippingDetails> shippingDetailsList = sd.getAllShippingDetails();
		  List<PlantDetails> plantDetailsList = sd.getAllPlantDetails();
			Map<String, ShippingDetails> shippingDetailsMap = sd.getAllShippingDetailsMap();
		  //List<Double> distences = new ArrayList<>();
		//	ShippingDetails shippingDetail = shippingDetailsMap.get();
			/*if(shippingDetail == null){
				return "Invaild OrderNo,Please enter vaild OrderNo";
			}*/
		  Map<Double, String> distences = new LinkedHashMap<>();
		  double initialDistence = 0.0;
		  Map<String, StringBuilder> shortDist = new HashMap<>();
		  String plantLangitude = "";
		  String plantLatitude = "";
		  int intitialDist = 1;
		  //Date todayDate = Calendar.getInstance().getTime().getDate();
		//  Calendar.getInstance().get
		//  DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		  
	        //to convert Date to String, use format method of SimpleDateFormat class.
	      //  String todatdte = dateFormat.format(todayDate);
		  Map<Long, List<ShippingDetails>> groupBasedOnDays = new HashMap<>();
		  for (ShippingDetails shippingDetail : shippingDetailsList) {
			    String date = shippingDetail.getDate();
			  
			    LocalDate delivaryDate = LocalDate.parse(date);
			   // LocalDate currentDate = LocalDate.parse(todatdte);
			   Long noOfdays =  ChronoUnit.DAYS.between(LocalDate.now(), delivaryDate);
			  //int noOfDays = 
			   List<ShippingDetails> shippingList = groupBasedOnDays.get(noOfdays);
			   if(shippingList == null){
				   List<ShippingDetails> initialList = new ArrayList<>();
				   initialList.add(shippingDetail);
				   groupBasedOnDays.put(noOfdays, initialList);
			   } else {
				   shippingList.add(shippingDetail);
				   groupBasedOnDays.put(noOfdays, shippingList);
			   }
	}
		  System.out.println("Before sorting latitude and longtude");
		  for (Map.Entry<Long, List<ShippingDetails>> details : groupBasedOnDays.entrySet()) {
			          for (ShippingDetails shippingDetils : details.getValue()) {
				System.out.println("No Delivary Due Days: " + details.getKey() + "Shipping details:"
						+ shippingDetils.getLatitude() + ":Longitude:  " + shippingDetils.getLongitude());
					}
			   //System.out.println("Delivary Time Day due:"+details.getKey()+"##"+"NoOfOrders: "+details.getValue().size());
		}
		 
		  Map<Long, List<ShippingDetails>> afterSoringGroup= new HashMap<>();
		  for (Map.Entry<Long, List<ShippingDetails>> data : groupBasedOnDays.entrySet()) {
			  Collections.sort(data.getValue(),new Comparator<ShippingDetails>() {

				@Override
				public int compare(ShippingDetails o1, ShippingDetails o2) {
					return Double.compare(o1.getLatitude(), o2.getLatitude());
				}
			});
			  afterSoringGroup.put(data.getKey(), data.getValue());
		}
		  System.out.println("After sorting"); 
		  for (Map.Entry<Long, List<ShippingDetails>> details : afterSoringGroup.entrySet()) {
	          for (ShippingDetails shippingDetils : details.getValue()) {
		System.out.println("No Delivary Due Days: " + details.getKey() + "Shipping details:"
				+ shippingDetils.getLatitude() + ":Longitude:  " + shippingDetils.getLongitude());
			}
	   //System.out.println("Delivary Time Day due:"+details.getKey()+"##"+"NoOfOrders: "+details.getValue().size());
}
		  
			 StringBuilder allData = new StringBuilder();
			 allData.append("All Plant Distence from Receptive Order: ").append("\n");
		  for (Map.Entry<Double, String> dist: distences.entrySet()) {
			System.out.println(dist.getValue()+"::"+dist.getKey());
			allData.append(dist.getValue()).append("::").append(dist.getKey());
			allData.append("\n");
		}
		  allData.append("\n");
		  System.out.println("#####SHORTEST DISTENCE FROM PLANT#####");
		  allData.append("#####SHORTEST DISTENCE FROM PLANT#####");
		  allData.append("\n");
		  for (Map.Entry<String, StringBuilder> dist : shortDist.entrySet()) {
			System.out.println("Order No: "+dist.getKey()+"::"+"Shortest Distence:"+dist.getValue());
			allData.append("Order No: "+dist.getKey()).append("::").append("Shortest Distence:"+dist.getValue());
			allData.append("\n");
		}
		return allData.toString();
		
	}
	
	public void distence(){
		  StoreSpDetails sd = new StoreSpDetails();
		  MapService gmapDist = new MapService();
		  List<ShippingDetails> shippingDetailsList = sd.getAllShippingDetails();
		  List<PlantDetails> plantDetailsList = sd.getAllPlantDetails();
			Map<String, ShippingDetails> shippingDetailsMap = sd.getAllShippingDetailsMap();
		  //List<Double> distences = new ArrayList<>();
		  Map<Double, String> distences = new LinkedHashMap<>();
		  double initialDistence = 0.0;
		  Map<String, StringBuilder> shortDist = new HashMap<>();
		  double plantLangitude = 0.0;
		  double plantLatitude = 0.0;
		  for (ShippingDetails shippingdetail : shippingDetailsList) {
			  int intitialDist = 1;
			  for (PlantDetails plantDetails : plantDetailsList) {
				/*double distence =	distance(Double.parseDouble(shippingdetail.getLatitude()),
							Double.parseDouble(shippingdetail.getLongitude()),
							Double.parseDouble(plantDetails.getLatitude()), Double.parseDouble(plantDetails.getLongitude()),
							"K");*/
				  double distence = 0.0;
				  try {
					distence =gmapDist.getDistence(shippingdetail.getLatitude()+","+shippingdetail.getLongitude(), plantDetails.getLatitude()+","+plantDetails.getLongitude());
				} catch (IOException e) {
					System.out.println("Unbale to calculate distence :"+e.getCause());
					e.printStackTrace();
				}
	            if(intitialDist == 1) {
	            	initialDistence = distence;
	            }
				if(distence<initialDistence) {
					initialDistence = distence;
					plantLangitude = plantDetails.getLongitude();
					plantLatitude = plantDetails.getLatitude();
				}
				StringBuilder ord = new StringBuilder();
				ord.append("Order:"+shippingdetail.getDelivary()).append(":").append("PlantName:"+plantDetails.getPlantName()).append("_").append(plantDetails.getPlantState());
				distences.put(distence, ord.toString());
				intitialDist++;
			}
			  StringBuilder allDetails = new StringBuilder();
				allDetails.append(initialDistence).append("##")
						.append("Plant Latitude & Longitude:").append("Latitude: " + plantLatitude).append(":")
						.append("Longitude: " + plantLangitude).append("Order Latitude & Longitude:")
						.append("Latitude: " + shippingdetail.getLatitude()).append(":")
						.append("Longitude: " + shippingdetail.getLongitude());
			 shortDist.put(shippingdetail.getDelivary(), allDetails);
		}
		  for (Map.Entry<Double, String> dist: distences.entrySet()) {
			System.out.println(dist.getValue()+"::"+dist.getKey());
		}
		  System.out.println("#####SHORTEST DISTENCE FROM PLANT#####");
		  for (Map.Entry<String, StringBuilder> dist : shortDist.entrySet()) {
			System.out.println("Order No: "+dist.getKey()+"::"+"Shortest Distence:"+dist.getValue());
		}
		
	}
	
}
