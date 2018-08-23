package com.a4tech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShippingDetailController {
  
	@RequestMapping("/getShortestDistence")
	public String getShortDistence(){
	  return "This is shortest distence";
  }
}
