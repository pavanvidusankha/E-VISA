package visa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import visa.model.*;
import visa.util.DBConnect;

public class UpdateUser {
	
	public void updateUser(Profile user) {
		Connection connection;
		PreparedStatement preparedStatement;
		try {
			connection = DBConnect.getDBConnection();

			preparedStatement = connection.prepareStatement("UPDATE user SET password=? where username=?");
			preparedStatement.setString(1, user.getPassword());
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.execute();
			//connection.commit();
			
			
			
		} catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
			
		}

	}

}
