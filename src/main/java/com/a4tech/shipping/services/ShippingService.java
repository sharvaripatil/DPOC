package com.a4tech.shipping.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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

	public Map<String, Map<String, Map<Integer, List<ShippingDetails1>>>> getOrdersBasedOnDistence(
			Map<String, Map<String, List<ShippingDetails1>>> finalMaterialOrd) {
		PlantDetails plantDetails = sd.getAllPlantDetails().get(2);
		String plantLongAndLatiVal = plantDetails.getLatitude() + "," + plantDetails.getLongitude();
		Map<String, Map<String, Map<Integer, List<ShippingDetails1>>>> districtByMap = new HashMap<>();
		for (Map.Entry<String, Map<String, List<ShippingDetails1>>> materialGroups : finalMaterialOrd.entrySet()) {
			String districtName = materialGroups.getKey();
			Map<String, List<ShippingDetails1>> ordersOnDistricts = materialGroups.getValue();
			Map<String, Map<Integer, List<ShippingDetails1>>> matrialByMap = new HashMap<>();
			for (Map.Entry<String, List<ShippingDetails1>> ords : ordersOnDistricts.entrySet()) {
				String materialName = ords.getKey();
				List<ShippingDetails1> shippingDetails = ords.getValue();
				Map<Integer, List<ShippingDetails1>> distanceOrdersMap = new HashMap<>();
				List<ShippingDetails1> ordersList = null;
				for (ShippingDetails1 shippingDetails1 : shippingDetails) {
					try {
						double maxDistance = gmapDist.getMaxDistenceFromMultipleDestination(plantLongAndLatiVal,
								shippingDetails1.getShip_to_latt() + "," + shippingDetails1.getShip_to_long());
						Integer distanceBand = getDistanceBand(maxDistance);
						if (distanceOrdersMap.containsKey(distanceBand)) {
							ordersList = distanceOrdersMap.get(distanceBand);
							ordersList.add(shippingDetails1);
							distanceOrdersMap.put(distanceBand, ordersList);
						} else {
							ordersList = new ArrayList<>();
							ordersList.add(shippingDetails1);
							distanceOrdersMap.put(distanceBand, ordersList);
						}

					} catch (IOException e) {
						System.out.println("Unbale to calculate distence :" + e.getCause());
						e.printStackTrace();
					}

				}
				matrialByMap.put(materialName, distanceOrdersMap);
			}
			districtByMap.put(districtName, matrialByMap);
		}
		return districtByMap;
	}

	public Integer getDistanceBand(double distance) {
		Integer distanceBand;
		if (distance <= 50) {
			distanceBand = 50;
		} else if (distance >= 51 && distance <= 100) {
			distanceBand = 100;
		} else if (distance >= 101 && distance <= 150) {
			distanceBand = 150;
		} else if (distance >= 151 && distance <= 200) {
			distanceBand = 200;
		} else if (distance >= 201 && distance <= 250) {
			distanceBand = 250;
		} else if (distance >= 251 && distance <= 300) {
			distanceBand = 300;
		} else {// distance is greater than 300KM +
			distanceBand = 350;
		}
		return distanceBand;
	}

}
