package com.a4tech.controller;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.a4tech.daoService.OrdersDao;
import com.a4tech.shipping.model.Material;
import com.a4tech.shipping.model.Materials;
import com.a4tech.shipping.model.Month;
import com.a4tech.shipping.model.Months;
import com.a4tech.shipping.model.OneDay;
import com.a4tech.shipping.model.Truck;
import com.a4tech.shipping.model.Trucks;
import com.a4tech.shipping.model.Weight;
import com.a4tech.shipping.model.Year;

@RestController
@RequestMapping({ "/","/DPOC","/getDashboard" })
public class OrderDetailsController {
	@Autowired
	OrdersDao orderDao;
	/*@RequestMapping("/getDashboard")
    public String searchHandler() {
        String redirectUrl = "index";
         
        return new String (redirectUrl );
    }*/
	@RequestMapping(value = "/getDashboard", method = RequestMethod.GET)
    public RedirectView redirect() {
 return new RedirectView("http://localhost:8085/DPOC/");
    }
    
	/*@RequestMapping(value = "/getDashboard", method = RequestMethod.GET)
	   public String redirect() {
	      return "index";
	   }*/
	/*
	@RequestMapping(value = "/DPOC", method = RequestMethod.GET)
	   public String redirect1() {
	      return "redirect:index";
	   }*/
	
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
	    return obj;
		
		
	}
	
	@RequestMapping("/getTotalEpodCount/")
	public Year getTotalEpodCount() throws ClassNotFoundException{
		Year obj= orderDao.getTotalEpod();
	    return obj;
		
	}
	
	@RequestMapping("/getTotalWt/")
	public Weight getTotalWt() throws ClassNotFoundException{
		Weight obj= orderDao.getTotalWt();
	    return obj;
		
	}

	@RequestMapping("/getDailyOrderCount/")
	public OneDay getDailyOrderCount() throws ClassNotFoundException{
		
		OneDay obObj=new OneDay();
		obObj=orderDao.getDaily();
	  return obObj;
  }
	
	
	@RequestMapping("/getTrucks/")
	public Trucks getTrucks() throws ClassNotFoundException{
		Trucks trucks=new Trucks();
		ArrayList<Truck> trucksList=new ArrayList<Truck>();
		trucksList=orderDao.getTrucksData();
		trucks.setTrucksList(trucksList);
	  return trucks;
  }
	public OrdersDao getOrderDao() {
		return orderDao;
	}
	public void setOrderDao(OrdersDao orderDao) {
		this.orderDao = orderDao;
	}

	@RequestMapping("/getMaterials/")
	public Materials getgetMaterialswt(){
		Materials matObj=new Materials();
		  ArrayList<Material> matlist=new ArrayList<Material>();
	   try {
		   matlist=orderDao.getMatrlWt();
		   matObj.setMatrlList(matlist);
		//return orderDao.getMonthly();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return matObj;
	}
	
	
	@RequestMapping("/getTraderInfo/")
	public Materials getTraderInfo(){
		Materials matObj=new Materials();
		  ArrayList<Material> matlist=new ArrayList<Material>();
	   try {
		   matlist=orderDao.getTraderInfo();
		   matObj.setMatrlList(matlist);
		//return orderDao.getMonthly();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return matObj;
	}
	
	@RequestMapping("/getEpodInfo/")
	public Materials getEpodInfo(){
		Materials matObj=new Materials();
		  ArrayList<Material> matlist=new ArrayList<Material>();
	   try {
		   matlist=orderDao.getEpodInfo();
		   matObj.setMatrlList(matlist);
		//return orderDao.getMonthly();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return matObj;
	}
}
