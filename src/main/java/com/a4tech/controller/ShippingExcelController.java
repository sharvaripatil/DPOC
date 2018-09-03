package com.a4tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.a4tech.service.mapper.IOrderDataMapper;

@RestController
public class ShippingExcelController {
	@Autowired
	private IOrderDataMapper dataMapper;
	
	@RequestMapping(value="/saveShippingMapping")
	public String saveShippingData(){
		dataMapper.mapper();
		return "ShippingOrderDetails has been saved successfully in DB";
  }
	
}
