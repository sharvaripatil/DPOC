package saveShipping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.a4tech.shipping.model.PlantDetails;
import com.a4tech.shipping.model.ShippingDetails;

public class StoreSpDetails {
	public List<ShippingDetails> getAllShippingDetails(){
		List<ShippingDetails> shippingDetailsList = new ArrayList<>();
		ShippingDetails sd1 = new ShippingDetails();
		sd1.setDelivary("8106908338");
		sd1.setMaterilaType("FBCCLPP50DT");
		sd1.setQty("15");
		sd1.setLongitude("84.186004611111");
		sd1.setLatitude("24.364315027778");
		ShippingDetails sd2 = new ShippingDetails();
		sd2.setDelivary("8106911121");
		sd2.setMaterilaType("FBCCLPP50DT");
		sd2.setQty("10");
		sd2.setLongitude("83.9018673");
		sd2.setLatitude("24.2282742");
		ShippingDetails sd3 = new ShippingDetails();
		sd3.setDelivary("8106903755");
		sd3.setMaterilaType("PCCPP50T");
		sd3.setQty("9");
		sd3.setLongitude("87.213518");
		sd3.setLatitude("24.825522");
				shippingDetailsList.add(sd1);
				shippingDetailsList.add(sd2);
				shippingDetailsList.add(sd3);
		return shippingDetailsList;
	}
	
	public List<PlantDetails> getAllPlantDetails(){
		List<PlantDetails> plantrDetailslist = new ArrayList<>();
		PlantDetails pd = new PlantDetails();
		pd.setPlantName("Adhunik Cement Ltd");
		pd.setPlantState("MEGHALAYA");
		pd.setLatitude("22.5367134");
		pd.setLongitude("88.3542665");
		PlantDetails pd2 = new PlantDetails();
		pd2.setPlantName("Dalmia Cement (Bharat) Ltd- Kadapa");
		pd2.setPlantState("ANDHRA PRADESH");
		pd2.setLatitude("14.9306781");
		pd2.setLongitude("78.3385713");
		PlantDetails pd3 = new PlantDetails();
		pd3.setPlantName("Dalmia Cement East Limited - Bakaro");
		pd3.setPlantState("JHARKHAND");
		pd3.setLatitude("23.7012517");
		pd3.setLongitude("86.0591489");
		plantrDetailslist.add(pd);
		plantrDetailslist.add(pd2);
		plantrDetailslist.add(pd3);
		return plantrDetailslist;
	}
	public Map<String, ShippingDetails> getAllShippingDetailsMap(){
		List<ShippingDetails> shippingDetailsList = new ArrayList<>();
		Map<String, ShippingDetails> shippingDetailsMap = new HashMap<>();
		ShippingDetails sd1 = new ShippingDetails();
		sd1.setDelivary("8106908338");
		sd1.setMaterilaType("FBCCLPP50DT");
		sd1.setQty("15");
		sd1.setLongitude("84.186004611111");
		sd1.setLatitude("24.364315027778");
		shippingDetailsMap.put("8106908338", sd1);
		ShippingDetails sd2 = new ShippingDetails();
		sd2.setDelivary("8106911121");
		sd2.setMaterilaType("FBCCLPP50DT");
		sd2.setQty("10");
		sd2.setLongitude("83.9018673");
		sd2.setLatitude("24.2282742");
		shippingDetailsMap.put("8106911121", sd2);
		ShippingDetails sd3 = new ShippingDetails();
		sd3.setDelivary("8106903755");
		sd3.setMaterilaType("PCCPP50T");
		sd3.setQty("9");
		sd3.setLongitude("87.213518");
		sd3.setLatitude("24.825522");
		shippingDetailsMap.put("8106903755", sd3);
				
		return shippingDetailsMap;
	}
}
