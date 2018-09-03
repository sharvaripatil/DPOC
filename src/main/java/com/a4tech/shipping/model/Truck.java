package com.a4tech.shipping.model;

public class Truck {
	public String slno;
	public String vehicleno;
	public int vehicletype;
	
	public int inKg;
	public int inTonne;
	public String wheels;
		public String entrytype;

		public String getSlno(){
			return slno;
		}

		public void setSlno(String slno){
			this.slno=slno;
		}

		public String getVehicleno(){
			return vehicleno;
		}

		public void setVehicleno(String vehicleno){
			this.vehicleno=vehicleno;
		}

		public int getVehicletype(){
			return vehicletype;
		}

		public void setVehicletype(int vehicletype){
			this.vehicletype=vehicletype;
		}

		public String getWheels(){
			return wheels;
		}

		public void setWheels(String wheels){
			this.wheels=wheels;
		}

		public String getEntrytype(){
			return entrytype;
		}

		public void setEntrytype(String entrytype){
			this.entrytype=entrytype;
		}

		public int getInKg() {
			return inKg;
		}

		public void setInKg(int inKg) {
			this.inKg = inKg;
		}

		public int getInTonne() {
			return inTonne;
		}

		public void setInTonne(int inTonne) {
			this.inTonne = inTonne;
		}
		
	}