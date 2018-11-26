package com.a4tech.shipping.services;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.a4tech.map.service.MapService;
import com.a4tech.shipping.model.PlantDetails;
import com.a4tech.shipping.model.ShippingDetails1;

import saveShipping.StoreSpDetails;

@Service("shippingService")
public class ShippingService {
	MapService gmapDist = new MapService();
	StoreSpDetails sd = new StoreSpDetails();
	
	public void getOrdersBasedOnDistence(Map<String, List<ShippingDetails1>> ordersOnDistricts){
		PlantDetails plantDetails = sd.getAllPlantDetails().get(2);
		String plantLongAndLatiVal = plantDetails.getLatitude()+","+plantDetails.getLongitude();
		
		for (Map.Entry<String, List<ShippingDetails1>> ords : ordersOnDistricts.entrySet()) {
			String dist = ords.getKey();
			List<ShippingDetails1> shippingDetails = ords.getValue();
			for (ShippingDetails1 shippingDetails1 : shippingDetails) {
				try {
					double maxDistence = gmapDist.getMaxDistenceFromMultipleDestination(
							plantLongAndLatiVal,
							shippingDetails1.getShip_to_latt()+","+shippingDetails1.getShip_to_long());
					

				} catch (IOException e) {
					System.out.println("Unbale to calculate distence :" + e.getCause());
					e.printStackTrace();
				}

			}
		}
		
	}

}
