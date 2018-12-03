package com.a4tech.shipping.services;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.a4tech.map.service.MapService;
import com.a4tech.shipping.iservice.IShippingOrder;
import com.a4tech.shipping.model.IntellishipModelByMaterial;
import com.a4tech.shipping.model.OrderGroup;
import com.a4tech.shipping.model.PlantDetails;
import com.a4tech.shipping.model.ShippingDeliveryOrder;
import com.a4tech.shipping.model.ShippingDetails1;
import com.a4tech.shipping.model.TruckDetails;
import com.a4tech.util.TruckTypeInfo;

import saveShipping.StoreSpDetails;

@Service("shippingService")
public class ShippingService {
	MapService gmapDist = new MapService();
	StoreSpDetails sd = new StoreSpDetails();
	@Autowired
	private IShippingOrder shippingOrderService;

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
	public Map<String, Map<List<ShippingDetails1>, List<TruckDetails>>> getOrdersFitIntoTruck(
			Map<String, Map<String, Map<Integer, List<ShippingDetails1>>>> groupByDistance) {
		// List<TruckDetails> initialTruckInfoList =
		// shippingOrder.getAllTruckInfo();
		List<ShippingDetails1> unGroupOrderList = new ArrayList<>();
		List<TruckDetails> allAssignedTrucksList = new ArrayList<>();
		Map<String, Map<List<ShippingDetails1>, List<TruckDetails>>> finalTruckDetails = new HashMap<>();
		for (Map.Entry<String, Map<String, Map<Integer, List<ShippingDetails1>>>> ordGrpList : groupByDistance.entrySet()) {
			String districtName = ordGrpList.getKey();
			Map<String, Map<Integer, List<ShippingDetails1>>> vals = ordGrpList.getValue();
			Map<List<ShippingDetails1>, List<TruckDetails>> truckAndOrderMap = new HashMap<>();
			for (Map.Entry<String, Map<Integer, List<ShippingDetails1>>> distanceByGroup : vals.entrySet()) {
				String materialName = distanceByGroup.getKey();
				Map<Integer, List<ShippingDetails1>> vals1 = distanceByGroup.getValue();
				for (Map.Entry<Integer, List<ShippingDetails1>> ordList : vals1.entrySet()) {
					List<TruckDetails> trucksList = new ArrayList<>();
					Integer orderDistance = ordList.getKey();
					List<ShippingDetails1> ordsList = ordList.getValue();
					/*if (ordsList.size() == 1) {// if single order contain for same
												// material ,no need to group the
												// that product
						unGroupOrderList.add(ordsList.get(0));
						continue;
					}*/
					String truckType = TruckTypeInfo.getTruckLoadType(districtName);
					
					int totOrdQty = ordsList.stream().map(ShippingDetails1::getActual_delivery_qty)
							.mapToInt(Integer::valueOf).sum();
					if ("Normal Load".equals(truckType)) {//means extra load type
						trucksList = getHeavyTruckList(trucksList, totOrdQty, allAssignedTrucksList);
						allAssignedTrucksList.addAll(trucksList);
					} else {// Rated Load 
						trucksList = getNormalTruckList(trucksList, totOrdQty, allAssignedTrucksList);
						allAssignedTrucksList.addAll(trucksList);
					}
					truckAndOrderMap.put(ordsList, trucksList);
				}	
			}
			//Map<List<ShippingDetails1>, List<TruckDetails>> truckAndOrderMap = new HashMap<>();
			
			finalTruckDetails.put(districtName, truckAndOrderMap);
		}
		return finalTruckDetails;
	}

	private List<TruckDetails> getHeavyTruckList(List<TruckDetails> groupTruckList, int totOrdQty,
			List<TruckDetails> allAssignedTrucksList) {
		List<TruckDetails> initialTruckInfoList = shippingOrderService.getAllTruckInfo();
		double initialTruckCap = totOrdQty - (totOrdQty * 0.5);
		TruckDetails initialTruckDetails = getTruckDetails(initialTruckInfoList, initialTruckCap);

		if (initialTruckDetails != null) {// if order qty is equal to truck
											// capacity
			initialTruckDetails = getOrderHeavyTruck(initialTruckInfoList, initialTruckDetails, allAssignedTrucksList);
			allAssignedTrucksList.add(initialTruckDetails);
			groupTruckList.add(initialTruckDetails);
			return groupTruckList;
		}
		TruckDetails tDetails = Collections.max(initialTruckInfoList,
				Comparator.comparing(TruckDetails::getVehicleType));// maximum
																	// truck
																	// details
		int truckMaxCapacity = tDetails.getVehicleType();
		double truckCarryCapacity = truckMaxCapacity + (truckMaxCapacity * 0.5);
		if (totOrdQty > truckCarryCapacity) {// order qty is greater than truck
												// capacity then orders into
												// split to assign another truck
			tDetails = getOrderHeavyTruck(initialTruckInfoList, tDetails, allAssignedTrucksList);
			allAssignedTrucksList.add(tDetails);
			groupTruckList.add(tDetails);
			double remainingOrdQty = Double.valueOf(totOrdQty) - truckCarryCapacity;
			groupTruckList = getHeavyGroupTruckDetails(initialTruckInfoList, remainingOrdQty, groupTruckList,
					allAssignedTrucksList);

		} else {

		}
		return groupTruckList;
	}
	private TruckDetails getOrderHeavyTruck(List<TruckDetails> allTrucksList, TruckDetails truckDetails,
			List<TruckDetails> assignedTruckList) {
		/*
		 * if(CollectionUtils.isEmpty(assignedTruckList)){ return truckDetails;
		 * }
		 */
		String truckNo = truckDetails.getSlNo();
		int truckCapacity = truckDetails.getVehicleType();
		double maxCapacity = truckCapacity + (truckCapacity * 0.5);
		truckDetails.setVehicleType((int) maxCapacity);
		String allTruckNos = assignedTruckList.stream().map(TruckDetails::getSlNo).collect(Collectors.joining(","));
		if (!allTruckNos.contains(truckNo)) {
			return truckDetails;
		} else {
			for (TruckDetails truckDtls : allTrucksList) {
				if (truckDtls.getVehicleType() == truckCapacity && !allTruckNos.contains(truckDtls.getSlNo())) {
					truckDtls.setVehicleType((int) maxCapacity);
					return truckDtls;
				}
			}
		}
		return truckDetails;
	}
	private TruckDetails getTruckDetails(List<TruckDetails> truckInfoList, double qty) {
		for (TruckDetails truckDetails : truckInfoList) {
			int truckCapacity = truckDetails.getVehicleType();
			double truckmaxCapacity = truckCapacity + (truckCapacity * 0.5);
			if (truckmaxCapacity == qty) {
				return truckDetails;
			}
		}
		return null;
	}
	private List<TruckDetails> getHeavyGroupTruckDetails(List<TruckDetails> truckInfoList, double qty,
			List<TruckDetails> truckGroupList, List<TruckDetails> allAssignedTrucksList) {
		if (qty < 8) {
			return truckGroupList;
		}
		TruckDetails maxTruckDetails = null;
		if (qty == 18.0) {
			maxTruckDetails = getMaxCapacityTruckDetails("", 12, truckInfoList);
		} else {
			maxTruckDetails = truckInfoList.stream().max(Comparator.comparing(TruckDetails::getVehicleType))
					.orElseThrow(NoSuchElementException::new);
		}

		int truckCapacity = maxTruckDetails.getVehicleType();
		if (truckCapacity == 27) {
			truckCapacity = 18;
		}
		String assignedTruckNo = allAssignedTrucksList.stream().map(TruckDetails::getSlNo)
				.collect(Collectors.joining(","));
		if (assignedTruckNo.contains(maxTruckDetails.getSlNo())) {
			maxTruckDetails = getMaxCapacityTruckDetails(assignedTruckNo, truckCapacity, truckInfoList);
		}
		double maxLoadcapacity = truckCapacity + (truckCapacity * 0.5);
		if (qty > maxLoadcapacity) {
			maxTruckDetails = getOrderHeavyTruck(truckInfoList, maxTruckDetails, allAssignedTrucksList);
			allAssignedTrucksList.add(maxTruckDetails);
			truckGroupList.add(maxTruckDetails);
			double remainingQty = qty - maxLoadcapacity;
			getHeavyGroupTruckDetails(truckInfoList, remainingQty, truckGroupList, allAssignedTrucksList);
		} else if (qty == maxLoadcapacity) {
			maxTruckDetails.setVehicleType((int) maxLoadcapacity);
			allAssignedTrucksList.add(maxTruckDetails);
			truckGroupList.add(maxTruckDetails);
		} else {
			double truckCap = qty - (qty * 0.5);
			TruckDetails tt = truckInfoList.stream()
					.reduce((result, current) -> Math.abs(truckCap - current.getVehicleType()) < Math
							.abs(truckCap - result.getVehicleType()) ? current : result)
					.get();
			int cap = tt.getVehicleType();
			double maxTruckLoad = cap + (cap * 0.5);
			double remCap = qty - maxTruckLoad;
			if (remCap > 8) {
				truckGroupList.add(tt);
				allAssignedTrucksList.add(tt);
				getHeavyGroupTruckDetails(truckInfoList, remCap, truckGroupList, allAssignedTrucksList);
			} else {
				truckGroupList.add(tt);
			}

		}
		return truckGroupList;
	}
	private TruckDetails getMaxCapacityTruckDetails(String allAssignedTrucks, int truckCapacity,
			List<TruckDetails> truckDetails) {
		for (TruckDetails truckDetails2 : truckDetails) {
			if (allAssignedTrucks.contains(truckDetails2.getSlNo())) {
				continue;
			} else {
				if (truckDetails2.getVehicleType() == truckCapacity) {
					return truckDetails2;
				}
			}
		}
		return null;
	}
	private List<TruckDetails> getNormalTruckList(List<TruckDetails> groupTruckList, int orderQty,
			List<TruckDetails> allAssignedTrucksList) {
		List<TruckDetails> initialTruckInfoList = shippingOrderService.getAllTruckInfo();
		TruckDetails maxTruckDetails = initialTruckInfoList.stream()
				.max(Comparator.comparing(TruckDetails::getVehicleType)).orElseThrow(NoSuchElementException::new);
		int truckMaxCapacity = maxTruckDetails.getVehicleType();
		if (orderQty > truckMaxCapacity) {// check order qty with max truck
											// capacity
			if (orderQty != truckMaxCapacity) {
				maxTruckDetails = getOrderTruck(initialTruckInfoList, maxTruckDetails, allAssignedTrucksList);
				allAssignedTrucksList.add(maxTruckDetails);
				groupTruckList.add(maxTruckDetails);
				truckMaxCapacity = maxTruckDetails.getVehicleType();
				int remainingOrderQty = orderQty - truckMaxCapacity;
				if (remainingOrderQty < 2) {
					return groupTruckList;
				}
				if (remainingOrderQty > truckMaxCapacity) {
					getNormalTruckList(groupTruckList, remainingOrderQty, allAssignedTrucksList);
				} else {// l
					TruckDetails truckDtls = getTruckDetails(initialTruckInfoList, remainingOrderQty, groupTruckList,
							allAssignedTrucksList);
					if (truckDtls != null) {
						allAssignedTrucksList.add(truckDtls);
						groupTruckList.add(truckDtls);
					} else {
						List<Integer> trucksCapacity = initialTruckInfoList.stream()
								.map(truck -> truck.getVehicleType()).collect(Collectors.toList());
						int capacityNo = trucksCapacity.stream()
								.min(Comparator.comparingInt(i -> Math.abs(i - remainingOrderQty)))
								.orElseThrow(() -> new NoSuchElementException("No value present"));
						truckDtls = getTruckDetails(initialTruckInfoList, capacityNo, groupTruckList,
								allAssignedTrucksList);
						if (truckDtls != null) {
							allAssignedTrucksList.add(truckDtls);
							groupTruckList.add(truckDtls);
						}
					}
					/*
					 * for (TruckDetails truckDetails : initialTruckInfoList) {
					 * if(truckDetails.getVehicleType() == remainingOrderQty){
					 * if(!isTruckGroup(groupTruckList,truckDetails.getSlNo())){
					 * truckDetails = getOrderTruck(initialTruckInfoList,
					 * truckDetails, allAssignedTrucksList);
					 * allAssignedTrucksList.add(truckDetails);
					 * groupTruckList.add(truckDetails); break; } } else {
					 * getfinalTruckList(groupTruckList, remainingOrderQty); } }
					 */

				}
			} else {// if allOrderQty and truck capacity is same

			}
		} else {// if orser qty is low compare to truck max capacity
			TruckDetails tDetails = Collections.min(initialTruckInfoList,
					Comparator.comparing(TruckDetails::getVehicleType));
			tDetails = getOrderTruck(initialTruckInfoList, tDetails, allAssignedTrucksList);
			allAssignedTrucksList.add(tDetails);
			groupTruckList.add(tDetails);

		}
		return groupTruckList;
	}
	private TruckDetails getOrderTruck(List<TruckDetails> allTrucksList, TruckDetails truckDetails,
			List<TruckDetails> assignedTruckList) {
		/*
		 * if(CollectionUtils.isEmpty(assignedTruckList)){ return truckDetails;
		 * }
		 */
		String truckNo = truckDetails.getSlNo();
		int truckCapacity = truckDetails.getVehicleType();
		String allTruckNos = assignedTruckList.stream().map(TruckDetails::getSlNo).collect(Collectors.joining(","));
		if (!allTruckNos.contains(truckNo)) {
			return truckDetails;
		} else {
			for (TruckDetails truckDtls : allTrucksList) {
				if (truckDtls.getVehicleType() == truckCapacity && !allTruckNos.contains(truckDtls.getSlNo())) {
					return truckDtls;
				}
			}
		}
		return truckDetails;
	}
	private TruckDetails getTruckDetails(List<TruckDetails> initialTruckInfoList, int orderQty,
			List<TruckDetails> groupTruckList, List<TruckDetails> allAssignedTrucksList) {

		for (TruckDetails truckDetails : initialTruckInfoList) {
			if (truckDetails.getVehicleType() == orderQty) {
				if (!isTruckGroup(groupTruckList, truckDetails.getSlNo())) {
					truckDetails = getOrderTruck(initialTruckInfoList, truckDetails, allAssignedTrucksList);
					return truckDetails;
				}
			}
		}
		return null;
	}
	private boolean isTruckGroup(List<TruckDetails> truckList, String truckNo) {
		String allTruckNos = truckList.stream().map(TruckDetails::getSlNo).collect(Collectors.joining(","));
		if (allTruckNos.contains(truckNo)) {
			return true;
		}
		return false;
	}
	public void getFinalOrdersClub(Map<String, Map<List<ShippingDetails1>, List<TruckDetails>>> finalTruckDetails) {
		List<String> trucksNoAssigned = new ArrayList<>();
			for (Map.Entry<String, Map<List<ShippingDetails1>, List<TruckDetails>>> data : finalTruckDetails.entrySet()) {
				String districtName = data.getKey();
				Map<List<ShippingDetails1>, List<TruckDetails>> ords = data.getValue();
				orderGroupByTruck1(ords,trucksNoAssigned);
			}
		}

		private void orderGroupByTruck1(Map<List<ShippingDetails1>, List<TruckDetails>> groupTruckMap,List<String> trucksNoAssigned) {
			for (Map.Entry<List<ShippingDetails1>, List<TruckDetails>> allDetails : groupTruckMap.entrySet()) {
				List<ShippingDetails1> ordersList = allDetails.getKey();
				// List<ShippingDetails1> ordersList =
				// intellship.getOrderDetailsList();
				// ordersList.stream().map(ShippingDetails1::getActual_delivery_qty).
				int allOrdsQtys = getAllOrdersQty(ordersList);
				List<TruckDetails> groupTruckDetails = allDetails.getValue();
				OrderGroup orderGroup = null;
				List<OrderGroup> orderGroupList = new ArrayList<>();
				Map<String, List<OrderGroup>> ordersMap = new HashMap<>();
				int totTrucks = groupTruckDetails.size();
				int trucksCount = 1;
				Map<String, List<OrderGroup>> ordersTruckMap = new HashMap<>();
				Date todaysDate = new Date();
				ShippingDeliveryOrder shippingDeliveryOrder = null; 
				for (TruckDetails truckDetails : groupTruckDetails) {
					shippingDeliveryOrder = new ShippingDeliveryOrder();
					int initialOrder = 1;
					int truckCapacity = truckDetails.getVehicleType();
					int ordersQtyTruck = 0;
					shippingDeliveryOrder.setTruckNo(truckDetails.getSlNo());
					shippingDeliveryOrder.setShippingDeliveryDate(todaysDate);
					int shippingDelivaryId = shippingOrderService.generateShippingOrderId(shippingDeliveryOrder);
					for (ShippingDetails1 orderDetails : ordersList) {
						orderGroup = new OrderGroup();
						int orderQty = Integer.parseInt(orderDetails.getActual_delivery_qty());
						if (isFullTruck(ordersTruckMap, truckCapacity, truckDetails.getSlNo())) {
							break;
						}
						if (isOrderQtyTruck(ordersMap, orderQty, orderDetails.getDelivery())) {// check
																								// is
																								// order
																								// load
																								// in
																								// truck
																								// or
																								// not,if
																								// order
																								// is
																								// loaded
																								// then
																								// skip
																								// those
																								// order
							continue;
						}
						int remaingTruckCapacity = 0;
						if (initialOrder != 1) {
							int truckOrdQty = truckCapacity - ordersQtyTruck;
							if (truckOrdQty < orderQty) {
								remaingTruckCapacity = truckOrdQty;
							} else {
								remaingTruckCapacity = orderQty;
							}
						}
						if (ordersMap.containsKey(orderDetails.getDelivery())) {
							remaingTruckCapacity = getRemainingOrderqQty(ordersMap, orderDetails.getDelivery());
							if (trucksCount != totTrucks && isLessOrderQty(ordersList, ordersMap, remaingTruckCapacity)) {
								continue;
							}
							if (initialOrder == 1) {
								orderQty = remaingTruckCapacity;
							}
						}
						orderGroup.setDelivaryNo(orderDetails.getDelivery());
						orderGroup.setOriginalOrderQty(orderDetails.getActual_delivery_qty());
						orderGroup.setTruckNo(truckDetails.getSlNo());
						orderGroup.setTruckCapacity(String.valueOf(truckDetails.getVehicleType()));
						orderGroup.setMaterialType(orderDetails.getMaterial());
						orderGroup.setDistrictName(orderDetails.getDistrict_name());
						orderGroup.setLatitude(orderDetails.getShip_to_latt());
						orderGroup.setLongitude(orderDetails.getShip_to_long());
						orderGroup.setNameShipToParty(orderDetails.getName_of_sold_to_party());
						orderGroup.setShippingDelivaryId(shippingDelivaryId);
						// shipping order Date
						Date todayDate = new Date();
						// LocalDate date = new date
						orderGroup.setOrderShippingDate(todayDate);
						LocalDateTime currentTime = LocalDateTime.now();
						LocalDate date = currentTime.toLocalDate();
						// orderGroup.setOrderShippingDate(date);
						// orderGroup.setOrderShippingDate(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
						if (initialOrder == 1) {
							if (orderQty > truckCapacity) {
								orderQty = truckCapacity;
							}
							orderGroup.setTruckOrderQty(orderQty);
							ordersQtyTruck = orderQty;
						} else {
							orderGroup.setTruckOrderQty(remaingTruckCapacity);
							ordersQtyTruck = ordersQtyTruck + remaingTruckCapacity;
						}
						orderGroup.setDelivaryDate(orderDetails.getDeliv_date());
						// orderGroupList.add(orderGroup);
						if (ordersMap.containsKey(orderDetails.getDelivery())) {
							List<OrderGroup> orderGroupsList = ordersMap.get(orderDetails.getDelivery());
							orderGroupsList.add(orderGroup);
							ordersMap.put(orderDetails.getDelivery(), orderGroupsList);
						} else {
							List<OrderGroup> orders = new ArrayList<>();
							orders.add(orderGroup);
							ordersMap.put(orderDetails.getDelivery(), orders);
						}
						// for checking trucks data
						if (ordersTruckMap.containsKey(orderGroup.getTruckNo())) {
							List<OrderGroup> orderGroupsTruckList = ordersTruckMap.get(orderGroup.getTruckNo());
							orderGroupsTruckList.add(orderGroup);
							ordersTruckMap.put(orderGroup.getTruckNo(), orderGroupsTruckList);
						} else {
							List<OrderGroup> ordersTruck = new ArrayList<>();
							ordersTruck.add(orderGroup);
							ordersTruckMap.put(orderGroup.getTruckNo(), ordersTruck);
						}

						initialOrder++;
						if (ordersQtyTruck == truckCapacity
								|| isOrderQtyTruck(ordersMap, allOrdsQtys, orderDetails.getDelivery())) {// truck
																											// is
																											// full
																											// with
																											// orders
							break;
						}
					}
					ordersTruckMap = new HashMap<>();
					// orderGroupList = new ArrayList<>();
					trucksCount++;
				} // end truck for loop
					// check all orders fit into truck or not

				for (Map.Entry<String, List<OrderGroup>> ords : ordersMap.entrySet()) {
					List<OrderGroup> ordGroup = ords.getValue();
					for (OrderGroup orderGroup2 : ordGroup) {
						shippingOrderService.saveOrderGroup(orderGroup2);
						shippingOrderService.updateOrderGroupFlag(orderGroup2.getDelivaryNo());
					}
				}
			}
		}

	
	
	private int getAllOrdersQty(List<ShippingDetails1> shippingDetailsList) {
		int ordQty = 0;
		for (ShippingDetails1 shippingDetails1 : shippingDetailsList) {
			ordQty = ordQty + Integer.parseInt(shippingDetails1.getActual_delivery_qty());
		}
		return ordQty;
	}
	private boolean isFullTruck(Map<String, List<OrderGroup>> ordersMap, int truckCapacity, String truckNo) {
		List<OrderGroup> orderGroupList = ordersMap.get(truckNo);
		if (CollectionUtils.isEmpty(orderGroupList)) {
			return false;
		}
		int trucksQty = 0;
		for (OrderGroup orderGroup : orderGroupList) {
			int qty = orderGroup.getTruckOrderQty();
			trucksQty = trucksQty + qty;
		}
		if (trucksQty == truckCapacity) {
			return true;
		}
		return false;
	}
	private boolean isOrderQtyTruck(Map<String, List<OrderGroup>> ordersMap, int allOrdersQty, String delivaryNo) {
		List<OrderGroup> orderGroupList = ordersMap.get(delivaryNo);
		if (CollectionUtils.isEmpty(orderGroupList)) {
			return false;
		}
		int ordQtyInTruck = 0;
		for (OrderGroup orderGroup : orderGroupList) {
			ordQtyInTruck = ordQtyInTruck + orderGroup.getTruckOrderQty();
		}
		if (allOrdersQty == ordQtyInTruck) {
			return true;
		}
		return false;
	}
	private int getRemainingOrderqQty(Map<String, List<OrderGroup>> ordersMap, String delivaryNo) {
		List<OrderGroup> orderGroupList = ordersMap.get(delivaryNo);
		int finalOrdQty = 0;
		for (OrderGroup orderGroup : orderGroupList) {
			int originalOrdQty = Integer.parseInt(orderGroup.getOriginalOrderQty());
			int truckOrdQty = orderGroup.getTruckOrderQty();
			finalOrdQty = originalOrdQty - truckOrdQty;
		}

		return finalOrdQty;
	}
	private boolean isLessOrderQty(List<ShippingDetails1> orderDetails, Map<String, List<OrderGroup>> ordsMap,
			int remainingOrder) {
		for (ShippingDetails1 shippingDetails1 : orderDetails) {
			if (!ordsMap.containsKey(shippingDetails1.getDelivery())) {
				int orderQty = Integer.parseInt(shippingDetails1.getActual_delivery_qty());
				if (orderQty > remainingOrder) {
					return true;
				}
			}
		}
		return false;
	}
	
	public List<IntellishipModelByMaterial> getFinalGroupOrders() {
		MapService gmapDist = new MapService();
		StoreSpDetails sd = new StoreSpDetails();
		List<PlantDetails> plantDetailsList = sd.getAllPlantDetails();
		PlantDetails plantDetails = plantDetailsList.get(2);
		List<OrderGroup> orderGroupList = shippingOrderService.getAllGroupOrderList();
		List<IntellishipModelByMaterial> finalIntelishipModel = new ArrayList<>();
		Map<String, List<OrderGroup>> groupBasedOnTruck = new HashMap<>();
		for (OrderGroup orderGroup : orderGroupList) {
			String truckNo = orderGroup.getTruckNo();
			List<OrderGroup> ordGroList = groupBasedOnTruck.get(truckNo);
			if (ordGroList != null) {
				ordGroList.add(orderGroup);
				groupBasedOnTruck.put(truckNo, ordGroList);
			} else {
				List<OrderGroup> ordGroupList = new ArrayList<>();
				ordGroupList.add(orderGroup);
				groupBasedOnTruck.put(truckNo, ordGroupList);
			}
		}
		IntellishipModelByMaterial intellishModel = null;
		Map<String, OrderGroup> pendingOrderMap = new HashMap<>();
		int shippingStatusCount = 1;
		for (Map.Entry<String, List<OrderGroup>> groupList : groupBasedOnTruck.entrySet()) {
			intellishModel = new IntellishipModelByMaterial();
			String truckNo = groupList.getKey();
			List<OrderGroup> orderGrpList = groupList.getValue();
			StringBuilder shippingLatitudeAndLonitude = new StringBuilder();
			double distence = 0.0;
			String duration = "";
			int totalOrdQty = 0;
			int ordQty = 0;
			int truckCapacity = 0;
			String districName = "";
			for (OrderGroup orderGrup : orderGrpList) {
				shippingLatitudeAndLonitude.append(orderGrup.getLatitude()).append(",")
						.append(orderGrup.getLongitude());
				shippingLatitudeAndLonitude.append("|");
				/*
				 * int pendingQty =
				 * getPendingOrderQuantity(orderGrup.getOriginalOrderQty(),
				 * orderGrup.getTruckCapacity(), orderGrup.getTruckOrderQty());
				 * if(pendingQty != 0){
				 * intellishModel.setPendingQuantity(pendingQty); }
				 */
				OrderGroup pendingOrder = pendingOrderMap.get(orderGrup.getDelivaryNo());
				if (pendingOrder != null) {
					ordQty = pendingOrder.getTruckOrderQty();
				}
				totalOrdQty = totalOrdQty + Integer.parseInt(orderGrup.getOriginalOrderQty());
				intellishModel.setLoadType(TruckTypeInfo.getLoadType(orderGrup.getDistrictName()));
				intellishModel.setMaterialType(orderGrup.getMaterialType());
				String truckType = TruckTypeInfo.getTruckLoadType(orderGrup.getDistrictName());
				districName = orderGrup.getDistrictName();
				if ("Minimum".equals(truckType)) {
					intellishModel.setTruckCapacity(orderGrup.getTruckCapacity());
				} else {
					int truckCap = Integer.parseInt(orderGrup.getTruckCapacity());
					int originalTruck = 0;
					if (truckCap == 27) {
						originalTruck = 18;
					} else if (truckCap == 18) {
						originalTruck = 12;
					} else {
						originalTruck = truckCap;
					}
					String finalTruckCap = originalTruck + "(" + truckCap + ")";
					intellishModel.setTruckCapacity(finalTruckCap);
				}

				intellishModel.setDistrictName(orderGrup.getDistrictName());
				truckCapacity = Integer.parseInt(orderGrup.getTruckCapacity());
				pendingOrderMap.put(orderGrup.getDelivaryNo(), orderGrup);
			}
			int pedningQty = totalOrdQty - truckCapacity;
			if (ordQty != 0) {
				pedningQty = pedningQty - ordQty;
				totalOrdQty = totalOrdQty - ordQty;
			}
			try {
				String distenceAndHrs = gmapDist.getMaxDistenceAndHrsFromMultipleDestination(
						plantDetails.getLatitude() + "," + plantDetails.getLongitude(),
						shippingLatitudeAndLonitude.toString());
				String[] data = distenceAndHrs.split("###");
				distence = Double.parseDouble(data[0]);
				duration = data[1];

			} catch (IOException e) {
				System.out.println("Unbale to calculate distence :" + e.getCause());
				e.printStackTrace();
			}

			/*
			 * if(districName.equals("GODDA")){ distence = 295.2; } else {
			 * distence = 342.6; }
			 */
			intellishModel.setTruckNo(truckNo);
			intellishModel.setTotalKilometers(String.valueOf(distence));
			intellishModel.setTotalOrders(orderGrpList.size());
			intellishModel.setTotalOrderQuantity(totalOrdQty);
			intellishModel.setPlant(plantDetails.getPlantName());
			intellishModel.setPendingQuantity(pedningQty);
			intellishModel.setShippingStatus(getShippingStatus(shippingStatusCount));
			intellishModel.setEstimationTime(duration);
			finalIntelishipModel.add(intellishModel);
			shippingStatusCount++;
		}
		return finalIntelishipModel;
	}
	private String getShippingStatus(int shippingStaNo) {
		String status = "";
		if (shippingStaNo == 1) {
			status = "In Transit";
		} else if (shippingStaNo == 2) {
			status = "Shipment Delivered";
		} else if (shippingStaNo == 3) {
			status = "Shipment picked up";
		} else {
			status = "In Transit";
		}
		return status;
	}
}
