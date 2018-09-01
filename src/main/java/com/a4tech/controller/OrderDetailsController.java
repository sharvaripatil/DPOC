package com.a4tech.controller;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.a4tech.daoService.OrdersDao;
import com.a4tech.shipping.model.Month;
import com.a4tech.shipping.model.Months;
import com.a4tech.shipping.model.OneDay;
import com.a4tech.shipping.model.Year;

@RestController
public class OrderDetailsController {
	@Autowired
	OrdersDao orderDao;
	
	
	@RequestMapping("/getMonthlyOrderCount/")
	public Months getMonthlyOrderCount(){
		Months monobj=new Months();
		  ArrayList<Month> list=new ArrayList<Month>();
	   try {
		    list=orderDao.getMonthly();
		    monobj.setArrList(list);
		//return orderDao.getMonthly();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return monobj;
	}
	@RequestMapping("/getYearlyOrderCount/")
	public Year getYearlyOrderCount() throws ClassNotFoundException{
		Year obj= orderDao.getYearly();
		//ModelAndView modelAndView = new ModelAndView("index");
	  //  modelAndView.addObject("yearData", obj);
	    return obj;
		
		//return obj;
		
	}

	@RequestMapping("/getDailyOrderCount/")
	public OneDay getDailyOrderCount() throws ClassNotFoundException{
		
		OneDay obObj=new OneDay();
		obObj=orderDao.getDaily();
	  return obObj;
  }
	public OrdersDao getOrderDao() {
		return orderDao;
	}
	public void setOrderDao(OrdersDao orderDao) {
		this.orderDao = orderDao;
	}

	
}
