package com.a4tech.shipping.ishippingDao;

import java.util.List;

import com.a4tech.dao.entity.ShippingEntity;

public interface IshippingOrderDao {
  public void saveShippingEntity(ShippingEntity shippingEntity);
  public List<ShippingEntity> getAllShippingOrders();
}
