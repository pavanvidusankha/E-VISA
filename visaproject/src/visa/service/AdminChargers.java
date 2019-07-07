package visa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import visa.model.Payment;
import visa.util.DBConnect;

public class AdminChargers {
	
public ArrayList<Payment> getCharge() {
		
		ArrayList<Payment> paymentList = new ArrayList<Payment>();
		Connection connection;
		PreparedStatement preparedStatement;
		try {
			
			connection = DBConnect.getDBConnection();
			preparedStatement = connection.prepareStatement("select cid,scharge,dcharge from charges");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				Payment payment = new Payment();
				
				payment.setCid(Integer.parseInt(resultSet.getString(1)));
				payment.setScharge(Double.parseDouble(resultSet.getString(2)));
				payment.setDcharge(Double.parseDouble(resultSet.getString(3)));
				
				if(Integer.parseInt(resultSet.getString(1))==1) {
					
					payment.setVvtype("Tourist");
				
				}else if(Integer.parseInt(resultSet.getString(1))==2) {
					
					payment.setVvtype("Business");
					
				}else if(Integer.parseInt(resultSet.getString(1))==3){
					
					payment.setVvtype("Economic");
					
				}
				
				paymentList.add(payment);
				
			}
			
			preparedStatement.close();
			connection.close();
		} catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
		}

		return paymentList;
	}

}
