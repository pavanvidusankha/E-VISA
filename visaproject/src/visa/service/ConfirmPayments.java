package visa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import visa.model.*;
import visa.util.*;

public class ConfirmPayments {
	
	public void checkPayment(Payment payment) {
		
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			connection = DBConnect.getDBConnection();

			preparedStatement = connection.prepareStatement("select country,a.vtype,days,scharge,dcharge from applyvisa a left outer join charges c on c.cid=a.vtype where id=?");
			preparedStatement.setInt(1, payment.getId());
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next())
			{
				payment.setCountry(rs.getString(1));
				payment.setVtype(rs.getInt(2));
				payment.setDays(rs.getInt(3));
				payment.setScharge(Double.parseDouble(rs.getString(4)));
				payment.setDcharge(Double.parseDouble(rs.getString(5)));
					
				
				if(payment.getVtype()==1) {
					payment.setCid(1);
					payment.setVvtype("Tourist");
					
				}else if(payment.getVtype()==2) {
					payment.setCid(2);
					payment.setVvtype("Business");
					
				}else if(payment.getVtype()==3) {
					payment.setCid(3);
					payment.setVvtype("Economic");
				
				}
				
			}
			
			preparedStatement.close();
			connection.close();
			
			
		} catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
		}

	}

}
