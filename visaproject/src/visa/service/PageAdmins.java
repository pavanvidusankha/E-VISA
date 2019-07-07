package visa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import visa.model.User;
import visa.util.DBConnect;

public class PageAdmins {
	
	public ArrayList<User> getUsers(String users) {
		
		ArrayList<User> userList = new ArrayList<User>();
		Connection connection;
		PreparedStatement preparedStatement;
		try {
			
			connection = DBConnect.getDBConnection();
			preparedStatement = connection.prepareStatement("select id,name,username from user where admin is not null and username<>?");
			preparedStatement.setString(1, users);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				User user = new User();
				
				user.setId(Integer.parseInt(resultSet.getString(1)));
				user.setName(resultSet.getString(2));
				user.setUsername(resultSet.getString(3));
				
				
				userList.add(user);
				
			}
			
			preparedStatement.close();
			connection.close();
		} catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
		}

		return userList;
	}

}
