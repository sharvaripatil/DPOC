package com.a4tech.shipping.ishippingDao;

import java.util.List;

import com.a4tech.dao.entity.DistrictWiseNormalLoadCapacity;
import com.a4tech.dao.entity.OrderGroupEntity;
import com.a4tech.dao.entity.ShippingDeliveryOrderEntity;
import com.a4tech.dao.entity.ShippingEntity;
import com.a4tech.dao.entity.TruckDetailsEntity;
import com.a4tech.dao.entity.TruckHistoryDetails;

public interface IshippingOrderDao {
  public void saveShippingEntity(ShippingEntity shippingEntity);
  public List<ShippingEntity> getAllShippingOrders();
  public List<ShippingEntity> getShippingDetailsByDate(String date);
  public List<TruckDetailsEntity> getAllTruckInfo();
  public void saveOrderGroup(OrderGroupEntity orderGroupEntity);
  public List<OrderGroupEntity> getALLGroupOrders();
  public List<OrderGroupEntity> getOrderGroupByDate(String date);
  public ShippingEntity getShippingDetails(String orderNo);
  public List<String> getOrderNoByTruck(String truckNo);
  public void updateOrderGroupFlag(String delivaryNo);
  public List<OrderGroupEntity> getLatitudeAndLongitude(String truckNo);
  public void deleteAllGroupOrders();
  public int generateShippingOrderId(ShippingDeliveryOrderEntity shippingDelivary);
  public List<DistrictWiseNormalLoadCapacity> getAllDistrictWiseLoads();
  public DistrictWiseNormalLoadCapacity getDistrictTruckLoad(String districtName);
  public List<TruckHistoryDetails> getAllTrucksHistoryDetails();
  public void saveTruckdetailsEntity(TruckDetailsEntity truckEntity);
}
