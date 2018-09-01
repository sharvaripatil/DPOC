package com.a4tech.daoService;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.connection.ConnectionProvider;
import org.hibernate.engine.SessionFactoryImplementor;
import org.hibernate.jdbc.Work;

import com.a4tech.shipping.model.Months;
import com.a4tech.shipping.model.OneDay;
import com.a4tech.shipping.model.Year;
import com.mysql.jdbc.Connection;

public class OrdersDao {
	SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public static  HashMap<String, String> monthMap = new HashMap<String, String>();
	static{
		monthMap.put("1", "January");
		monthMap.put("2", "February");
		monthMap.put("3", "March");
		monthMap.put("4", "April");
		monthMap.put("5", "May");
		monthMap.put("6", "June");
		monthMap.put("7", "July");
		monthMap.put("8", "August");
		monthMap.put("9", "September");
		monthMap.put("10", "October");
		monthMap.put("11", "November");
		monthMap.put("12", "December");
	}
	
	public  ArrayList<Months> getMonthly() throws ClassNotFoundException {

		ArrayList<Months> monthsList =new ArrayList<Months>(); 
		Session session = null;
		 java.sql.Connection connection = null ;
				try{
				/*	Transaction tx  = null;
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=(Connection) DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/shipdetail","root","root");  */
					//tx =  session.beginTransaction();
					 session = sessionFactory.openSession();
					 session.doWork(
							 new Work() {
							 @Override
							public void execute(java.sql.Connection connection)
									throws SQLException {
								 
								 String sql = "{call shipcountDetails(?,?)}";
							        java.sql.CallableStatement callableStatement  = connection.prepareCall(sql);
							        callableStatement.registerOutParameter("monthnumber", java.sql.Types.INTEGER);  
							        callableStatement.registerOutParameter("TotalCount", java.sql.Types.INTEGER);  
							        //callableStatement.execute();  
							        ResultSet rs1 = callableStatement.executeQuery();
							        
							        Months monthObj=new Months();
							            while (rs1.next()) {
							            	monthObj=new Months();
							            	monthObj.setMonth(monthMap.get(rs1.getString("monthnumber") ));
							            	monthObj.setTotalOrder(rs1.getString("TotalCount"));
							            	monthsList.add(monthObj);
							              /*  System.out.println(rs1.getString("monthnumber") + " "
							                        + rs1.getString("TotalCount"));*/
							                       
							            }
							            rs1.close();
							            callableStatement.close();
							            connection.close();
								
							}
							 }
							 );
				        }finally{
				    		if(session !=null){
				    			try{
				    				session.close();
				    			}catch(Exception ex){
				    				System.out.println(ex.getMessage());
				    			}	
				    		}
				    	}	
				return monthsList;
					
				//}catch(Exception e){ System.out.println(e);}  
				
	
	}
	
	public Year getYearly() throws ClassNotFoundException {

		Year yrObj=new Year(); 
		Session session = null;
		try{
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection con=(Connection) DriverManager.getConnection(  
//		"jdbc:mysql://localhost:3306/shipdetail","root","root");  
		        
		        
		        session = sessionFactory.openSession();
		        session.doWork(new Work() {

					@Override
					public void execute(java.sql.Connection connection)
							throws SQLException {
						   String sql = "{call ship_yearly(?)}";
					        java.sql.CallableStatement callableStatement  = connection.prepareCall(sql);
					        callableStatement.registerOutParameter("TotalCount", java.sql.Types.INTEGER);  
					        //callableStatement.execute();  
					        ResultSet rs1 = callableStatement.executeQuery();
					            while (rs1.next()) {
					            	yrObj.setTotalNumberOforders(rs1.getString("TotalCount"));
					            }
					            rs1.close();
					            callableStatement.close();
					            connection.close();
						
					}
		        	
		        });
		     
		            
		        }finally{
		    		if(session !=null){
		    			try{
		    				session.close();
		    			}catch(Exception ex){
		    				
		    			}	
		    		}
		    	}	
		return yrObj;
		
		

	}
	
	public OneDay getDaily() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Session session = null;
		OneDay oneDay=new OneDay(); 
				try{
			/*	Class.forName("com.mysql.jdbc.Driver");
				Connection con=(Connection) DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/shipdetail","root","root");  */
				
				 session = sessionFactory.openSession();
				 session.doWork(new Work() {
					
					@Override
					public void execute(java.sql.Connection connection) throws SQLException {
						 String sql = "{call OneDayData(?)}";
					        java.sql.CallableStatement callableStatement  = connection.prepareCall(sql);
					        callableStatement.registerOutParameter("TotalCount", java.sql.Types.INTEGER);  
					        //callableStatement.execute();  
					        ResultSet rs1 = callableStatement.executeQuery();
					            while (rs1.next()) {
					            	oneDay.setTotalCount(rs1.getString("TotalCount"));
					            }
					            rs1.close();
					            callableStatement.close();
					            connection.close();
						
					}
				});
				       
				            
				        }finally{
				    		if(session !=null){
				    			try{
				    				session.close();
				    			}catch(Exception ex){
				    				
				    			}	
				    		}
				    	}	
				return oneDay;
				
				
	
	}
}
