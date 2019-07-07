package visa.service;

import visa.model.User;
import java.sql.*;
import visa.util.*;

public class UserService {
	
	private int alreadyUser;
	
	public void addUser(User user) {
		Connection connection;
		PreparedStatement preparedStatement;
		try {
			connection = DBConnect.getDBConnection();

			preparedStatement = connection.prepareStatement("insert into user (name,username,password) values (?,?,?)");
			//preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.execute();
			//connection.commit();
			preparedStatement.close();
			connection.close();
			setAlreadyUser(0);
			
		} catch (ClassNotFoundException | SQLException  e) {

			setAlreadyUser(1);
		}

	}

	public int getAlreadyUser() {
		return alreadyUser;
	}

	public void setAlreadyUser(int alreadyUser) {
		this.alreadyUser = alreadyUser;
	}
}
