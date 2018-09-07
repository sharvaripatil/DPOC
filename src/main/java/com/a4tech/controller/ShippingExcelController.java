package com.a4tech.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.a4tech.service.mapper.IOrderDataMapper;

@RestController
public class ShippingExcelController {
	@Autowired
	private IOrderDataMapper dataMapper;
	private Logger _LOGGER = Logger.getLogger(ShippingExcelController.class);
	@RequestMapping(value="/saveShippingMapping")
	public String saveShippingData(){
		dataMapper.mapper();
		_LOGGER.info("ShippingOrderDetails has been saved successfully in DB");
		return "ShippingOrderDetails has been saved successfully in DB";
  }
	
}
