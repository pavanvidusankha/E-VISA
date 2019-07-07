package visa.service;

import java.sql.*;
import visa.model.Payment;
import visa.util.DBConnect;

public class CalculateCharge {
	
public void calPayment(Payment payment) {
		
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			connection = DBConnect.getDBConnection();
			
			preparedStatement = connection.prepareStatement("SELECT scharge,dcharge from charges where cid=?");
			preparedStatement.setInt(1, payment.getVtype());
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next())
			{
				payment.setScharge(Double.parseDouble(rs.getString(1)));
				payment.setDcharge(Double.parseDouble(rs.getString(2)));
				
			}
				
			preparedStatement.close();
			connection.close();
			
			
			
		} catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
		}

	}

}
