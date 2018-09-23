package com.a4tech.util;

import java.util.HashMap;
import java.util.Map;

public class TruckTypeInfo {
	static Map<String, String>  truckLoadType = new HashMap<>();
  static{
	  truckLoadType.put("GODDA", "Minimum");
	  truckLoadType.put("NAWADA", "Minimum");
  }
  
  public static String getTruckLoadType(String districtName){
	return  truckLoadType.get(districtName);
  }
  public static String getLoadType(String districtName){
	  String loadType = truckLoadType.get(districtName);
	  return "Minimum".equals(loadType)?"Normal Load":"Maximum Load(Extra 50%)";
  }
}
