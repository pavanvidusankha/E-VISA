package visa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import visa.model.User;
import visa.util.DBConnect;

public class AdminToUser {

	public void createUser(User user) {
		
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			connection = DBConnect.getDBConnection();

			preparedStatement = connection.prepareStatement("update user set admin=null where id=?");
			preparedStatement.setInt(1, user.getId());
			preparedStatement.execute();
			//connection.commit();
			preparedStatement.close();
			connection.close();
			
			
		} catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
			
		}

	}
	
}
