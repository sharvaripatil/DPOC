package com.a4tech.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import saveShipping.StoreSpDetails;

import com.a4tech.map.service.MapService;
import com.a4tech.mapper.ShippingMapping;
import com.a4tech.shipping.model.PlantDetails;
import com.a4tech.shipping.model.ShippingDetails;

@RestController
public class ShippingDetailController {
  
	ShippingMapping shippingMapping;
	
	@RequestMapping("/getShortestDistence/{orderNo}")
	public String getShortDistence(@PathVariable("orderNo") String orderNo){
		System.out.println(orderNo);
	  return getDistence(orderNo);
  }
	@RequestMapping("/getAllShortestDistence/")
	public String getAllShortDistence(){
	  return getAllDistence();
  }
	
	@RequestMapping("/getShippingMapping/")
	public void saveShippingExcel(){
		shippingMapping.mapper();
		System.out.println("Test");
  }
	public String getDistence(String orderNo){
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
		  String plantLangitude = "";
		  String plantLatitude = "";
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
					plantLangitude = plantDetails.getPlantName();
					plantLatitude = plantDetails.getPlantState();
				}
				StringBuilder ord = new StringBuilder();
				ord.append("PlantName:"+plantDetails.getPlantName()).append("_").append(plantDetails.getPlantState());
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
		  String plantLangitude = "";
		  String plantLatitude = "";
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
	public ShippingMapping getShippingMapping() {
		return shippingMapping;
	}
	public void setShippingMapping(ShippingMapping shippingMapping) {
		this.shippingMapping = shippingMapping;
	}
}
