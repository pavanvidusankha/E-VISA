package visa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import visa.model.Payment;
import visa.util.DBConnect;

public class ChargersChange {
	
public void change(Payment payment) {
		
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			connection = DBConnect.getDBConnection();
			
			preparedStatement = connection.prepareStatement("UPDATE charges set scharge=?,dcharge=? where cid=?");
			preparedStatement.setDouble(1, payment.getScharge());
			preparedStatement.setDouble(2, payment.getDcharge());
			preparedStatement.setInt(3, payment.getCid());
			preparedStatement.execute();	
			
			preparedStatement.close();
			connection.close();
			
			
			
		} catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
		}

	}

}
