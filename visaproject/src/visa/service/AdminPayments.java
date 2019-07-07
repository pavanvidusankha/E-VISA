package visa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import visa.model.Payment;
import visa.util.DBConnect;

public class AdminPayments {
	
public ArrayList<Payment> getPayments() {
		
		ArrayList<Payment> paymentList = new ArrayList<Payment>();
		Connection connection;
		PreparedStatement preparedStatement;
		try {
			
			connection = DBConnect.getDBConnection();
			preparedStatement = connection.prepareStatement("select id,user,country,vtype,days,total,ivisa,exvisa from payment");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				Payment payment = new Payment();
				
				payment.setId(Integer.parseInt(resultSet.getString(1)));
				payment.setUser(resultSet.getString(2));
				payment.setCountry(resultSet.getString(3));
				payment.setDays(Integer.parseInt(resultSet.getString(5)));
				payment.setCtotal(Double.parseDouble(resultSet.getString(6)));
				payment.setIvisa(resultSet.getString(7));
				payment.setExvisa(resultSet.getString(8));
				
				if(Integer.parseInt(resultSet.getString(4))==1) {
					
					payment.setVvtype("Tourist");
				
				}else if(Integer.parseInt(resultSet.getString(4))==2) {
					
					payment.setVvtype("Business");
					
				}else if(Integer.parseInt(resultSet.getString(4))==3){
					
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
